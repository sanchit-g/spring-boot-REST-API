package com.springrest.springRest.services;

import com.springrest.springRest.entities.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollService implements EnrollmentService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int enroll(Enrollment data) {
        String query = "INSERT INTO enrollments (enroll_id, student_id, course_id) VALUES (:enrollId, :studentId, :courseId)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("enrollId", data.getEnroll_id());
        namedParameters.addValue("studentId", data.getStudent_id());
        namedParameters.addValue("courseId", data.getCourse_id());
        return namedParameterJdbcTemplate.update(query, namedParameters);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        String query = "SELECT * FROM enrollments";
        EnrollmentMapper enrollmentMapper = new EnrollmentMapper();
        return jdbcTemplate.query(query, enrollmentMapper);
    }

    @Override
    public List<String> getEnrollmentsById(Long id) {
        String query = "SELECT title FROM course c JOIN enrollments e ON c.id = e.course_id JOIN students s ON e.student_id = s.student_id WHERE s.student_id = ?";
        return jdbcTemplate.query(query, new ResultSetExtractor<List<String>>() {
            @Override
            public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<String> resultList = new ArrayList<>();
                while(rs.next()) {
                    resultList.add(rs.getString("title"));
                }
                return resultList;
            }
        }, id);
    }
}
