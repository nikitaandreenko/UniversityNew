package com.company.service;

import com.company.model.Student;
import com.company.model.Teacher;
import com.company.repository.StudentRepository;

import java.util.Comparator;

public class StudentService{
    private StudentRepository studentRepository = new StudentRepository();

    public StudentService (){
    }
    public void addStudent(Student student){
       studentRepository.addStudent(student);
    }
    public void deleteStudent (Student student){
        studentRepository.deleteStudent(student);
    }
    public void setStudent(int pos, Student student){
        studentRepository.setStudent(pos, student);
    }

    public void sortedStudents (StudentRepository studentRepository){
        studentRepository
                .students.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
