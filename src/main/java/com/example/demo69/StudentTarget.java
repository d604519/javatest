package com.example.demo69;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class StudentTarget {
    @Id
    private int id;
    private String name;

    private String mathsScore;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentTarget", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubjectsTarget> subjectsList = new ArrayList<>();

    public StudentTarget() {
    }

    public StudentTarget(int id, String name, String mathsScore, List<SubjectsTarget> subjectsList) {
        this.id = id;
        this.name = name;
        this.mathsScore = mathsScore;
        this.subjectsList = subjectsList;
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

    public List<SubjectsTarget> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(List<SubjectsTarget> subjectsList) {
        this.subjectsList = subjectsList;
    }

    public String getMathsScore() {
        return mathsScore;
    }

    public void setMathsScore(String mathsScore) {
        this.mathsScore = mathsScore;
    }
}
