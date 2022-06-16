package com.company.repository;

import com.company.model.Teacher;
import com.company.util.ReadingFiles;

import java.util.ArrayList;

public class TeacherRepository {

    public ArrayList<Teacher> teachers;

    public TeacherRepository () {
        this.teachers = new ArrayList<>();
    }
    public void addTeacher (Teacher teacher) {
        teachers.add(teacher);
    }

    public void addTeachersGroup (ArrayList<Teacher> teachersNew){
        teachers.addAll(teachersNew);
    }

    public void deleteTeacher (Teacher teacher){
        teachers.remove(teacher);
    }

    public void setTeacher (int pos,Teacher teacher){
        teachers.set(pos,teacher);
    }
}
