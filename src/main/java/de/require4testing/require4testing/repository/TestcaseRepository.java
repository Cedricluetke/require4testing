package de.require4testing.require4testing.repository;

import de.require4testing.require4testing.model.Testcase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestcaseRepository extends JpaRepository<Testcase, Long> {
}