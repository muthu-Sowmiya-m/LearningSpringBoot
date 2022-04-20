package com.aop.AopExample.Service;

import org.springframework.stereotype.Service;

@Service
public class BusinessService1
{

 public String show()
 {
     return "In Service 1's show() Method" ;
 }
}
