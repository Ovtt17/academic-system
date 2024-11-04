package org.demo.academicsystem.repository;

import org.demo.academicsystem.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
