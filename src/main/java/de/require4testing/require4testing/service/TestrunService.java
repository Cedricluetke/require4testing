package de.require4testing.require4testing.service;

import de.require4testing.require4testing.model.Tester;
import de.require4testing.require4testing.model.Testrun;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestrunService {

    private final List<Testrun> testruns = new ArrayList<>();

    public TestrunService() {
        testruns.add(new Testrun(
                1L,
                1L,
                LocalDate.now().minusDays(1),
                true,
                new Tester(1L, "Cedric")
        ));

        testruns.add(new Testrun(
                2L,
                1L,
                LocalDate.now(),
                false,
                new Tester(2L, "Nele")
        ));
    }

    public List<Testrun> findByTestcaseId(Long testcaseId) {
        return testruns.stream()
                .filter(tr -> tr.getTestcaseId().equals(testcaseId))
                .toList();
    }
}
