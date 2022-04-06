package com.Student.Service;
import java.util.List;

import com.Student.Entity.Student;
import com.Student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> saveAllStudent(List<Student> studentList) {
        List<Student> response = (List<Student>) studentRepository.saveAll(studentList);
        return response;
    }

    public List<Student> findStudByName(String name)
    {
        List<Student> response = (List<Student>) studentRepository.findByName(name);
        return response;
    }


    public List<Student> findStudents(String name) {
        List<Student> studentResponse = studentRepository.findStudents(name);
        return studentResponse;
    }

    public List<Student> findStudentsUsingNativeQuery() {
        List<Student> studentResponse = studentRepository.findStudentsUsingNativeQuery();
        return studentResponse;
    }

}

