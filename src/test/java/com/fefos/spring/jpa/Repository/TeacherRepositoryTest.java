package com.fefos.spring.jpa.Repository;

import com.fefos.spring.jpa.Entity.Course;
import com.fefos.spring.jpa.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){

        Course courseA = Course.builder()
                .title("History")
                .credit(40)
                .build();
        Course courseB = Course.builder()
                .title("Sociology")
                .credit(30)
                .build();
        Teacher teacher =
                Teacher.builder()
                        .firstName("Luca")
                        .lastName("Marini")
                        //.courses(List.of(courseA, courseB))
                        .build();

        teacherRepository.save(teacher);
    };

}