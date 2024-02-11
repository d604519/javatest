package com.example.demo69;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubjectsMapper {
    SubjectsMapper INSTANCE = Mappers.getMapper(SubjectsMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "subjectName", source = "subjectName")
    @Mapping(target = "subjectScore", source = "subjectScore")

    SubjectsTarget from(Subjects subjects);
}
