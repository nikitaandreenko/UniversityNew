package com.company.model;

import com.company.repository.StudentRepository;
import com.company.service.StudentService;

import java.util.ArrayList;

public class Group {
    private int name;
    private int course;
    private StudentService studentService;
    private Teacher teacher;
    private int yearAdmission;
    private int yearGraduation;

    public Group(int name, int course, StudentService studentService, Teacher teacher, int yearAdmission, int yearGraduation) {
        this.name = name;
        this.course = course;
        this.studentService = studentService;
        this.teacher = teacher;
        this.yearAdmission = yearAdmission;
        this.yearGraduation = yearGraduation;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }


    public StudentService studentService() {
        return studentService;
    }

    public void setStudentRepository(StudentService studentService) {
        this.studentService = studentService;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getYearAdmission() {
        return yearAdmission;
    }

    public void setYearAdmission(int yearAdmission) {
        this.yearAdmission = yearAdmission;
    }

    public int getYearGraduation() {
        return yearGraduation;
    }

    public void setYearGraduation(int yearGraduation) {
        this.yearGraduation = yearGraduation;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name=" + name +
                ", course=" + course +
                ", students=" + studentService +
                ", teacher=" + teacher +
                ", yearAdmission=" + yearAdmission +
                ", yearGraduation=" + yearGraduation +
                '}';
    }
}
