package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.student.StudentRequest;
import org.demo.academicsystem.dto.student.StudentResponse;
import org.demo.academicsystem.entity.Gender;
import org.demo.academicsystem.entity.Student;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentMapperTest {

    private final StudentMapper mapper = Mappers.getMapper(StudentMapper.class);

    @Test
    public void toEntity() {
        StudentRequest request = new StudentRequest(
                "John",
                "Doe",
                "john.doe@example.com",
                12345678,
                "123 Main St",
                LocalDate.of(2000, 1, 1),
                Gender.MALE
        );

        Student student = mapper.toEntity(request);

        assertEquals(request.firstName(), student.getFirstName());
        assertEquals(request.lastName(), student.getLastName());
        assertEquals(request.email(), student.getEmail());
        assertEquals(request.phone(), student.getPhone());
        assertEquals(request.address(), student.getAddress());
        assertEquals(request.dateOfBirth(), student.getDateOfBirth());
        assertEquals(request.gender(), student.getGender());
    }

    @Test
    public void toResponse() {
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setPhone(12345678);
        student.setAddress("123 Main St");
        student.setGender(Gender.MALE);
        student.setDateOfBirth(LocalDate.of(2000, 1, 1));

        StudentResponse response = mapper.toResponse(student);

        assertEquals(student.getId(), response.id());
        assertEquals(student.getFirstName(), response.firstName());
        assertEquals(student.getLastName(), response.lastName());
        assertEquals(student.getEmail(), response.email());
        assertEquals(student.getPhone(), response.phone());
        assertEquals(student.getAddress(), response.address());
        assertEquals(student.getGender().toString(), response.gender());
        assertEquals(student.getDateOfBirth(), response.dateOfBirth());
    }
}