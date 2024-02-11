package com.example.demo69;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    static final StudentMapper mapper = StudentMapper.INSTANCE;
    static final ObjectMapper deserializer = new ObjectMapper();
    static final String mockJsonPayload = """
            {
              "id": 1,
              "name": "Leonard",
              "subjects": [
                {
                  "id": 3,
                  "subjectName": "science",
                  "subjectScore": "80"
                },
                {
                  "id": 4,
                  "subjectName": "maths",
                  "subjectScore": "99"
                }
              ]
            }
            """;

    @Test
    void from() throws JsonProcessingException {
        // ARRANGE - Assume gotten from controller / payload
        Student mockStudent = deserializer.readValue(mockJsonPayload, Student.class);

        // ACT
        StudentTarget studentTarget = mapper.from(mockStudent);

        // ASSERT
        assertEquals(studentTarget.getMathsScore(), "99");
    }
}