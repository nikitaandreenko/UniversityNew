package com.company.dao;

import com.company.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao {
    //create
    void add(Teacher teacher) throws SQLException;

    //read
    List<Teacher> getAll() throws SQLException;

    Teacher getById(int id) throws SQLException;

    //update
    void update(Teacher teacher) throws SQLException;

    //delete
    void remove(Teacher teacher) throws SQLException;
}
