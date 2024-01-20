package com.fefos.spring.jpa.Repository;

import com.fefos.spring.jpa.Entity.Guardian;
import com.fefos.spring.jpa.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //using the annotation to impact the methods in the db
class StudentRepositoryTest {
    @Autowired
    public StudentRepository studentRepository;

    @Test
    public void Student(){
        Guardian guardian = Guardian.builder()
                .name("Mauro")
                .email("mufsga@gmail.com")
                .mobile("337294967")
                .build();

        Student student = Student.builder().firstName("Bruno")
                            .lastName("Rodari")
                            .emailId("rodari1988@gmail.com")
                            .guardian(guardian)
                            .build();
        studentRepository.save(student);
    };
    @Test
    public void StudentWithGuardian(){
        Student student = Student.builder().firstName("Luca")
                .lastName("Mattei")
                .emailId("lumaca@gmail.com")
                .build();

        studentRepository.save(student);
    };

    @Test
    public void printStudents(){
        List<Student> list = studentRepository.findAll();
        System.out.println(list);
    }   @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("Bruno");
        System.out.println(students);
    } @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("Br ");
        System.out.println(students);
    }
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Mauro");
        System.out.println(students);
    }
    @Test
    public void printStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailNative("rodari1988@gmail.com");
        System.out.println(student);
    }
    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentByEmailId("Brunetto",
                "rodari1988@gmail.com");
    }




}