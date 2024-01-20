package com.fefos.spring.jpa.Repository;

import com.fefos.spring.jpa.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String name);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByGuardianName(String name);
    //JPQL OBS use Java classes
    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmail(String emailId);
    //Native OBS using db annotations
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    //Native with parameter
    public Student getStudentByEmailNative(String emailId);
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    public Student getStudentByEmailNativeParam(String emailId);
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student s set first_name = ?1 where s.email_address = ?2",
            nativeQuery = true
    )
    public void updateStudentByEmailId(String firstName, String emailId);
}
