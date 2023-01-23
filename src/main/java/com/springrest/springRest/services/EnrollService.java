package com.springrest.springRest.services;

import com.springrest.springRest.entities.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EnrollService implements EnrollmentService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int enroll(Enrollment data) {
        String query = "INSERT INTO enrollments (enroll_id, student_id, course_id) VALUES (:enrollId, :studentId, :courseId)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("enrollId", data.getEnroll_id());
        namedParameters.addValue("studentId", data.getStudent_id());
        namedParameters.addValue("courseId", data.getCourse_id());
        return namedParameterJdbcTemplate.update(query, namedParameters);
    }
}
