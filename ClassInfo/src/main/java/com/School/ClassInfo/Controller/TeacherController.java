package com.School.ClassInfo.Controller;


import com.School.ClassInfo.Entity.Teacher;
import com.School.ClassInfo.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    @PostMapping(value = "/saveall")
    public ResponseEntity<Teacher> saveAllTeachers(@RequestBody List<Teacher> TeacherList) {
        teacherService.saveAllTeachers(TeacherList);
        return new ResponseEntity<Teacher>(HttpStatus.CREATED);
    }

    @GetMapping(value ="/showTeachers")
    public ResponseEntity<List<Teacher>> getAllTeachers()
    {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<List<Teacher>>(teachers,HttpStatus.OK);
    }

    @GetMapping(value ="/getTeacherByName/{name}")
    public ResponseEntity<List<Teacher>> getStudentsByName(@PathVariable String name)
    {
        List<Teacher> teachers = teacherService.getTeachersByName(name);
        return new ResponseEntity<List<Teacher>>(teachers,HttpStatus.OK);
    }

    @DeleteMapping(value ="/deleteTeacherByName/{name}")
    public ResponseEntity<?> deleteTeacherByName(@PathVariable String name) {
        teacherService.deleteByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
