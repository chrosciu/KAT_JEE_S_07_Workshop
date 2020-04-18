package com.chrosciu.admin;

import com.chrosciu.dao.GroupDao;
import com.chrosciu.model.Group;

public class GroupsAdmin {
    public static void main(String[] args) {
        GroupDao groupDao = new GroupDao();
        Group newGroup = new Group();
        newGroup.setName("Jakas tam");
        Group createdGroup = groupDao.create(newGroup);
        System.out.println("createdGroup: " + createdGroup);
        int groupId = createdGroup.getId();
        Group fetchedGroup = groupDao.readGroup(groupId);
        System.out.println("fetchedGroup: " + fetchedGroup);
    }
}
