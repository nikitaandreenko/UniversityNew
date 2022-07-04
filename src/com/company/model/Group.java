package com.company.model;

import com.company.repository.StudentRepository;
import com.company.service.StudentService;

import java.util.ArrayList;

public class Group {
    private int groupId;
    private int name;
    private int course;
    private int yearAdmission;
    private int yearGraduation;

    public Group() {
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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
                ", yearAdmission=" + yearAdmission +
                ", yearGraduation=" + yearGraduation +
                '}';
    }
}
