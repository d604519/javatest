package com.example.demo69;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Student {
    @Id
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("subjects")
    private List<Subjects> subjects = new ArrayList<>();

    public Student(int id, String name, List<Subjects> subjects) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
    }

    public Student(String name, List<Subjects> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }
}
