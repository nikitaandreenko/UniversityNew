package com.company.service;

import com.company.model.Group;
import com.company.model.Student;
import com.company.repository.GroupRepository;

import java.util.ArrayList;
import java.util.Comparator;

public class GroupService {

    private GroupRepository groupRepository;

    public GroupService() {
        groupRepository = new GroupRepository();
    }

    public void addGroup(Group group) {
        groupRepository.addGroup(group);
    }

    public void deleteGroup(Group group) {
        groupRepository.deleteGroup(group);
    }

    public void setGroup(int pos, Group group) {
        groupRepository.setGroups(pos, group);
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
