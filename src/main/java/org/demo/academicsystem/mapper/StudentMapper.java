package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.student.StudentRequest;
import org.demo.academicsystem.dto.student.StudentResponse;
import org.demo.academicsystem.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toEntity(StudentRequest request) {
        return toEntity(null, request);
    }

    public Student toEntity(Student existingStudent, StudentRequest request) {
        Student student = existingStudent != null ? existingStudent : new Student();

        student.setFirstName(request.firstName());
        student.setLastName(request.lastName());
        student.setEmail(request.email());
        student.setDateOfBirth(request.dateOfBirth());
        student.setGender(request.gender());
        student.setAddress(request.address());
        student.setPhone(request.phone());

        return student;
    }

    public StudentResponse toResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .fullName(student.getFullName())
                .email(student.getEmail())
                .phone(student.getPhone())
                .address(student.getAddress())
                .gender(String.valueOf(student.getGender()))
                .dateOfBirth(student.getDateOfBirth())
                .build();
    }
}
