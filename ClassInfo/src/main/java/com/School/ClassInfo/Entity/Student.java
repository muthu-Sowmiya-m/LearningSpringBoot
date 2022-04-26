package com.School.ClassInfo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student
{
    public Student() {
    }

    public Student(Long id, Long rollNumber, String name) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "rollNumber",length =20,unique = true)
    @NotNull(message = "Roll Number cannot be null!!")
    @Min(value = 1,message = "Roll Number should be greater than 0")
    @Max(value = 100,message = "Roll Number should be less than 100")
    private Long rollNumber;

    @Column(name = "name")
    @NotBlank
    @Size(min = 1,max = 25,message = "No.of characters should be atmost 25!!")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    public Set<Subject> subjects = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Long getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Long rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return ( " Student No: "+ this.getRollNumber()+" StudentName: "+this.getName());
    }

}
