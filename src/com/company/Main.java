package com.company;

import com.company.dao.daoService.*;
import com.company.model.*;
import com.company.service.GroupService;
import com.company.service.StudentService;
import com.company.service.TeacherService;
import com.company.util.AgeTeacherUtil;
import com.company.util.ReadingDatabase;
import com.company.util.ReadingFiles;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        StudentService studentServiceAllStudents = new StudentService();
        StudentDaoService studentDaoService = new StudentDaoService();
        studentServiceAllStudents.getAllStudents(studentDaoService.getAll());
        //studentServiceAllStudents.getAllStudents(ReadingFiles.studentsFiles("students.txt"));
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
        TeacherDaoService teacherDaoService = new TeacherDaoService();
        //teacherServiceAllTeachers.getAllTeachers(ReadingFiles.teachersFiles("teachers.txt"));
        teacherServiceAllTeachers.getAllTeachers(teacherDaoService.getAll());

        teacherServiceAllTeachers.setSalaryTeacher(2, teacherServiceAllTeachers.teacherRepository.teachers.get(0));
        System.out.println(AgeTeacherUtil.ageTeacherCheck(teacherServiceAllTeachers.teacherRepository.teachers.get(0)));

        System.out.println(AgeTeacherUtil.ageTeacherCheck(teacherServiceAllTeachers.teacherRepository.teachers.get(1)));
        teacherServiceAllTeachers.setSalaryTeacher(10, teacherServiceAllTeachers.teacherRepository.teachers.get(1));

        System.out.println(AgeTeacherUtil.ageTeacherCheck(teacherServiceAllTeachers.teacherRepository.teachers.get(2)));
        teacherServiceAllTeachers.setSalaryTeacher(15, teacherServiceAllTeachers.teacherRepository.teachers.get(2));

        GroupService groupService = new GroupService();
        GroupDaoService groupDaoService = new GroupDaoService();
        groupService.getAllGroups(groupDaoService.getAll());
        teacherServiceAllTeachers.teachersRetired(teacherServiceAllTeachers);
        teacherServiceAllTeachers.salaries(teacherServiceAllTeachers);
        groupService.yearsGroup(groupService);
        teacherServiceAllTeachers.employees(teacherServiceAllTeachers);
        Methodist methodist1 = teacherServiceAllTeachers.comparator
                (teacherServiceAllTeachers.teacherRepository.teachers.get(1), new Methodist());
        System.out.println(methodist1);
        studentService1.sortedStudents(studentService1);
        studentService2.sortedStudents(studentService2);
        studentService3.sortedStudents(studentService3);
    }
}