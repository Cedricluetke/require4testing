package de.require4testing.require4testing.service;

import de.require4testing.require4testing.model.Testcase;
import de.require4testing.require4testing.repository.TestcaseRepository;
import de.require4testing.require4testing.repository.TestrunRepository;
import org.springframework.stereotype.Service;

@Service
public class TestcaseService {
    private final TestcaseRepository testcaseRepository;
    public TestcaseService(TestcaseRepository testcaseRepository) {
        this.testcaseRepository = testcaseRepository;
    }

    public Testcase findById(Long id) {
        return testcaseRepository.findById(id).orElseThrow();
    }
}
