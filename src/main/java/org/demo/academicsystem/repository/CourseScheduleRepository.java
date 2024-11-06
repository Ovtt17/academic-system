package org.demo.academicsystem.repository;

import org.demo.academicsystem.entity.CourseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseScheduleRepository extends JpaRepository<CourseSchedule, Long> {
    List<CourseSchedule> findAllByCourseId(Long courseId);
}
