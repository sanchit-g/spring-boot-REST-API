package com.springrest.springRest.services;

import com.springrest.springRest.entities.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();
    public Course getCourse(long courseId);
    public int addCourse(Course course);
    public int updateCourse(Course course);
    public void deleteCourse(long parseLong);
    public List<Course> getCourse(String title);
}
