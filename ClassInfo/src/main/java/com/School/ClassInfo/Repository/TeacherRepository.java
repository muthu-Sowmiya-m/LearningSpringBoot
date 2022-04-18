package com.School.ClassInfo.Repository;

import com.School.ClassInfo.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long>
{
    List<Teacher> findByName(String TeacherName);

    @Modifying
    @Transactional
    @Query(value ="delete from Teacher t where t.name = ?1")
    public void deleteTeacherByName(String name);
}
