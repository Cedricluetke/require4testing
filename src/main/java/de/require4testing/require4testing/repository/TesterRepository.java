package de.require4testing.require4testing.repository;

import de.require4testing.require4testing.model.Tester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TesterRepository extends JpaRepository<Tester, Long> {
}
