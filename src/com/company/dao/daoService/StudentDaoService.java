package com.company.dao.daoService;

import com.company.dao.StudentDao;
import com.company.model.Address;
import com.company.model.Student;
import com.company.util.ReadingDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoService extends ReadingDatabase implements StudentDao {
    private Connection connection = getConnection();
    @Override
    public void add(Student student) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO university.Students (student_id, student_name, student_surname, student_age," +
                "student_gender, address_id) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setString(5, student.getGender());
            preparedStatement.setInt(6, student.getAddress_id());

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
    public List<Student> getAll() throws SQLException {
        List<Student> studentList = new ArrayList<>();

        String sql = "SELECT student_id, student_name, student_surname, student_age, " +
                "student_gender, address_id FROM university.Students";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("student_id"));
                student.setName(resultSet.getString("student_name"));
                student.setSurname(resultSet.getString("student_surname"));
                student.setAge(resultSet.getInt("student_age"));
                student.setGender(resultSet.getString("student_gender"));
                student.setAddress_id(resultSet.getInt("address_id"));

                studentList.add(student);
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
    public Student getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT student_id, student_name, student_surname, student_age," +
                "student_gender, address_id FROM university.Students WHERE student_id=?";

        Student student = new Student();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            student.setId(resultSet.getInt("student_id"));
            student.setName(resultSet.getString("student_name"));
            student.setSurname(resultSet.getString("student_surname"));
            student.setAge(resultSet.getInt("student_age"));
            student.setGender(resultSet.getString("student_gender"));
            student.setAddress_id(resultSet.getInt("address_id"));

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
        return student;
    }

    @Override
    public void update(Student student) throws SQLException {
            PreparedStatement preparedStatement = null;

            String sql = "UPDATE university.Students SET student_name=?, student_surname=?, student_age=?, " +
                    "student_gender=?, address_id=? WHERE student_id=?";

            try {
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getSurname());
                preparedStatement.setInt(3, student.getAge());
                preparedStatement.setString(4, student.getGender());
                preparedStatement.setInt(5, student.getAddress_id());
                preparedStatement.setInt(6,student.getId());

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
    public void remove(Student student) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM university.Students WHERE student_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, student.getId());

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
