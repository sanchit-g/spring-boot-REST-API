package com.springrest.springRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TableCreator implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private void createCourseTable() {
        String query1 = "CREATE TABLE IF NOT EXISTS course(id int primary key, title varchar(255), description varchar(255))";
        jdbcTemplate.update(query1);
        createStudentsTable();
    }

    private void createStudentsTable() {
        String query2 = "CREATE TABLE IF NOT EXISTS students(student_id int primary key, firstName varchar(255), lastName varchar(255))";
        jdbcTemplate.update(query2);
        createEnrollmentsTable();
    }

    private void createEnrollmentsTable() {
        String query3 = "CREATE TABLE IF NOT EXISTS enrollments(enroll_id int primary key, student_id int NOT NULL, course_id int NOT NULL, FOREIGN KEY (student_id) references students(student_id), FOREIGN KEY (course_id) references course(id))";
        jdbcTemplate.update(query3);
    }

    @Override
    public void run(String... args) throws Exception {
        createCourseTable();
    }
}
