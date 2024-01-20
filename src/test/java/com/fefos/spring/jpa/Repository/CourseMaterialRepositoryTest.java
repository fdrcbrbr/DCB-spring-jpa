package com.fefos.spring.jpa.Repository;

import com.fefos.spring.jpa.Entity.Course;
import com.fefos.spring.jpa.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private  CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("Math")
                .credit(50)
                .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder().url("www.education.org")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }

}