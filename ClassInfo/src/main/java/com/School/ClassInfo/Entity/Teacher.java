package com.School.ClassInfo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@ApiModel(description = "Class representing a teacher in the application.")
@Entity
@Table(name ="Teacher")
public class Teacher implements Serializable {

    @ApiModelProperty(notes = "Unique identifier", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",unique = true)
    @NotBlank
    @Size(min = 1,max = 25,message = "No.of characters should be at most 25!!")
    @ApiModelProperty(notes = "Name of the teacher.",example = "Rahul", required = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects = new HashSet<>();


    public Long getId() {
        return id;
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
