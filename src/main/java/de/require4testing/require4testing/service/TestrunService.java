package de.require4testing.require4testing.service;

import de.require4testing.require4testing.model.Tester;
import de.require4testing.require4testing.model.Testcase;
import de.require4testing.require4testing.repository.TestrunRepository;
import de.require4testing.require4testing.model.TestrunStatus;
import de.require4testing.require4testing.service.TestrunService;
import de.require4testing.require4testing.service.TestcaseService;
import de.require4testing.require4testing.model.Testrun;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestrunService {

    private final TestrunRepository testrunRepository;

    public TestrunService(TestrunRepository testrunRepository) {
        this.testrunRepository = testrunRepository;
    }

    public List<Testrun> findByTestcase(Testcase testcase) {
        return testrunRepository.findByTestcase(testcase);
    }

    public void updateStatus(Long id, Testrun.TestrunStatus status) {
        Testrun tr = testrunRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Testrun nicht gefunden"));

        tr.setStatus(status);
        testrunRepository.save(tr);
    }

    public Testrun save(Testrun testrun) {
        return testrunRepository.save(testrun);
    }
}
