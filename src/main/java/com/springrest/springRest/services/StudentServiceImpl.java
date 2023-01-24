package com.springrest.springRest.services;

import com.springrest.springRest.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentServiceImpl implements StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Student> getStudents() {
        String query = "SELECT * FROM students";
        StudentMapper studentMapper = new StudentMapper();
        return jdbcTemplate.query(query, studentMapper);
    }

    @Override
    public int addStudent(Student student) {
        String query = "INSERT INTO students (student_id, firstName, lastName) VALUES (:id, :first_name, :last_name)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", student.getStudent_id());
        namedParameters.addValue("first_name", student.getFirstName());
        namedParameters.addValue("last_name", student.getLastName());
        return namedParameterJdbcTemplate.update(query, namedParameters);
    }

    @Override
    public int updateStudent(Student student) {
        String query = "UPDATE students SET firstName = :first_name, lastName = :last_name WHERE student_id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", student.getStudent_id());
        namedParameters.addValue("first_name", student.getFirstName());
        namedParameters.addValue("last_name", student.getLastName());
        return namedParameterJdbcTemplate.update(query, namedParameters);
    }

    @Override
    public int deleteStudent(long studentId) {
        String query = "DELETE FROM students WHERE student_id = :id";
        MapSqlParameterSource namedParameter = new MapSqlParameterSource();
        namedParameter.addValue("id", studentId);
        return namedParameterJdbcTemplate.update(query, namedParameter);
    }
}
