package com.company.model;

import com.company.base.People;

public class Student extends People implements Comparable<Student> {
    public Student() {
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
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
    public int getAddress_id() {
        return super.getAddress_id();
    }

    @Override
    public void setAddress_id(int address_id) {
        super.setAddress_id(address_id);
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
        return super.toString();
    }

    @Override
    public int compareTo(Student o) {
        if (this.getSurname().compareTo(o.getSurname()) == 0){
            return this.getName().compareTo(o.getName());
        }
        return this.getSurname().compareTo(o.getSurname());
    }
}
