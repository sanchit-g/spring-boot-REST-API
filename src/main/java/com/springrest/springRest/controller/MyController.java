package com.springrest.springRest.controller;

import com.springrest.springRest.entities.Course;
import com.springrest.springRest.entities.Enrollment;
import com.springrest.springRest.entities.Req;
import com.springrest.springRest.entities.Student;
import com.springrest.springRest.kafka.EnrollmentProducer;
import com.springrest.springRest.kafka.JsonKafkaProducer;
import com.springrest.springRest.kafka.KafkaProducer;
import com.springrest.springRest.services.CourseService;
import com.springrest.springRest.services.EnrollmentService;
import com.springrest.springRest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

//    private KafkaProducer kafkaProducer;

//    private JsonKafkaProducer jsonKafkaProducer;

//    @Autowired
//    public MyController(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }

//    @Autowired
//    public MyController(JsonKafkaProducer jsonKafkaProducer) {
//        this.jsonKafkaProducer = jsonKafkaProducer;
//    }

//    @GetMapping("/publish")
//    public ResponseEntity<String> publish(@RequestParam("message") String message) {
//        kafkaProducer.sendMessage(message);
//        return ResponseEntity.ok("Message sent to the topic.");
//    }

//    @PostMapping("/publish")
//    public ResponseEntity<String> publish(@RequestBody Student student) {
//        jsonKafkaProducer.sendMessage(student);
//        return ResponseEntity.ok("JSON Message sent to Kafka Topic.");
//    }

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

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    // update a course using PUT request
    @PutMapping("/courses")
    public int updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    // delete a course using id
    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {
        this.courseService.deleteCourse(Long.parseLong(courseId));
    }
}