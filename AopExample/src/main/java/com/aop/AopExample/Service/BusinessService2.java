package com.aop.AopExample.Service;

import org.springframework.stereotype.Service;

@Service
public class BusinessService2
{
    public String show()
    {
        //System.out.println("Service 2");
        return "In Service 2's show() Method ";
    }
}
