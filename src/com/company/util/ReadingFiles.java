package com.company.util;

import com.company.model.Address;
import com.company.model.Student;
import com.company.model.Teacher;

import java.io.FileReader;
import java.io.IOException;
import java.rmi.StubNotFoundException;
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
                Address addressStudent = new Address();
                Student student1 = new Student();
                student1.setId(parseInt(student[0]));
                student1.setName(student[1]);
                student1.setSurname(student[2]);
                student1.setAge(parseInt(student[3]));
                student1.setGender(student[4]);
                addressStudent.setId(parseInt(student[5]));
                addressStudent.setSity(student[6]);
                addressStudent.setStreet(student[7]);
                addressStudent.setHouse(parseInt(student[8]));
                addressStudent.setFlat(parseInt(student[9]));
               // student1.setAddress(addressStudent);
                students.add(student1);
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
                Address addressTeacher = new Address();
                Teacher teacher1 = new Teacher();
                teacher1.setId(parseInt(teacher[0]));
                teacher1.setName(teacher[1]);
                teacher1.setSurname(teacher[2]);
                teacher1.setAge(parseInt(teacher[3]));
                teacher1.setGender(teacher[4]);
                addressTeacher.setId(parseInt(teacher[5]));
                addressTeacher.setSity(teacher[6]);
                addressTeacher.setStreet(teacher[7]);
                addressTeacher.setHouse(parseInt(teacher[8]));
                addressTeacher.setFlat(parseInt(teacher[9]));
               // teacher1.setAddress(addressTeacher);
                teachers1.add(teacher1);
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
