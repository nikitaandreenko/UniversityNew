package com.company.repository;

import com.company.base.People;
import com.company.model.Address;
import com.company.model.Teacher;

import java.util.ArrayList;

public class MethodistRepository extends People {

    private ArrayList<Teacher> teachers;

    public MethodistRepository(String name, String surname, int age, Address address, String gender, ArrayList<Teacher> teachers) {
        super(name, surname, age, address, gender);
        this.teachers = teachers;
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public Address getAddress() {
        return super.getAddress();
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }


    @Override
    public String toString() {
        return "methodist: " + super.toString() + "teachers: " + this.teachers;
    }
}
