package com.company.service;

import com.company.model.Group;
import com.company.model.Student;
import com.company.repository.GroupRepository;
import com.company.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GroupService {

    private GroupRepository groupRepository;

    public GroupService() {
        groupRepository = new GroupRepository();
    }

    public void addGroup(Group group) {
        groupRepository.addGroup(group);
    }

    public List<Group> getAllGroups(List<Group> groupsNew) {
        groupRepository.getAllGroups(groupsNew);
        return groupRepository.groups;
    }

    public Group getByIdGroup(int id, GroupRepository groupRepository) {
        return groupRepository.getByIdGroup(id, groupRepository.groups);
    }

    public void updateGroup(int id, Group group) {
        groupRepository.updateGroup(id, group);
    }

    public void deleteGroup(int id) {
        groupRepository.deleteGroup(id);
    }

    public void allGroup(GroupService groupService) {
        groupRepository.groups
                .stream()
                .forEach(System.out::println);
    }

    public void yearsGroup(GroupService groupService) {
        groupRepository
                .groups.stream()
                .filter(group -> group.getYearGraduation() >= 2011 && group.getYearGraduation() <= 2014)
                .forEach(group -> {
                    System.out.println("Group year graduation 2011-2014:");
                    System.out.println(group);
                });
    }

}
