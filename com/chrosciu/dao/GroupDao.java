package com.chrosciu.dao;

import com.chrosciu.model.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GroupDao {
    private static final String CREATE_GROUP =
            "INSERT INTO `groups`(name) VALUES (?)";
    private static final String READ_GROUP =
            "SELECT * FROM `groups` where id = ?";
    private static final String UPDATE_GROUP =
            "UPDATE `groups` SET name = ? where id = ?";
    private static final String DELETE_GROUP =
            "DELETE FROM `groups` WHERE id = ?";
    private static final String FIND_ALL_GROUPS =
            "SELECT * FROM `groups`";

    public Group create(Group group) {
        try (Connection conn = DBUtil.connect()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_GROUP, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, group.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                group.setId(resultSet.getInt(1));
            }
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

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
