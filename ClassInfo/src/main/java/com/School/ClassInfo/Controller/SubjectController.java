package com.School.ClassInfo.Controller;

import com.School.ClassInfo.Entity.Subject;
import com.School.ClassInfo.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController
{
    @Autowired
    private SubjectService subjectService;

    @PostMapping(value = "/saveall")
    public ResponseEntity<Subject> saveAllSubjects(@RequestBody List<Subject> SubjectList) {
        subjectService.saveAllSubjects(SubjectList);
        return new ResponseEntity<Subject>(HttpStatus.CREATED);
    }

    @GetMapping(value ="/showSubjects")
    public ResponseEntity<List<Subject>> getAllSubjects()
    {
        List<Subject> subjects = subjectService.getAllSubjects();
        return new ResponseEntity<List<Subject>>(subjects,HttpStatus.OK);
    }

    @DeleteMapping(value ="/deleteSubjectByName/{name}")
    public ResponseEntity<Subject> deleteSubjectByName(@PathVariable String name) {
        subjectService.deleteByName(name);
        return new ResponseEntity<Subject>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    public ResponseEntity<Subject> addStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ) {
        subjectService.addStudtoSub(subjectId,studentId);
        return new ResponseEntity<Subject>(HttpStatus.OK);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    public ResponseEntity<Subject> assignTeacherToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long teacherId
    ) {
         subjectService.assignTeachertoSub(subjectId,teacherId);
     return new ResponseEntity<Subject>(HttpStatus.OK);

 }
}
