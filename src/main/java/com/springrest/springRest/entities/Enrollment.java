package com.springrest.springRest.entities;

public class Enrollment {
    private int enroll_id;
    private int student_id;
    private int course_id;

    public int getEnroll_id() {
        return enroll_id;
    }

    public void setEnroll_id(int enroll_id) {
        this.enroll_id = enroll_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enroll_id=" + enroll_id +
                ", student_id=" + student_id +
                ", course_id=" + course_id +
                '}';
    }
}
