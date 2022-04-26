package com.School.ClassInfo.Service;

import com.School.ClassInfo.Entity.Student;
import com.School.ClassInfo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> saveAllStudents(List<Student> studentList)
    {
        List<Student> students  = studentRepository.saveAll(studentList);
         //Add some exceptions
        return students;
    }

    public List<Student> getAllStudents()
    {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public List<Student> getStudentsByName(String studName) throws Exception {
        if(studName.equals("Empty"))
        {
            throw new Exception("Name is invalid!!");
        }
        List<Student> students = studentRepository.findByName(studName);
        return students;
    }

    public void deleteByName(String name)
    {
        studentRepository.deleteStudentByName(name);
    }
}
