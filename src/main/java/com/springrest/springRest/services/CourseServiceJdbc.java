package com.springrest.springRest.services;

import com.springrest.springRest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseServiceJdbc implements CourseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Course> getCourses() {
        String query = "SELECT * FROM course";
        RowMapper<Course> courseRowMapper = new CourseMapper();
        return namedParameterJdbcTemplate.query(query, courseRowMapper);
    }

    @Override
    public Course getCourse(long courseId) {
        String query = "SELECT * FROM course WHERE id = :id";
        MapSqlParameterSource namedParameter = new MapSqlParameterSource();
        namedParameter.addValue("id", courseId);
        RowMapper<Course> courseRowMapper = new CourseMapper();
//        return jdbcTemplate.queryForObject(query, courseId);
        return namedParameterJdbcTemplate.queryForObject(query, namedParameter, courseRowMapper);
    }

    @Override
    public List<Course> getCourse(String title) {
        String query = "SELECT * FROM course WHERE title = :title";
        MapSqlParameterSource namedParameter = new MapSqlParameterSource().addValue("title", title);
        return namedParameterJdbcTemplate.query(query, namedParameter, new CourseMapper());
    }

    @Override
    public int addCourse(Course course) {
        String query = "INSERT INTO course (id, title, description) VALUES (:id, :title, :description)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", course.getId());
        namedParameters.addValue("title", course.getTitle());
        namedParameters.addValue("description", course.getDescription());
        return namedParameterJdbcTemplate.update(query, namedParameters);
    }

    @Override
    public int updateCourse(Course course) {
        String query = "UPDATE course SET title = :title, description = :description WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", course.getId());
        namedParameters.addValue("title", course.getTitle());
        namedParameters.addValue("description", course.getDescription());
        return namedParameterJdbcTemplate.update(query, namedParameters);
    }

    @Override
    public void deleteCourse(long parseLong) {
        String query = "DELETE FROM course WHERE id = :id";
        MapSqlParameterSource namedParameter = new MapSqlParameterSource();
        namedParameter.addValue("id", parseLong);
        namedParameterJdbcTemplate.update(query, namedParameter);
    }
}
