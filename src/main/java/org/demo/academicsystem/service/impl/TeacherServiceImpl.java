package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.teacher.TeacherRequest;
import org.demo.academicsystem.dto.teacher.TeacherResponse;
import org.demo.academicsystem.entity.Teacher;
import org.demo.academicsystem.mapper.TeacherMapper;
import org.demo.academicsystem.repository.TeacherRepository;
import org.demo.academicsystem.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public List<TeacherResponse> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream()
                .map(teacherMapper::toResponse)
                .toList();
    }

    @Override
    public TeacherResponse getTeacherById(Long id) {
        return null;
    }

    @Override
    public TeacherResponse createTeacher(TeacherRequest teacher) {
        return null;
    }

    @Override
    public TeacherResponse updateTeacher(Long id, TeacherRequest teacher) {
        return null;
    }

    @Override
    public void deleteTeacher(Long id) {

    }
}
