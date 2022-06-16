package com.company.util.tests;

import com.company.model.Address;
import com.company.model.Student;
import com.company.service.StudentService;
import com.company.util.ReadingFiles;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeopleAgeTest {
    StudentService studentService;
    Student student;

    @Before
    public void setUp() throws Exception {
        studentService = new StudentService();
        studentService.addStudentsGroup(ReadingFiles.studentsFiles("students.txt"));
        student = studentService.studentRepository.students.get(0);
    }

    @Test
    public void setAge() {
        student.setAge(20);
        Assert.assertTrue(student.getAge() == 20);
        student.setAge(-5);
        Assert.assertEquals(0, student.getAge());
        Assert.assertFalse(student.getAge() == -5);
    }

    @After
    public void tearDown() throws Exception {
    }


}