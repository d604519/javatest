package com.example.demo69;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final Service service;
    private final StudentRepository studentRepository;
    private final SubjectsRepository subjectsRepository;

    @Autowired
    public Controller(Service service, StudentRepository studentRepository, SubjectsRepository subjectsRepository) {
        this.service = service;
        this.studentRepository = studentRepository;
        this.subjectsRepository = subjectsRepository;
    }

    @GetMapping(path = "api/student")
    public String retrieveStudent() throws JsonProcessingException {
        List<StudentTarget> studentsTarget = studentRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String studentJson = objectMapper.writeValueAsString(studentsTarget);
        return studentJson;
    }

    @GetMapping(path = "api/subjects")
    public String retrieveSubjects() throws JsonProcessingException {
        List<SubjectsTarget> subjectsTarget = subjectsRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String subjectsJson = objectMapper.writeValueAsString(subjectsTarget);
        return subjectsJson;
    }


    @PostMapping(path = "api/post")
    public ResponseEntity<StudentTarget> post(@RequestBody Student student) throws JsonProcessingException {
        StudentTarget studentTarget = service.process(student);
        return ResponseEntity.ok(studentTarget);
    }
}
