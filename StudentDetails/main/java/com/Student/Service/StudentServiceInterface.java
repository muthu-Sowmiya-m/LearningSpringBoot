package com.Student.Service;

import java.util.List;

import com.Student.Entity.Student;


public interface StudentServiceInterface
{
    List<Student> saveAllStudent(List<Student> studentList);

     List<Student> findStudByName(String name);

    List<Student> findStudents(String name);

    List<Student> findStudentsUsingNativeQuery();

}


