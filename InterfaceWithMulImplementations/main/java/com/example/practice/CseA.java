package com.example.practice;
import org.springframework.stereotype.Component;

interface Greetings
{
    void SayHi();
}

@Component(value = "CseA")
public class CseA implements Greetings
{
    private String brand;
    private int price;

    void display()
    {
        System.out.println("HII");
    }

    @Override
    public void SayHi()
    {
        System.out.println("Hii..This is Cse A");
    }

}


@Component(value = "CseB")
class CseB implements Greetings
{
    @Override
    public void SayHi()
    {
        System.out.println("Hii....This is Cse B ");
    }
}
