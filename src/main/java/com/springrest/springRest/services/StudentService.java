package com.springrest.springRest.services;

import com.springrest.springRest.entities.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudents();
    public int addStudent(Student student);
    public int updateStudent(Student student);
    public int deleteStudent(long studentId);
}
