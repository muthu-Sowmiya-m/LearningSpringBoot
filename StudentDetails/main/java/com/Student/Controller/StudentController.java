package com.Student.Controller;

import java.util.List;

import com.Student.Entity.Student;
import com.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/saveall", method = RequestMethod.POST)
    public List<Student> saveAllStudents(@RequestBody List<Student> studentList) {
        List<Student> studentResponse = (List<Student>) studentService.saveAllStudent(studentList);
        return studentResponse;
    }

    @RequestMapping(value = "/findStudents/{name}", method = RequestMethod.GET)
    public List<Student> findStudByName(@PathVariable String name) {
        List<Student> studentResponse = (List<Student>) studentService.findStudByName(name);
        return studentResponse;
    }
    @RequestMapping(value = "/findStudByName/{name}", method = RequestMethod.GET)
    public List<Student> findStudents(@PathVariable String name) {
        List<Student> studentResponse = (List<Student>) studentService.findStudents(name);
        return studentResponse;
    }

    @RequestMapping(value = "/findStudentsUsingNativeQuery", method = RequestMethod.GET)
    public List<Student> findStudentsUsingNativeQuery() {
        List<Student> studentResponse = (List<Student>) studentService.findStudentsUsingNativeQuery();
        return studentResponse;
    }

}