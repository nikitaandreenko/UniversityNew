package com.company.repository;

import com.company.model.Student;
import com.company.model.Teacher;
import com.company.util.ReadingFiles;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {

    public List<Teacher> teachers;

    public TeacherRepository() {
        this.teachers = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Teacher> getAllTeachers(List<Teacher> teachersNew) {
        teachers.addAll(teachersNew);
        return teachers;
    }

    public Teacher getByIdTeacher(int id, List<Teacher> teachers) {
        for (Teacher th : teachers) {
            if (th.getId() == id) {
                return th;
            }
        }
        return null;
    }

    public void updateTeacher(int id, Teacher teacher) {
        for (Teacher th : teachers) {
            if (th.getId() == id) {
                teachers.set(id, teacher);
            }
        }
    }

    public void deleteTeacher(int id) {
        for (Teacher th : teachers) {
            if (th.getId() == id) {
                teachers.remove(th);
            }
        }
    }
}
