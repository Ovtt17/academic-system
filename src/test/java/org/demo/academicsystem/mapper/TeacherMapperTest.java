package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.teacher.TeacherRequest;
import org.demo.academicsystem.dto.teacher.TeacherResponse;
import org.demo.academicsystem.entity.Gender;
import org.demo.academicsystem.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TeacherMapperTest {

    private final TeacherMapper teacherMapper = Mappers.getMapper(TeacherMapper.class);

    @Test
    public void toEntity() {
        TeacherRequest request = new TeacherRequest(
                "Jane",
                "Doe",
                "jane.doe@example.com",
                "jane.doe",
                "password123",
                98765432,
                Gender.MALE,
                LocalDate.of(1980, 5, 15),
                "profilePic.jpg",
                LocalDate.of(2020, 1, 1),
                "Science",
                "Physics"
        );

        Teacher teacher = teacherMapper.toEntity(request);

        assertNotNull(teacher);
        assertEquals(request.firstName(), teacher.getFirstName());
        assertEquals(request.lastName(), teacher.getLastName());
        assertEquals(request.email(), teacher.getEmail());
        assertEquals(request.username(), teacher.getUsername());
        assertEquals(request.password(), teacher.getPassword());
        assertEquals(request.phone(), teacher.getPhone());
        assertEquals(request.gender(), teacher.getGender());
        assertEquals(request.dateOfBirth(), teacher.getDateOfBirth());
        assertEquals(request.profilePicture(), teacher.getProfilePicture());
        assertEquals(request.dateOfJoining(), teacher.getDateOfJoining());
        assertEquals(request.department(), teacher.getDepartment());
        assertEquals(request.specialization(), teacher.getSpecialization());
    }

    @Test
    public void toResponse() {
        Teacher teacher = Teacher.builder()
                .id(1L)
                .firstName("Jane")
                .lastName("Doe")
                .email("jane.doe@example.com")
                .phone(98765432)
                .profilePicture("profilePic.jpg")
                .dateOfBirth(LocalDate.of(1980, 5, 15))
                .dateOfJoining(LocalDate.of(2020, 1, 1))
                .department("Science")
                .specialization("Physics")
                .build();

        TeacherResponse response = teacherMapper.toResponse(teacher);

        assertNotNull(response);
        assertEquals(teacher.getId(), response.id());
        assertEquals(teacher.getFirstName(), response.firstName());
        assertEquals(teacher.getLastName(), response.lastName());
        assertEquals(teacher.getFullName(), response.fullName());
        assertEquals(teacher.getEmail(), response.email());
        assertEquals(teacher.getPhone(), response.phone());
        assertEquals(teacher.getProfilePicture(), response.profilePicture());
        assertEquals(teacher.getDateOfBirth(), response.dateOfBirth());
        assertEquals(teacher.getDateOfJoining(), response.dateOfJoining());
        assertEquals(teacher.getDepartment(), response.department());
        assertEquals(teacher.getSpecialization(), response.specialization());
    }
}