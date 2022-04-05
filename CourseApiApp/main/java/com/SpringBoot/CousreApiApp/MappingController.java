package com.SpringBoot.CousreApiApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MappingController
{
    @RequestMapping("/hello")
    public String display()
    {
        return "Hii...";
    }
}
