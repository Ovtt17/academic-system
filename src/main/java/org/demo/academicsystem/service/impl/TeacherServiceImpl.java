package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.teacher.TeacherRequest;
import org.demo.academicsystem.dto.teacher.TeacherResponse;
import org.demo.academicsystem.entity.Teacher;
import org.demo.academicsystem.handler.exception.TeacherNotFoundException;
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
    public List<TeacherResponse> getAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream()
                .map(teacherMapper::toResponse)
                .toList();
    }

    @Override
    public TeacherResponse getById(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(
                () -> new TeacherNotFoundException("Teacher not found with id " + id)
        );
        return teacherMapper.toResponse(teacher);
    }

    @Override
    public TeacherResponse create(TeacherRequest teacherRequest) {
        Teacher newTeacher = teacherMapper.toEntity(teacherRequest);
        Teacher savedTeacher = teacherRepository.save(newTeacher);
        return teacherMapper.toResponse(savedTeacher);
    }

    @Override
    public TeacherResponse update(Long id, TeacherRequest teacherRequest) {
        teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Teacher not found with id " + id));
        Teacher updatedTeacher = teacherMapper.toEntity(teacherRequest);
        updatedTeacher.setId(id);
        Teacher savedTeacher = teacherRepository.save(updatedTeacher);
        return teacherMapper.toResponse(savedTeacher);
    }

    @Override
    public void delete(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new TeacherNotFoundException("Teacher not found with id " + id);
        }
        teacherRepository.deleteById(id);
    }
}
