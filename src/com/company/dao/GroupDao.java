package com.company.dao;

import com.company.model.Group;
import com.company.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface GroupDao {

    //create
    void add(Group group) throws SQLException;

    //read
    List<Group> getAll() throws SQLException;

    Group getById(int id) throws SQLException;

    //update
    void update(Group group) throws SQLException;

    //delete
    void remove(Group group) throws SQLException;
}
