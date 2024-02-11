package com.example.demo69;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "mathsScore", expression = "java(getMathsScore(student.getSubjects()))")
    @Mapping(target = "subjectsList", source = "subjects")


    StudentTarget from(Student student);

    default String getMathsScore(List<Subjects> subSection){
            String maths = subSectionFieldSelector.fieldSelector(
                    subSection,
                    Subjects::getSubjectScore,
                    (score) -> "maths".equalsIgnoreCase(score.getSubjectName())
            );
            return maths;

    }
}
