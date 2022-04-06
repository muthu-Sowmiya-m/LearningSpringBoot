package com.Student.Repository;


import java.util.List;

import com.Student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
    List<Student> findByName(String name);

    @Query("select s from Student s where s.name = ?1")
    List<Student> findStudents(String name);

    @Query(value = "select * from Student_Table", nativeQuery = true)
    List<Student> findStudentsUsingNativeQuery();


}