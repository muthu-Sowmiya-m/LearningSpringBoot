package com.School.ClassInfo.Controller;


import com.School.ClassInfo.Entity.Teacher;
import com.School.ClassInfo.Service.TeacherService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teachers")
@Api(tags= "Methods in TeacherController",value = "Operations related to Teacher in ClassInfo")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    @PostMapping(value = "/saveall")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added teachers list to the API"),
            @ApiResponse(code = 400, message = "Bad Request!! error in request body"),
            @ApiResponse(code = 500, message = "Internal API Error")
    })
    public ResponseEntity<Teacher> saveAllTeachers( @Valid @org.springframework.web.bind.annotation.RequestBody List<Teacher> TeacherList) {
        teacherService.saveAllTeachers(TeacherList);
        return new ResponseEntity<Teacher>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "To View a list of teachers",notes="provides a way to look up all the teachers in the API", response = Teacher.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal API Error")
    })
    @GetMapping(value ="/showTeachers")
    public ResponseEntity<List<Teacher>> getAllTeachers()
    {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<List<Teacher>>(teachers,HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of teachers having given name"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal API Error")
    })
    @GetMapping(value ="/getTeacherByName/{name}")
    public ResponseEntity<List<Teacher>> getStudentsByName( @ApiParam(
            name =  "Name of the Teacher",
            type = "String",
            value = "First Name of the teacher",
            example = "Rahul",
            required = true)@PathVariable String name)
    {
        List<Teacher> teachers = teacherService.getTeachersByName(name);
        return new ResponseEntity<List<Teacher>>(teachers,HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully deleted teacher with given name "),
            @ApiResponse(code = 500, message = "Internal API Error")
    })
    @DeleteMapping(value ="/deleteTeacherByName/{name}")
    public ResponseEntity<?> deleteTeacherByName(@PathVariable String name) {
        teacherService.deleteByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
