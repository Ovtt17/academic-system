package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.student.StudentRequest;
import org.demo.academicsystem.dto.student.StudentResponse;
import org.demo.academicsystem.entity.Student;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface StudentMapper {
    Student toEntity(StudentRequest request);
    StudentResponse toResponse(Student student);
}
