package org.demo.academicsystem.repository;

import org.demo.academicsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByTeacherEmail(String email);
}
