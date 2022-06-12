package com.company.util;

import com.company.exception.AgeException;
import com.company.model.Teacher;

public class AgeTeacherUtil {
    public static Object ageTeacherCheck(Teacher teacher) {
        try {
            if (teacher.getAge() < 18) {
                throw new AgeException("Teacher age can't be less 18. We can't hire this teacher");
            }
            return teacher;
        } catch (AgeException e) {
            return e.getMessage();
        }
    }
}
