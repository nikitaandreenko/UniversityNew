package com.company.dao.daoService;

import com.company.dao.GroupDao;
import com.company.model.Group;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.util.ReadingDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoService extends ReadingDatabase implements GroupDao {

    private Connection connection = getConnection();

    @Override
    public void add(Group group) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO university.GroupStudents (group_id, group_name, group_course, group_yearAdmission," +
                "group_yearGraduation) VALUES(?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, group.getGroupId());
            preparedStatement.setInt(2, group.getName());
            preparedStatement.setInt(3, group.getCourse());
            preparedStatement.setInt(4, group.getYearAdmission());
            preparedStatement.setInt(5, group.getYearGraduation());

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
    public List<Group> getAll() throws SQLException {
        List<Group> groupList = new ArrayList<>();

        String sql = "SELECT group_id, group_name, group_course, group_yearAdmission," +
                "group_yearGraduation FROM university.GroupStudents";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Group group = new Group();
                group.setGroupId(resultSet.getInt("group_id"));
                group.setName(resultSet.getInt("group_name"));
                group.setCourse(resultSet.getInt("group_course"));
                group.setYearAdmission(resultSet.getInt("group_yearAdmission"));
                group.setYearGraduation(resultSet.getInt("group_yearGraduation"));

                groupList.add(group);
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
        return groupList;
    }

    @Override
    public Group getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT group_id, group_name, group_course, group_yearAdmission," +
                "group_yearGraduation FROM university.GroupStudents WHERE group_id=?";

        Group group = new Group();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            group.setGroupId(resultSet.getInt("group_id"));
            group.setName(resultSet.getInt("group_name"));
            group.setCourse(resultSet.getInt("group_course"));
            group.setYearAdmission(resultSet.getInt("group_yearAdmission"));
            group.setYearGraduation(resultSet.getInt("group_yearGraduation"));

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
        return group;
    }

    @Override
    public void update(Group group) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE university.GroupStudents SET group_name=?, group_course=?, group_yearAdmission=?, " +
                "group_yearGraduation=? WHERE group_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, group.getName());
            preparedStatement.setInt(2, group.getCourse());
            preparedStatement.setInt(3, group.getYearAdmission());
            preparedStatement.setInt(4, group.getYearGraduation());
            preparedStatement.setInt(5, group.getGroupId());


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
    public void remove(Group group) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM university.GroupStudents WHERE group_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, group.getGroupId());

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
