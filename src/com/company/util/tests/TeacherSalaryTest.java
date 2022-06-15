package com.company.util.tests;

import com.company.model.Address;
import com.company.model.Teacher;
import com.company.service.TeacherService;
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
        Address addressTeacher1 = new Address("New York", "5 avenu", 24, 137);
        Teacher teacher1 = new Teacher("Vanessa", "Uotson", 65, addressTeacher1, "female");
        Address addressTeacher2 = new Address("Alabama", "7 street", 25, 138);
        Teacher teacher2 = new Teacher("Shon", "Petersen", 25, addressTeacher2, "male");
        Address addressTeacher3 = new Address("Otava", "10 street", 67, 123);
        Teacher teacher3 = new Teacher("Samanta", "Robson", 67, addressTeacher3, "female");
        teacherService = new TeacherService();
        int salaryTeacher1Expected = 2000;
        teacherService.setSalaryTeacher(2, teacher1);
        int salaryTeacher1actual = teacherService.getSalaryTeacher(teacher1);
        teacherService.setSalaryTeacher(2, teacher2);
        int salaryTeacher2actual = teacherService.getSalaryTeacher(teacher2);
        teacherService.setSalaryTeacher(3, teacher3);
        int salaryTeacher3actual = teacherService.getSalaryTeacher(teacher3);
        Assert.assertEquals(salaryTeacher1Expected, salaryTeacher1actual);
        Assert.assertTrue(salaryTeacher1actual==salaryTeacher2actual);
        Assert.assertNotEquals(salaryTeacher1actual,salaryTeacher3actual);

    }
    @After
    public void tearDown() throws Exception {
    }


}