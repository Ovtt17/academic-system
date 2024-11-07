package org.demo.academicsystem.repository;

import org.demo.academicsystem.dto.dashboard.TopStudent;
import org.demo.academicsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT new org.demo.academicsystem.dto.dashboard.TopStudent(s.id, CONCAT(s.firstName, ' ', s.lastName), CAST(ROUND(AVG(g.grade), 1) AS double)) " +
            "FROM Student s " +
            "JOIN s.grades g " +
            "WHERE g.teacher.id = :teacherId " +
            "GROUP BY s.id, s.firstName, s.lastName " +
            "ORDER BY AVG(g.grade) DESC")
    List<TopStudent> findTop10StudentsByTeacherIdOrderByAverageGradeDesc(@Param("teacherId") Long teacherId);
}