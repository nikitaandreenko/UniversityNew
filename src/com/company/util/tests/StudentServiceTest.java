package com.company.util.tests;

import com.company.model.Address;
import com.company.model.Student;
import com.company.service.StudentService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {

    Address addressStudent7;
    Address addressStudent8;
    Address addressStudent9;
    Student student7;
    Student student8;
    Student student9;
    StudentService studentService;


    @Before
    public void setUp() throws Exception {
       studentService = new StudentService();
        addressStudent7 = new Address("Moscow", "Marksa", 13, 167);
        addressStudent8 = new Address("Rasan", "Radugnaja", 20, 11);
        addressStudent9 = new Address("Grodno", "Naberegnaja", 25, 67);
        student7 = new Student("Basilij", "Ivanov", 17, addressStudent7, "male");
        student8 = new Student("Svetlana", "Kravtsova", 18, addressStudent8, "female");
        student9 = new Student("Kristina", "Pavlova", 18, addressStudent9, "female");
        studentService.addStudent(student7);
        studentService.addStudent(student8);
        studentService.addStudent(student9);
    }
    @Test
    public void addStudent() {
        Address addressNewStudent = new Address("London", "Wall street", 13, 125);
        Student newStudent = new Student("Mike", "Dowson", 21, addressNewStudent, "male");
        studentService.addStudent(newStudent);
        Assert.assertNotNull(studentService.studentRepository.students);
        Assert.assertEquals(4, studentService.studentRepository.students.size());
        Assert.assertEquals(studentService.studentRepository.students.get(3), newStudent);
    }

    @Test
    public void deleteStudent() {
        studentService.deleteStudent(student7);
        Assert.assertNotNull(studentService.studentRepository.students);
        Assert.assertEquals(2, studentService.studentRepository.students.size());
        Assert.assertEquals(studentService.studentRepository.students.get(0), student8);
    }
    @After
    public void tearDown() throws Exception {
    }
}