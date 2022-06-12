package com.company.util.tests;

import com.company.model.Address;
import com.company.model.Student;
import com.company.repository.StudentRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentRepositoryTest {

    Address addressStudent7;
    Address addressStudent8;
    Address addressStudent9;
    Student student7;
    Student student8;
    Student student9;
    StudentRepository studentRepository;


    @Before
    public void setUp() throws Exception {
        studentRepository = new StudentRepository();
        addressStudent7 = new Address("Moscow", "Marksa", 13, 167);
        addressStudent8 = new Address("Rasan", "Radugnaja", 20, 11);
        addressStudent9 = new Address("Grodno", "Naberegnaja", 25, 67);
        student7 = new Student("Basilij", "Ivanov", 17, addressStudent7, "male");
        student8 = new Student("Svetlana", "Kravtsova", 18, addressStudent8, "female");
        student9 = new Student("Kristina", "Pavlova", 18, addressStudent9, "female");
        studentRepository.addStudent(student7);
        studentRepository.addStudent(student8);
        studentRepository.addStudent(student9);
    }
    @Test
    public void addStudent() {
        Address addressNewStudent = new Address("London", "Wall street", 13, 125);
        Student newStudent = new Student("Mike", "Dowson", 21, addressNewStudent, "male");
        studentRepository.addStudent(newStudent);
        Assert.assertNotNull(studentRepository.students);
        Assert.assertEquals(4, studentRepository.students.size());
        Assert.assertEquals(studentRepository.students.get(3), newStudent);
    }

    @Test
    public void deleteStudent() {
        studentRepository.deleteStudent(student7);
        Assert.assertNotNull(studentRepository.students);
        Assert.assertEquals(2, studentRepository.students.size());
        Assert.assertEquals(studentRepository.students.get(0), student8);
    }
    @After
    public void tearDown() throws Exception {
    }
}