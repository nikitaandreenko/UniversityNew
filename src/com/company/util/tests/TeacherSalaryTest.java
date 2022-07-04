package com.company.util.tests;

import com.company.service.TeacherService;
import com.company.util.ReadingFiles;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeacherSalaryTest {

    TeacherService teacherService;



    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void setTeacherService() {
        teacherService = new TeacherService();
        teacherService.getAllTeachers(ReadingFiles.teachersFiles("teachers.txt"));
        int salaryTeacher1Expected = 2000;
        teacherService.setSalaryTeacher(2, teacherService.teacherRepository.teachers.get(0));
        int salaryTeacher1actual = teacherService.getSalaryTeacher(teacherService.teacherRepository.teachers.get(0));
        teacherService.setSalaryTeacher(2, teacherService.teacherRepository.teachers.get(1));
        int salaryTeacher2actual = teacherService.getSalaryTeacher(teacherService.teacherRepository.teachers.get(1));
        teacherService.setSalaryTeacher(3, teacherService.teacherRepository.teachers.get(2));
        int salaryTeacher3actual = teacherService.getSalaryTeacher(teacherService.teacherRepository.teachers.get(2));
        Assert.assertEquals(salaryTeacher1Expected, salaryTeacher1actual);
        Assert.assertTrue(salaryTeacher1actual==salaryTeacher2actual);
        Assert.assertNotEquals(salaryTeacher1actual,salaryTeacher3actual);

    }
    @After
    public void tearDown() throws Exception {
    }


}