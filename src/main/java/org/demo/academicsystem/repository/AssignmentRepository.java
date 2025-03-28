package org.demo.academicsystem.repository;

import org.demo.academicsystem.dto.dashboard.PendingAssignment;
import org.demo.academicsystem.dto.dashboard.WeeklyScoreByCourse;
import org.demo.academicsystem.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
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

    @Query("SELECT new org.demo.academicsystem.dto.dashboard.WeeklyScoreByCourse(WEEK(a.createdDate), AVG(g.grade), c.name) " +
            "FROM Assignment a JOIN a.course c JOIN a.grades g " +
            "WHERE c.createdBy.email = :email " +
            "GROUP BY WEEK(a.createdDate), c.name")
    List<WeeklyScoreByCourse> findWeeklyScoresByTeacherEmail(@Param("email") String email);
}
