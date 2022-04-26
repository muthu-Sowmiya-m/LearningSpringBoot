package com.School.ClassInfo.Repository;

import com.School.ClassInfo.Entity.Student;
import com.School.ClassInfo.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long>
{
    @Modifying
    @Transactional
    @Query(value ="delete from Subject s where s.name = ?1")
    void deleteSubjectByName(String name);
}
