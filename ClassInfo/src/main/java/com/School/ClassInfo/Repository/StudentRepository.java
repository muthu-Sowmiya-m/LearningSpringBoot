package com.School.ClassInfo.Repository;

import com.School.ClassInfo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>
{
    List<Student> findByName(String studName);

    @Modifying
    @Transactional
    @Query(value ="delete from Student s where s.name = ?1")
    void deleteStudentByName(String name);
}
