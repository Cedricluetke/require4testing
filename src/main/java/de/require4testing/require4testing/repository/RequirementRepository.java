package de.require4testing.require4testing.repository;

import de.require4testing.require4testing.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementRepository
        extends JpaRepository<Requirement, Long> {
}