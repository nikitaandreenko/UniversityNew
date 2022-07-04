package com.company.repository;

import com.company.base.People;
import com.company.model.Group;
import com.company.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository {

    public List<Group> groups;

    public GroupRepository (){
        this.groups = new ArrayList<>();
    }


    public void addGroup (Group group){
        groups.add(group);
    }
    public List<Group> getAllGroups(List<Group> groupsNew) {
        groups.addAll(groupsNew);
        return groups;
    }
    public Group getByIdGroup (int id, List<Group> groups) {
        for (Group gr : groups) {
            if (gr.getGroupId() == id) {
                return gr;
            }
        }
        return null;
    }

    public void updateGroup(int id, Group group) {
        for (Group gr : groups) {
            if (gr.getGroupId() == id) {
                groups.set(id, group);
            }
        }
    }

    public void deleteGroup(int id) {
        for (Group gr : groups) {
            if (gr.getGroupId() == id) {
                groups.remove(gr);
            }
        }
    }
}
