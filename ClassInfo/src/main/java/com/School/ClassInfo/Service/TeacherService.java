package com.School.ClassInfo.Service;

import com.School.ClassInfo.Entity.Teacher;
import com.School.ClassInfo.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService
{
    @Autowired
    private TeacherRepository teacherRepository;

    public void saveAllTeachers(List<Teacher> teacherList)
    {
        teacherRepository.saveAll(teacherList);
        //Add some exceptions
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
        teacherRepository.deleteTeacherByName(name);
    }
}
