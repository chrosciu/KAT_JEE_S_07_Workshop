package com.chrosciu.dao;

import com.chrosciu.model.Group;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDao {
    private static final String CREATE_GROUP =
            "INSERT INTO groups(name) VALUES (?)";
    private static final String READ_GROUP =
            "SELECT * FROM groups where id = ?";
    private static final String UPDATE_GROUP =
            "UPDATE groups SET name = ? where id = ?";
    private static final String DELETE_GROUP =
            "DELETE FROM groups WHERE id = ?";
    private static final String FIND_ALL_GROUPS =
            "SELECT * FROM groups";

    public Group readGroup(int groupId) {
        try (Connection conn = DBUtil.connect()) {
            PreparedStatement statement = conn.prepareStatement(READ_GROUP);
            statement.setInt(1, groupId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setName(resultSet.getString("name"));
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
