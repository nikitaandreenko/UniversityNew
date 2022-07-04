package com.company.dao;

import com.company.model.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    //create
    void add(Address address) throws SQLException;

        //read
        List <Address> getAll() throws SQLException;

        Address getById (int id) throws SQLException;

        //update
        void update(Address address) throws SQLException;

        //delete
        void remove(Address address) throws SQLException;


}
