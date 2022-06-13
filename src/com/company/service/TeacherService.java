package com.company.service;

import com.company.model.Methodist;
import com.company.model.Teacher;
import com.company.repository.TeacherRepository;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;

public class TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherService() {
        teacherRepository = new TeacherRepository();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.addTeacher(teacher);
    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepository.deleteTeacher(teacher);
    }

    public void setTeacherRepository(int pos, Teacher teacher) {
        teacherRepository.setTeacher(pos, teacher);
    }


    public void allTeachers(TeacherService teacherService) {
        teacherRepository
                .teachers.stream()
                .forEach(System.out::println);
    }

    public void teachersRetired(TeacherService teacherService) {
        teacherRepository
                .teachers.stream()
                .filter(teacher ->
                        (teacher.getAge() > 63 && teacher.getGender().startsWith("male")) ||
                                (teacher.getAge() > 55 && teacher.getGender().startsWith("female")))
                .forEach(teacher -> {
                    System.out.println("Teachers are retired:");
                    System.out.println(teacher);
                });
    }
    public void employees(TeacherService teacherService) {
        teacherRepository
                .teachers.stream()
                .sorted(Comparator.comparing(Teacher::getSurname))
                .forEach(teacher -> {
                    System.out.println("Employees: ");
                    System.out.println(teacher);
                        }
                );
    }

    public Methodist comparator (Teacher teacher, TeacherService teacherService){
        Function<Teacher, Methodist> converter =
                teacher1 -> {
                    return new Methodist(teacher.getName(), teacher.getSurname(), teacher.getAge(),
                            teacher.getAddress(), teacher.getGender(), teacherRepository.teachers );
                };
        return converter.apply(teacher);
    }

    public void salaries(TeacherService teacherService) {
        teacherRepository
                .teachers.stream()
                .filter(teacher ->teacher.getSalary() > 3000)
                .forEach(teacher -> {
                    System.out.println("Teacher salary more 10000:" + teacher.getName() + " " + teacher.getSurname());
                    System.out.println(teacher.getSalary());
                });
    }
}



