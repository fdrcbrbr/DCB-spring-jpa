package com.fefos.spring.jpa.Repository;

import com.fefos.spring.jpa.Entity.Course;
import com.fefos.spring.jpa.Entity.Student;
import com.fefos.spring.jpa.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
   private CourseRepository courseRepository;
    @Test
   public void printCourses(){
        List<Course> list =
                courseRepository.findAll();

        System.out.println(list);
   }
   @Test
   public void saveCourseWithTeacher(){
       Teacher teacher = Teacher.builder()
               .firstName("Roberto")
               .lastName("Mughini")
               .build();
       Course course = Course.builder()
               .title("Geografia")
               .credit(25)
                .teacher(teacher)
               .build();
       courseRepository.save(course);
   }
    @Test
   public void findAllPagination(){
       PageRequest firstPageWithThreeRecords =
               PageRequest.of(0,4);


       Long totalElements =
               courseRepository.findAll(firstPageWithThreeRecords)
                       .getTotalElements();

        Long totalPages =
                (long) courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalPages();

        System.out.println("Elements "+ totalElements);
        System.out.println("Pages " + totalPages);
   }
    @Test
    public void findAllPaginationSorted(){
        PageRequest sortByTitle =
                PageRequest.of(0,2, Sort.by("title"));


        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();

        System.out.println( courses);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Gianfranco")
                .lastName("Rosi")
                .build();
        Student student = Student.builder()
                .firstName("Michele")
                .lastName("Barni")
                .emailId("micbar@gmail.com")
                .build();
        Course course = Course.builder()
                .title("Topografia")
                .credit(20)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }

}