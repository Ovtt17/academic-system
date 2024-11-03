package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.course.CourseRequest;
import org.demo.academicsystem.dto.course.CourseResponse;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses();
    CourseResponse getCourseById(Long id);
    CourseResponse createCourse(CourseRequest course);
    CourseResponse updateCourse(Long id, CourseRequest course);
    void deleteCourse(Long id);
}
