package org.demo.academicsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grades")
@EntityListeners(AuditingEntityListener.class)
public class Grade extends BaseAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 2)
    private Double grade;

    @Column(length = 100)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    @JsonBackReference
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    @JsonBackReference
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonBackReference
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonBackReference
    private Student student;
}
