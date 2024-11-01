package org.demo.academicsystem.repository;

import org.demo.academicsystem.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Long> {
}
