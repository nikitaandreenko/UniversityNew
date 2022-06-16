package com.company;

import com.company.model.*;
import com.company.service.GroupService;
import com.company.service.StudentService;
import com.company.service.TeacherService;
import com.company.util.AgeTeacherUtil;
import com.company.util.ReadingFiles;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StudentService studentServiceAllStudents = new StudentService();
        studentServiceAllStudents.addStudentsGroup(ReadingFiles.studentsFiles("students.txt"));
        StudentService studentService1 = new StudentService();
        studentService1.addStudent(studentServiceAllStudents.studentRepository.students.get(0));
        studentService1.addStudent(studentServiceAllStudents.studentRepository.students.get(1));
        studentService1.addStudent(studentServiceAllStudents.studentRepository.students.get(2));

        StudentService studentService2 = new StudentService();
        studentService2.addStudent(studentServiceAllStudents.studentRepository.students.get(3));
        studentService2.addStudent(studentServiceAllStudents.studentRepository.students.get(4));
        studentService2.addStudent(studentServiceAllStudents.studentRepository.students.get(5));

        StudentService studentService3 = new StudentService();
        studentService3.addStudent(studentServiceAllStudents.studentRepository.students.get(6));
        studentService3.addStudent(studentServiceAllStudents.studentRepository.students.get(7));
        studentService3.addStudent(studentServiceAllStudents.studentRepository.students.get(8));

        TeacherService teacherServiceAllTeachers = new TeacherService();
        teacherServiceAllTeachers.addTeachersGroup(ReadingFiles.teachersFiles("teachers.txt"));

        teacherServiceAllTeachers.setSalaryTeacher(2, teacherServiceAllTeachers.teacherRepository.teachers.get(0));
        System.out.println(AgeTeacherUtil.ageTeacherCheck(teacherServiceAllTeachers.teacherRepository.teachers.get(0)));

        System.out.println(AgeTeacherUtil.ageTeacherCheck(teacherServiceAllTeachers.teacherRepository.teachers.get(1)));
        teacherServiceAllTeachers.setSalaryTeacher(10, teacherServiceAllTeachers.teacherRepository.teachers.get(1));

        System.out.println(AgeTeacherUtil.ageTeacherCheck(teacherServiceAllTeachers.teacherRepository.teachers.get(2)));
        teacherServiceAllTeachers.setSalaryTeacher(15, teacherServiceAllTeachers.teacherRepository.teachers.get(2));

        GroupService groupService = new GroupService();
        Group group1 = new Group(1, 3, studentService1.studentRepository.students,
                teacherServiceAllTeachers.teacherRepository.teachers.get(0), 2007, 2012);
        Group group2 = new Group(2, 4, studentService2.studentRepository.students,
                teacherServiceAllTeachers.teacherRepository.teachers.get(1), 2006, 2010);
        Group group3 = new Group(3, 5, studentService3.studentRepository.students,
                teacherServiceAllTeachers.teacherRepository.teachers.get(2), 2009, 2014);

        groupService.addGroup(group1);
        groupService.addGroup(group2);
        groupService.addGroup(group3);
        groupService.allGroup(groupService);
        teacherServiceAllTeachers.teachersRetired(teacherServiceAllTeachers);
        teacherServiceAllTeachers.salaries(teacherServiceAllTeachers);
        groupService.yearsGroup(groupService);
        teacherServiceAllTeachers.employees(teacherServiceAllTeachers);
        Methodist methodist1 = teacherServiceAllTeachers.comparator
                (teacherServiceAllTeachers.teacherRepository.teachers.get(1), teacherServiceAllTeachers);
        System.out.println(methodist1);
        studentService1.sortedStudents(studentService1);
        studentService2.sortedStudents(studentService2);
        studentService3.sortedStudents(studentService3);
    }
}