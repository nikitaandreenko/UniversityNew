package com.company.service;

import com.company.model.Student;
import com.company.model.Teacher;
import com.company.repository.StudentRepository;
import com.company.util.ReadingFiles;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentService {

    public StudentRepository studentRepository;

    public StudentService() {
        studentRepository = new StudentRepository();
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public List<Student> getAllStudents(List<Student> studentsNew) {
        studentRepository.getAllStudents(studentsNew);
        return studentRepository.students;
    }

    public Student getByIdStudent(int id, StudentRepository studentRepository) {
        return studentRepository.getByIdStudent(id, studentRepository.students);
    }

    public void updateStudent(int id, Student student) {
        studentRepository.updateStudent(id, student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

    public void sortedStudents(StudentService studentService) {
        studentRepository
                .students.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
