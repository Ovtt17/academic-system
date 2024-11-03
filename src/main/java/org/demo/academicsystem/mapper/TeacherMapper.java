package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.teacher.TeacherRequest;
import org.demo.academicsystem.dto.teacher.TeacherResponse;
import org.demo.academicsystem.entity.Teacher;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TeacherMapper {
    Teacher toEntity(TeacherRequest request);
    TeacherResponse toResponse(Teacher teacher);
}
