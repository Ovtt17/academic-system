package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.teacher.TeacherRequest;
import org.demo.academicsystem.dto.teacher.TeacherResponse;
import org.demo.academicsystem.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public Teacher toEntity(TeacherRequest request) {
        return Teacher.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .username(request.username())
                .password(request.password())
                .phone(request.phone())
                .gender(request.gender())
                .dateOfBirth(request.dateOfBirth())
                .profilePicture(request.profilePicture())
                .dateOfJoining(request.dateOfJoining())
                .department(request.department())
                .specialization(request.specialization())
                .build();
    }
    public TeacherResponse toResponse(Teacher teacher) {
        return TeacherResponse.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .fullName(teacher.getFullName())
                .email(teacher.getEmail())
                .phone(teacher.getPhone())
                .profilePicture(teacher.getProfilePicture())
                .dateOfBirth(teacher.getDateOfBirth())
                .dateOfJoining(teacher.getDateOfJoining())
                .department(teacher.getDepartment())
                .specialization(teacher.getSpecialization())
                .build();
    }
}
