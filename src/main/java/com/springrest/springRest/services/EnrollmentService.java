package com.springrest.springRest.services;

import com.springrest.springRest.entities.Enrollment;

import java.util.List;

public interface EnrollmentService {
    public int enroll(Enrollment data);
    public List<Enrollment> getAllEnrollments();
    public List<String> getEnrollmentsById(Long id);
}
