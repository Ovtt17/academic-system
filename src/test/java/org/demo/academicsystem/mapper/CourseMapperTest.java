package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.course.CourseRequest;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.dto.courseSchedule.CourseScheduleRequest;
import org.demo.academicsystem.entity.Course;
import org.demo.academicsystem.entity.Student;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CourseMapperTest {

    private final CourseMapper mapper = Mappers.getMapper(CourseMapper.class);

    @Test
    public void toEntity() {
        CourseRequest request = new CourseRequest(
                "Math 101",
                "Basic Mathematics",
                "A",
                "Fall 2023",
                1L,
                List.of(
                        new CourseScheduleRequest(
                                DayOfWeek.MONDAY,
                                LocalTime.of(9, 0),
                                LocalTime.of(10, 30),
                                1L
                        ),
                        new CourseScheduleRequest(
                                DayOfWeek.WEDNESDAY,
                                LocalTime.of(9, 0),
                                LocalTime.of(10, 30),
                                1L
                        )
                ),
                List.of(1L, 2L, 3L)
        );

        Course course = mapper.toEntity(request);

        assertNotNull(course);
        assertEquals(request.name(), course.getName());
        assertEquals(request.description(), course.getDescription());
        assertEquals(request.section(), course.getSection());
        assertEquals(request.semester(), course.getSemester());
        assertEquals(request.teacherId(), course.getTeacher().getId());
        assertEquals(request.schedules().size(), course.getSchedules().size());
        assertEquals(request.studentIds().size(), course.getStudents().size());

        for (int i = 0; i < request.studentIds().size(); i++) {
            assertEquals(request.studentIds().get(i), course.getStudents().get(i).getId());
        }
    }

    @Test
    public void toResponse() {
        Course course = Course.builder()
                .id(1L)
                .name("Math 101")
                .description("Basic Mathematics")
                .section("A")
                .semester("Fall 2023")
                .students(List.of(
                        Student.builder().id(1L).build(),
                        Student.builder().id(2L).build(),
                        Student.builder().id(3L).build()
                ))
                .build();

        CourseResponse response = mapper.toResponse(course);

        assertNotNull(response);
        assertEquals(course.getId(), response.id());
        assertEquals(course.getName(), response.name());
        assertEquals(course.getDescription(), response.description());
        assertEquals(course.getSemester(), response.semester());
        assertEquals(course.getStudents().size(), response.students().size());

        for (int i = 0; i < course.getStudents().size(); i++) {
            assertEquals(course.getStudents().get(i).getId(), response.students().get(i).id());
        }
    }
}