package com.company.repository;

import com.company.model.Student;
import com.company.util.ReadingFiles;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    ReadingFiles readingFiles;
    public List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents(List<Student> studentsNew) {
        students.addAll(studentsNew);
        return students;
    }

    public Student getByIdStudent(int id, List<Student> students) {
        for (Student st : students) {
            if (st.getId() == id) {
                return st;
            }
        }
        return null;
    }

    public void updateStudent(int id, Student student) {
        for (Student st : students) {
            if (st.getId() == id) {
                students.set(id, student);
            }
        }
    }

    public void deleteStudent(int id) {
        for (Student st : students) {
            if (st.getId() == id) {
                students.remove(st);
            }
        }
    }
}
