package com.company.dao.daoService;

import com.company.dao.TeacherDao;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.util.ReadingDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoService extends ReadingDatabase implements TeacherDao {

    private Connection connection = getConnection();
    @Override
    public void add(Teacher teacher) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO university.Teachers (teacher_id, teacher_name, teacher_surname, teacher_age," +
                "teacher_gender, address_id, group_id) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setString(2, teacher.getName());
            preparedStatement.setString(3, teacher.getSurname());
            preparedStatement.setInt(4, teacher.getAge());
            preparedStatement.setString(5, teacher.getGender());
            preparedStatement.setInt(6, teacher.getAddress_id());
            preparedStatement.setInt(7, teacher.getGroup_id());

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
    public List<Teacher> getAll() throws SQLException {
        List<Teacher> studentList = new ArrayList<>();

        String sql = "SELECT teacher_id, teacher_name, teacher_surname, teacher_age, " +
                "teacher_gender, address_id, group_id FROM university.Teachers";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("teacher_id"));
                teacher.setName(resultSet.getString("teacher_name"));
                teacher.setSurname(resultSet.getString("teacher_surname"));
                teacher.setAge(resultSet.getInt("teacher_age"));
                teacher.setGender(resultSet.getString("teacher_gender"));
                teacher.setAddress_id(resultSet.getInt("address_id"));
                teacher.setGroup_id(resultSet.getInt("group_id"));


                studentList.add(teacher);
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
        return studentList;
    }

    @Override
    public Teacher getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT teacher_id, teacher_name, teacher_surname, teacher_age," +
                "teacher_gender, address_id, group_id FROM university.Teachers WHERE teacher_id=?";

        Teacher teacher = new Teacher();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            teacher.setId(resultSet.getInt("teacher_id"));
            teacher.setName(resultSet.getString("teacher_name"));
            teacher.setSurname(resultSet.getString("teacher_surname"));
            teacher.setAge(resultSet.getInt("teacher_age"));
            teacher.setGender(resultSet.getString("teacher_gender"));
            teacher.setAddress_id(resultSet.getInt("address_id"));
            teacher.setGroup_id(resultSet.getInt("group_id"));

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
        return teacher;
    }

    @Override
    public void update(Teacher teacher) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE university.Teachers SET teacher_name=?, teacher_surname=?, teacher_age=?, " +
                "teacher_gender=?, address_id=?, group_id=? WHERE teacher_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getSurname());
            preparedStatement.setInt(3, teacher.getAge());
            preparedStatement.setString(4, teacher.getGender());
            preparedStatement.setInt(5, teacher.getAddress_id());
            preparedStatement.setInt(6, teacher.getGroup_id());
            preparedStatement.setInt(7,teacher.getId());

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
    public void remove(Teacher teacher) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM university.Teachers WHERE teacher_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, teacher.getId());

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
