package com.company.model;

import com.company.repository.StudentRepository;
import com.company.service.StudentService;

import java.util.ArrayList;

public class Group {
    private int name;
    private int course;
    private ArrayList <Student> students;
    private Teacher teacher;
    private int yearAdmission;
    private int yearGraduation;

    public Group(int name, int course, ArrayList <Student> students, Teacher teacher, int yearAdmission, int yearGraduation) {
        this.name = name;
        this.course = course;
        this.students = students;
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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
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
                ", students=" + students +
                ", teacher=" + teacher +
                ", yearAdmission=" + yearAdmission +
                ", yearGraduation=" + yearGraduation +
                '}';
    }
}
