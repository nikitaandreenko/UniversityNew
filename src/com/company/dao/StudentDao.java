package com.company.dao;

import com.company.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    //create
    void add(Student student) throws SQLException;

    //read
    List<Student> getAll() throws SQLException;

    Student getById(int id) throws SQLException;

    //update
    void update(Student student) throws SQLException;

    //delete
    void remove(Student student) throws SQLException;
}
