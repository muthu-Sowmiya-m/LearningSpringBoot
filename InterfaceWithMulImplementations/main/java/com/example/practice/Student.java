package com.example.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class Student
{

    private String name;
    private String dept;
    private int id;

    @Autowired
    @Qualifier("CseB")
    private Greetings obj;

    private CseA obj2;

    Student(CseA obj2)
    {
        this.obj2 =  obj2;
        obj2.SayHi();
    }

    void displayName()
    {

        System.out.println("Intro");
        obj2.SayHi();
    }

}
