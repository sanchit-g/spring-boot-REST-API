package com.springrest.springRest.controller;

import com.springrest.springRest.entities.Course;
import com.springrest.springRest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

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

    // get a single course using id
    @GetMapping("/course")
    public Course getCourseById(@RequestParam String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    // get a single course using title
//    @GetMapping("/course")
//    public List<Course> getCourseByName(@RequestParam String title) {
//        return this.courseService.getCourse(title);
//    }

    // add a new course
    @PostMapping("/courses")
    public int addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
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
