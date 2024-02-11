package com.example.demo69;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    private final StudentRepository studentRepository;
    private final SubjectsRepository subjectsRepository;

    @Autowired
    public Service(StudentRepository studentRepository, SubjectsRepository subjectsRepository) {
        this.studentRepository = studentRepository;
        this.subjectsRepository = subjectsRepository;
    }

    public StudentTarget process(Student student) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode bigJson = mapper.readTree(json);
//        //bigJson = bigJson.path(0);
//        Student student = mapper.convertValue(bigJson, Student.class);

        StudentTarget studentTarget = StudentMapper.INSTANCE.from(student);
        studentRepository.save(studentTarget);
        return studentTarget;
    }
}
