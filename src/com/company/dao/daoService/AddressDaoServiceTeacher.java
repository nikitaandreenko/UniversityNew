package com.company.dao.daoService;

import com.company.dao.AddressDao;
import com.company.model.Address;
import com.company.util.ReadingDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoServiceTeacher extends ReadingDatabase implements AddressDao {
    private Connection connection = getConnection();
    @Override
    public void add(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO university.AddressTeacher (addressId, city, street, house, flat) VALUES(?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, address.getId());
            preparedStatement.setString(2, address.getSity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setInt(4, address.getHouse());
            preparedStatement.setInt(5, address.getFlat());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
    @Override
    public List<Address> getAll() throws SQLException {
        List<Address> addressList = new ArrayList<>();

        String sql = "SELECT addressId, city, street, house, flat FROM university.AddressTeacher";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getInt("addressId"));
                address.setSity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setHouse(resultSet.getInt("house"));
                address.setFlat(resultSet.getInt("flat"));

                addressList.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return addressList;
    }


    @Override
    public Address getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT addressId, city, street, house, flat FROM university.AddressTeacher WHERE addressId=?";

        Address address = new Address();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            address.setId(resultSet.getInt("addressId"));
            address.setSity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setHouse(resultSet.getInt("house"));
            address.setFlat(resultSet.getInt("flat"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE university.AddressTeacher SET city=?, street=?, house=?, flat=? WHERE addressId=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, address.getSity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setInt(3, address.getHouse());
            preparedStatement.setInt(4, address.getFlat());
            preparedStatement.setInt(5, address.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void remove(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM university.AddressTeacher WHERE addressId=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, address.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
