package com.aop.AopExample.Controller;

import com.aop.AopExample.Service.BusinessService1;
import com.aop.AopExample.Service.BusinessService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class Controller
{
    @Autowired
    private BusinessService1 businessService1;

    @Autowired
    private BusinessService2 businessService2;


    @GetMapping("/show1")
    String service1() {
        return businessService1.show();
    }

    @GetMapping("/show2")
    String service2() {
        String str = businessService2.show();
        return str;
    }
}
