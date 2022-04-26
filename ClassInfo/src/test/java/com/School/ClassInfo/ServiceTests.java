package com.School.ClassInfo;

import com.School.ClassInfo.Entity.Student;
import com.School.ClassInfo.Repository.StudentRepository;
import com.School.ClassInfo.Service.StudentService;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {

    @Autowired
    private StudentService service;

    @MockBean
    private StudentRepository repository;

    @Test
    public void getAllStudentsTest()
    {
        when(repository.findAll()).thenReturn(Stream.of(new Student((long) 1, (long) 101, "Rahul"),
                        new Student((long) 2, (long) 102, "Raj")).collect(Collectors.toList()));
        assertEquals(2,service.getAllStudents().size());
        System.out.println(service.getAllStudents().toString());
    }

    @Test
    public void getStudentByNameTest() throws Exception {
        String student= "Rahul";
        when(repository.findByName(student))
                .thenReturn(Stream.of(new Student((long) 1, (long) 101, "Rahul")).collect(Collectors.toList()));
        assertEquals(1, service.getStudentsByName(student).size());
        System.out.println( service.getStudentsByName(student).toString());
    }

    @Test
    public void saveUserTest() {
        List<Student> studentlist = Stream.of(new Student((long) 1, (long) 101, "Rahul"),
                new Student((long) 2, (long) 102, "Raj")).collect(Collectors.toList());
        when(repository.saveAll(studentlist)).thenReturn(studentlist);
        assertEquals(studentlist, service.saveAllStudents(studentlist));
    }
}
