package org.demo.academicsystem.repository;

import org.demo.academicsystem.dto.dashboard.PendingAssignment;
import org.demo.academicsystem.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    @Query("SELECT new org.demo.academicsystem.dto.dashboard.PendingAssignment(" +
            "a.id, " +
            "a.title, " +
            "a.dueDate, " +
            "COUNT(s.id), " +
            "CAST((SELECT COUNT(st.id) FROM Student st) AS long)) " +
            "FROM Assignment a " +
            "LEFT JOIN Submission s ON s.assignment.id = a.id " +
            "WHERE a.dueDate > :dueDate " +
            "GROUP BY a.id, a.title, a.dueDate")
    List<PendingAssignment> findPendingAssignments(@Param("dueDate") LocalDate dueDate);
}
