package com.company.service;

import com.company.model.Methodist;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.repository.StudentRepository;
import com.company.repository.TeacherRepository;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class TeacherService {

    public TeacherRepository teacherRepository;

    public TeacherService() {
        teacherRepository = new TeacherRepository();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.addTeacher(teacher);
    }

    public List<Teacher> getAllTeachers(List<Teacher> teachersNew) {
        teacherRepository.getAllTeachers(teachersNew);
        return teacherRepository.teachers;
    }

    public Teacher getByIdTeacher(int id, TeacherRepository teacherRepository) {
        return teacherRepository.getByIdTeacher(id, teacherRepository.teachers);
    }

    public void updateTeacher(int id, Teacher teacher) {
        teacherRepository.updateTeacher(id, teacher);
    }

    public void deleteTeacher(int id) {
        teacherRepository.deleteTeacher(id);
    }

    public int getSalaryTeacher(Teacher teacher) {
        return teacher.salary;
    }

    public void setSalaryTeacher(int day, Teacher teacher) {
        teacher.salary = day * 1000;
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

    public Methodist comparator(Teacher teacher, Methodist methodist) {
        Function<Teacher, Methodist> converter =
                teacher1 -> { methodist.setId(teacher1.getId());
            methodist.setName(teacher1.getName());
            methodist.setSurname(teacher1.getSurname());
            methodist.setAge(teacher1.getAge());
            methodist.setGender(teacher1.getGender());
            methodist.setAddress_id(teacher1.getAddress_id());
            return methodist;
                };
         return converter.apply(teacher);
    }


    public void salaries(TeacherService teacherService) {
        teacherRepository
                .teachers.stream()
                .filter(teacher -> teacherService.getSalaryTeacher(teacher) > 3000)
                .forEach(teacher -> {
                    System.out.println("Teacher salary more 10000:" + teacher.getName() + " " + teacher.getSurname());
                    System.out.println(teacherService.getSalaryTeacher(teacher));
                });
    }
}



