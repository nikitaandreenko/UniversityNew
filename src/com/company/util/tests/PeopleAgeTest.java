package com.company.util.tests;

import com.company.model.Address;
import com.company.model.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeopleAgeTest {
    Address addressStudent1;
    Student student1;

    @Before
    public void setUp() throws Exception {
        addressStudent1 = new Address("New York", "5 avenu", 15, 136);
        student1 = new Student("Nik", "Genson", 21, addressStudent1, "male");
    }

    @Test
    public void setAge() {
        student1.setAge(20);
        Assert.assertTrue(student1.getAge() == 20);
        student1.setAge(-5);
        Assert.assertEquals(0, student1.getAge());
        Assert.assertFalse(student1.getAge() == -5);
    }

    @After
    public void tearDown() throws Exception {
    }


}