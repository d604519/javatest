package com.example.demo69;

import jakarta.persistence.*;

@Entity
public class SubjectsTarget {
    @Id
    private Long id;
    private String subjectName;
    private String subjectScore;

    @ManyToOne(fetch = FetchType.LAZY)
    private StudentTarget studentTarget;

    public SubjectsTarget() {
    }

    public SubjectsTarget(Long id, String subjectName, String subjectScore) {
        this.id = id;
        this.subjectName = subjectName;
        this.subjectScore = subjectScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(String subjectScore) {
        this.subjectScore = subjectScore;
    }
}
