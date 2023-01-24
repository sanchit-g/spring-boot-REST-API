package com.springrest.springRest.controller;

import com.springrest.springRest.entities.Course;
import com.springrest.springRest.entities.Enrollment;
import com.springrest.springRest.entities.Req;
import com.springrest.springRest.entities.Student;
import com.springrest.springRest.kafka.EnrollmentProducer;
import com.springrest.springRest.services.CourseService;
import com.springrest.springRest.services.EnrollmentService;
import com.springrest.springRest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EnrollmentProducer enrollmentProducer;

    // home page
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "This is home page.";
    }

    // get all courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    // get a single course using id or name
    @GetMapping("/course")
    public Course getCourseById(@RequestBody Req req) {
        if (req.filter.equals("CourseId")) {
            return this.courseService.getCourseById(Long.parseLong(req.value));
        } else {
            return this.courseService.getCourseByName(req.value);
        }
    }

    // add a new course
    @PostMapping("/courses")
    public int addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }


    // enroll a student in a course
    @PostMapping("/enroll")
    public int enroll(@RequestBody Enrollment data) {
        enrollmentProducer.sendMessage(data);
        return this.enrollmentService.enroll(data);
    }

    // get all enrollments
    @GetMapping("/enrollments")
    public List<Enrollment> getAllEnrollments() {
        return this.enrollmentService.getAllEnrollments();
    }

    @GetMapping("/enrollments/{id}")
    public List<String> getEnrollmentsById(@PathVariable String id) {
        return this.enrollmentService.getEnrollmentsById(Long.parseLong(id));
    }

    // get all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    // add a new student
    @PostMapping("/students")
    public int addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    // update a course
    @PutMapping("/courses")
    public int updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    // update a student
    @PutMapping("/students")
    public int updateStudent(@RequestBody Student student) {
        return this.studentService.updateStudent(student);
    }

    // delete a course using course id
    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {
        this.courseService.deleteCourse(Long.parseLong(courseId));
    }

    // delete a student using student id
    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable String studentId) {
        this.studentService.deleteStudent(Long.parseLong(studentId));
    }
}