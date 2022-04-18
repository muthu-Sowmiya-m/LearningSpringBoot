package com.School.ClassInfo.Service;

import com.School.ClassInfo.Entity.Student;
import com.School.ClassInfo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    public void saveAllStudents(List<Student> studentList)
    {
         studentRepository.saveAll(studentList);
         //Add some exceptions
    }

    public List<Student> getAllStudents()
    {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public List<Student> getStudentsByName(String studName)
    {
        List<Student> students = studentRepository.findByName(studName);
        return students;
    }

    public void deleteByName(String name)
    {
        studentRepository.deleteStudentByName(name);
    }
}
