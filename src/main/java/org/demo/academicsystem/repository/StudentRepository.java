package org.demo.academicsystem.repository;

import org.demo.academicsystem.dto.dashboard.TopStudent;
import org.demo.academicsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT new org.demo.academicsystem.dto.dashboard.TopStudent(s.id, CONCAT(s.firstName, ' ', s.lastName), CAST(ROUND(AVG(g.grade), 1) AS double)) " +
            "FROM Student s " +
            "JOIN s.grades g " +
            "WHERE g.teacher.email = :email " +
            "GROUP BY s.id, s.firstName, s.lastName " +
            "ORDER BY AVG(g.grade) DESC")
    List<TopStudent> findTop10StudentsByTeacherIdOrderByAverageGradeDesc(@Param("email") String email);
}