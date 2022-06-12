package com.company.model;

import com.company.base.People;
import com.company.repository.TeacherRepository;


public class Teacher extends People {

    private int salary;
    public Teacher(String name, String surname, int age, Address address, String gender) {
        super(name, surname, age, address, gender);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public Address getAddress() {
        return super.getAddress();
    }

    @Override
    public void setAddress(Address address) {
        super.setAddress(address);
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(String gender) {
        super.setGender(gender);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int day) {
        this.salary = day*1000;
    }

    @Override
    public String toString() {
        return "teacher: " + super.toString();
    }



}
