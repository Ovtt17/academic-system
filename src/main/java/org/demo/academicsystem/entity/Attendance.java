package org.demo.academicsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attendances")
@EntityListeners(AuditingEntityListener.class)
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String status;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class aClass;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
