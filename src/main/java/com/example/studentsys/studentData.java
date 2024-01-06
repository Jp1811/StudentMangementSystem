package com.example.studentsys;

import java.util.Date;

public class studentData {
    private Integer studentId;
    private String year;
    private String course;
    private String firstName;
    private String lastName;
    private String sex;
    private Date birth;
    private String status;
    private Double firstSem;
    private Double secondSem;
    private Double finals;


    public studentData(Integer studentId, String year, String course, String firstName, String lastName, String sex, Date birth, String status) {
        this.studentId = studentId;
        this.year = year;
        this.course = course;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birth = birth;
        this.status = status;
    }

    public studentData(Integer studentId, String year, String course, Double firstSem, Double secondSem, Double finals) {
        this.studentId = studentId;
        this.year = year;
        this.course = course;
        this.firstSem = firstSem;
        this.secondSem = secondSem;
        this.finals = finals;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getYear() {
        return year;
    }

    public String getCourse() {
        return course;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirth() {
        return birth;
    }

    public String getStatus() {
        return status;
    }

    public Double getFirstSem() {
        return firstSem;
    }

    public Double getSecondSem() {
        return secondSem;
    }

    public Double getFinals() {
        return finals;
    }
}
