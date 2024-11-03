package org.demo.academicsystem.repository;

import org.demo.academicsystem.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
