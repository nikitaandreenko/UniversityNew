package com.company.service;

import com.company.model.Student;
import com.company.model.Teacher;
import com.company.repository.StudentRepository;
import com.company.util.ReadingFiles;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Comparator;

public class StudentService{

    public StudentRepository studentRepository;

    public StudentService (){
        studentRepository = new StudentRepository();
    }
    public void addStudent(Student student){
       studentRepository.addStudent(student);
    }

    public void addStudentsGroup (ArrayList<Student> studentsNew) {
        studentRepository.addStudentsGroup(studentsNew);
    }
    public void deleteStudent (Student student){
        studentRepository.deleteStudent(student);
    }
    public void setStudent(int pos, Student student){
        studentRepository.setStudent(pos, student);
    }


    public void sortedStudents (StudentService studentService){
        studentRepository
                .students.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
