package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.teacher.TeacherRequest;
import org.demo.academicsystem.dto.teacher.TeacherResponse;

import java.util.List;

public interface TeacherService {
    List<TeacherResponse> getAllTeachers();
    TeacherResponse getTeacherById(Long id);
    TeacherResponse createTeacher(TeacherRequest teacher);
    TeacherResponse updateTeacher(Long id, TeacherRequest teacher);
    void deleteTeacher(Long id);
}
