package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.course.CourseRequest;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.entity.Course;
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
    public List<CourseResponse> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        return null;
    }

    @Override
    public CourseResponse createCourse(CourseRequest course) {
        return null;
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest course) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }
}
