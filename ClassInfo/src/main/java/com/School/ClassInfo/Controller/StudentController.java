package com.School.ClassInfo.Controller;

import com.School.ClassInfo.Entity.Student;
import com.School.ClassInfo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/saveall")
    public ResponseEntity<Student> saveAllStudents(@RequestBody List<Student> studentList) {
         studentService.saveAllStudents(studentList);
         return new ResponseEntity<Student>(HttpStatus.CREATED);
    }

    @GetMapping(value ="/showStudents")
    public ResponseEntity<List<Student>> getAllStudents()
    {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }

    @GetMapping(value ="/getStudentByName/{name}")
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) throws Exception {
        List<Student> students = studentService.getStudentsByName(name);
        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }

    @DeleteMapping(value ="/deleteStudentByName/{name}")
    public ResponseEntity<String> deleteStudentByName(@PathVariable String name) {
        studentService.deleteByName(name);
        return new ResponseEntity<String>("Deleted",HttpStatus.NO_CONTENT);
    }

}


