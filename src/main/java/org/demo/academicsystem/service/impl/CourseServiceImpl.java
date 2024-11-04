package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.course.CourseRequest;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.entity.Course;
import org.demo.academicsystem.handler.exception.CourseNotFoundException;
import org.demo.academicsystem.mapper.CourseMapper;
import org.demo.academicsystem.repository.CourseRepository;
import org.demo.academicsystem.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseResponse> getAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    @Override
    public CourseResponse getById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new CourseNotFoundException("Course not found with id " + id)
        );
        return courseMapper.toResponse(course);
    }

    @Override
    public CourseResponse create(CourseRequest courseRequest) {
        Course newCourse = courseMapper.toEntity(courseRequest);
        Course savedCourse = courseRepository.save(newCourse);
        return courseMapper.toResponse(savedCourse);
    }

    @Override
    public CourseResponse update(Long id, CourseRequest courseRequest) {
        courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id " + id));
        Course updatedCourse = courseMapper.toEntity(courseRequest);
        updatedCourse.setId(id);
        Course savedCourse = courseRepository.save(updatedCourse);
        return courseMapper.toResponse(savedCourse);
    }

    @Override
    public void delete(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException("Course not found with id " + id);
        }
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseResponse> getAllTeacherCourses(Long teacherId) {
        List<Course> courses = courseRepository.findAllByTeacherId(teacherId);
        return courses.stream()
                .map(courseMapper::toResponse)
                .toList();
    }
}
