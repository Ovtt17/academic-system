package org.demo.academicsystem.repository;

import org.demo.academicsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT s " +
            "FROM Student s " +
            "JOIN s.grades g " +
            "WHERE g.teacher.id = :teacherId " +
            "GROUP BY s.id " +
            "ORDER BY AVG(g.grade) DESC " +
            "LIMIT 10 ", nativeQuery = true)
    List<Student> findTop10StudentsByTeacherIdOrderByAverageGradeDesc(@Param("teacherId") Long teacherId);
}
