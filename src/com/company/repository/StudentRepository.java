package com.company.repository;

import com.company.model.Student;
import com.company.util.ReadingFiles;

import java.util.ArrayList;

public class StudentRepository {

    ReadingFiles readingFiles;
    public ArrayList<Student> students;

    public StudentRepository(){
        this.students = new ArrayList<>();
    }

    public void addStudent (Student student){
        students.add(student);
    }
    public void addStudentsGroup (ArrayList<Student> studentsNew){
        students.addAll(studentsNew);
    }
    public void deleteStudent (Student student){
        students.remove(student);
    }
    public void setStudent (int pos, Student student){
        students.set(pos, student);
    }

}
