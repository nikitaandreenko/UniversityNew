package com.company.repository;

import com.company.model.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TeacherRepository {

    public ArrayList<Teacher> teachers;
    public TeacherRepository() {
    this.teachers = new ArrayList<>();
    }
    public void addTeacher (Teacher teacher) {
        teachers.add(teacher);
    }

    public void deleteTeacher (Teacher teacher){
        teachers.remove(teacher);
    }

    public void setTeacher (int pos,Teacher teacher){
        teachers.set(pos,teacher);
    }
}
