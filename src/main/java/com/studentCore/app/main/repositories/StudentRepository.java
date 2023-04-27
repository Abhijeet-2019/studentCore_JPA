package com.studentCore.app.main.repositories;

import com.studentCore.app.main.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
        
        @Query("select s from Student s where s.passport is empty")
        public List<Student> fetchStudentWithoutPassport();
        
        @Query("select s from Student s where s.passport is not empty")
        public List<Student> fetchStudentWithPassport();
        
        public List<Student>  findBystudentName(String name);
}


