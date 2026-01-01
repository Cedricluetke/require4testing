package de.require4testing.require4testing.repository;

import de.require4testing.require4testing.model.Testcase;
import de.require4testing.require4testing.model.Testrun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestrunRepository extends JpaRepository<Testrun, Long> {
    List<Testrun> findByTestcase(Testcase testcase);
}