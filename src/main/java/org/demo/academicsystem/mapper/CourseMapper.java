package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.course.CourseRequest;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.entity.Course;
import org.demo.academicsystem.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Component
public abstract class CourseMapper {
    @Mapping(target = "students", expression = "java(mapStudentIdsToStudents(request.studentIds()))")
    public abstract Course toEntity(CourseRequest request);

    public abstract CourseResponse toResponse(Course course);

    protected List<Student> mapStudentIdsToStudents(List<Long> studentIds) {
        return studentIds.stream()
                .map(id -> Student.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());
    }
}
