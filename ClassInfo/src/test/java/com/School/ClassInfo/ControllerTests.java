package com.School.ClassInfo;

import com.School.ClassInfo.Controller.StudentController;
import com.School.ClassInfo.Entity.Student;
import com.School.ClassInfo.Repository.StudentRepository;
import com.School.ClassInfo.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
class ControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private StudentService studentService;

	@MockBean
	private StudentRepository studentRepository;

	//Testing a method in Controller
	@Test
	void getAllStudentsTest() throws Exception
	{
		List<Student> studList = new ArrayList<Student>();
	    Student n1 = new Student((long)1,(long)101,"Rahul");
	    studList.add(n1);
		Student n2 = new Student((long)2,(long)102,"Raj");
		studList.add(n2);

		Mockito.when(studentService.getAllStudents()).thenReturn(studList);


		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students/showStudents").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
//
	System.out.println(result.getResponse().getContentAsString());
	System.out.println(result.getResponse().getStatus());

	 String expected ="[{\"id\": 1, \"rollNumber\": 101, \"name\": \"Rahul\"},"+
			 "{\"id\": 2, \"rollNumber\": 102, \"name\": \"Raj\"}]";
		JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
	}


	}


