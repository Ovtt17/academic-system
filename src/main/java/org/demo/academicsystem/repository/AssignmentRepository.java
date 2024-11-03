package org.demo.academicsystem.repository;

import org.demo.academicsystem.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findAllByDueDateAfter(LocalDate dueDate);
}
