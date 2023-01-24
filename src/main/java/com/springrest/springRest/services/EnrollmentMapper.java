package com.springrest.springRest.services;

import com.springrest.springRest.entities.Enrollment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentMapper implements RowMapper<Enrollment> {
    @Override
    public Enrollment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Enrollment enrollment = new Enrollment();
        enrollment.setEnroll_id(rs.getInt("enroll_id"));
        enrollment.setStudent_id(rs.getInt("student_id"));
        enrollment.setCourse_id(rs.getInt("course_id"));
        return enrollment;
    }
}
