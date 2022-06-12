package com.company.model;

import com.company.base.People;

public class Student extends People implements Comparable<Student> {
    public Student(String name, String surname, int age, Address address, String gender) {
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


    @Override
    public String toString() {
        return "student: " + super.toString();
    }

    @Override
    public int compareTo(Student o) {
        if (this.getSurname().compareTo(o.getSurname()) == 0){
            return this.getName().compareTo(o.getName());
        }
        return this.getSurname().compareTo(o.getSurname());
    }
}
