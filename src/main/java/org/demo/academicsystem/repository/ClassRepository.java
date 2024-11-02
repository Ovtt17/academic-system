package org.demo.academicsystem.repository;

import org.demo.academicsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Course, Long> {
}
