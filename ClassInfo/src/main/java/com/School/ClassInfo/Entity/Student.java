package com.School.ClassInfo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "rollNumber",length =20,unique = true)
    private Long rollNumber;

    @Column(name = "name",length =20)
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

}
