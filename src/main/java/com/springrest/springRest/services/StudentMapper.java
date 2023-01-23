package com.springrest.springRest.services;

import com.springrest.springRest.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setStudent_id(rs.getInt("student_id"));
        student.setFirstName(rs.getString("firstName"));
        student.setLastName(rs.getString("lastName"));

        return student;
    }
}
