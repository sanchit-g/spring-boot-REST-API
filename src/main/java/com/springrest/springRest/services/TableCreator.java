package com.springrest.springRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TableCreator implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String query = "CREATE TABLE IF NOT EXISTS course(id int primary key, title varchar(255), description varchar(255))";
        jdbcTemplate.update(query);
    }
}
