package com.company.util;

import com.company.model.Address;
import com.company.model.Student;
import com.company.model.Teacher;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class ReadingFiles {
    public static ArrayList<Student> studentsFiles(String name) {
        FileReader fileReader = null;
        ArrayList <Student> students = new ArrayList <Student>();
        try {
            fileReader = new FileReader(name);
            int a;
            String data = "";
            while ((a = fileReader.read()) != -1) {
                data += (char) a;
            }
            String[] str = data.split("\n");
            for (String str1 : str) {
                String[] student = str1.split("-");
                String nameStudent = student[0];
                String surnameStudent = student[1];
                int ageStudent = parseInt(student[2]);
                String sityStudent = student[3];
                String streetStudent = student[4];
                int houseStudent = parseInt(student[5]);
                int flatStudent = parseInt(student[6]);
                String genderStudent = student[7];

                students.add(new Student(nameStudent, surnameStudent, ageStudent,
                        new Address(sityStudent, streetStudent, houseStudent, flatStudent), genderStudent));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    public static ArrayList<Teacher> teachersFiles(String name) {
        FileReader fileReader = null;
        ArrayList<Teacher> teachers1 = new ArrayList<Teacher>();
        try {
            fileReader = new FileReader(name);
            int b;
            String data1 = "";
            while ((b = fileReader.read()) != -1) {
                data1 += (char) b;
            }
            String[] str2 = data1.split("\n");
            for (String str3 : str2) {
                String [] teacher = str3.split("-");
                String nameTeacher = teacher[0];
                String surnameTeacher = teacher[1];
                int ageTeacher = parseInt(teacher[2]);
                String sityTeacher = teacher[3];
                String streetTeacher = teacher[4];
                int houseTeacher = parseInt(teacher[5]);
                int flatTeacher = parseInt(teacher[6]);
                String genderTeacher = teacher[7];

                teachers1.add(new Teacher(nameTeacher, surnameTeacher, ageTeacher,
                        new Address(sityTeacher, streetTeacher, houseTeacher, flatTeacher), genderTeacher));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return teachers1;
    }
}
