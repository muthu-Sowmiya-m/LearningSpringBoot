package com.School.ClassInfo.Service;

import com.School.ClassInfo.Entity.Student;
import com.School.ClassInfo.Entity.Subject;
import com.School.ClassInfo.Entity.Teacher;
import com.School.ClassInfo.Repository.StudentRepository;
import com.School.ClassInfo.Repository.SubjectRepository;
import com.School.ClassInfo.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService
{
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public void saveAllSubjects(List<Subject> subjectList)
    {
        subjectRepository.saveAll(subjectList);
    }

    public List<Subject> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects;
    }

    public void deleteByName(String name)
    {
        subjectRepository.deleteSubjectByName(name);
    }

    public void addStudtoSub(Long subjectId, Long studentId)
    {
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.enrolledStudents.add(student);
        subjectRepository.save(subject);
    }

    public void assignTeachertoSub(Long subjectId, Long teacherId)
    {
        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.setTeacher(teacher);
        subjectRepository.save(subject);
    }

}
