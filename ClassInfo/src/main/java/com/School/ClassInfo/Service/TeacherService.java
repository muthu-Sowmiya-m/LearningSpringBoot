package com.School.ClassInfo.Service;

import com.School.ClassInfo.Entity.Teacher;
import com.School.ClassInfo.Repository.TeacherRepository;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherService
{
   // private static Logger logger = LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    private TeacherRepository teacherRepository;

    public void saveAllTeachers(List<Teacher> teacherList)
    {
        teacherRepository.saveAll(teacherList);
      //  logger.info("Saved All the Teachers");
    }

    public List<Teacher> getAllTeachers()
    {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    public List<Teacher> getTeachersByName(String teacherName)
    {
        List<Teacher> teachers = teacherRepository.findByName(teacherName);
        return teachers;
    }

    public void deleteByName(String name)
    {
       // logger.warn("Deleting the teacher by name");
        teacherRepository.deleteTeacherByName(name);
    }
}
