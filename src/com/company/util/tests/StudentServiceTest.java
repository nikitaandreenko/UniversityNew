package com.company.util.tests;

import com.company.model.Address;
import com.company.model.Student;
import com.company.service.StudentService;
import com.company.util.ReadingFiles;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {
    StudentService studentServiceAllStudents;
    StudentService studentService1;


    @Before
    public void setUp() throws Exception {

        studentServiceAllStudents = new StudentService();
        studentServiceAllStudents.addStudentsGroup(ReadingFiles.studentsFiles("students.txt"));
        studentService1 = new StudentService();
        studentService1.addStudent(studentServiceAllStudents.studentRepository.students.get(0));
        studentService1.addStudent(studentServiceAllStudents.studentRepository.students.get(1));
        studentService1.addStudent(studentServiceAllStudents.studentRepository.students.get(2));

    }

    @Test
    public void addStudent() {

        studentService1.addStudent(studentServiceAllStudents.studentRepository.students.get(9));
        Assert.assertNotNull(studentService1.studentRepository.students);
        Assert.assertEquals(4, studentService1.studentRepository.students.size());
        Assert.assertEquals(studentService1.studentRepository.students.get(3),
                studentServiceAllStudents.studentRepository.students.get(9));
    }

    @Test
    public void deleteStudent() {
        studentService1.deleteStudent(studentService1.studentRepository.students.get(1));
        Assert.assertNotNull(studentService1.studentRepository.students);
        Assert.assertEquals(2, studentService1.studentRepository.students.size());
        Assert.assertEquals(studentService1.studentRepository.students.get(1),
                studentServiceAllStudents.studentRepository.students.get(2));
    }

    @After
    public void tearDown() throws Exception {
    }
}