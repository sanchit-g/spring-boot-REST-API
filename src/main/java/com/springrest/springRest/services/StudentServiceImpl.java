package com.springrest.springRest.services;

import com.springrest.springRest.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentServiceImpl implements StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getStudents() {
        String query = "SELECT * FROM students";
        StudentMapper studentMapper = new StudentMapper();
        return jdbcTemplate.query(query, studentMapper);
    }
}
