package de.require4testing.require4testing.service;

import de.require4testing.model.Requirement;
import de.require4testing.require4testing.model.Testcase;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequirementService {

    private final List<Requirement> requirements = new ArrayList<>();

    public RequirementService() {
        for (long i = 1; i <= 25; i++) {
            Requirement req = new Requirement(
                    i,
                    "Requirement " + i,
                    "Beschreibung für Requirement " + i
            );

            // Beispiel-Testfälle für jede Requirement
            req.getTestCases().add(new Testcase(1L, "Testfall 1 für Req " + i));
            req.getTestCases().add(new Testcase(2L, "Testfall 2 für Req " + i));
            req.getTestCases().add(new Testcase(3L, "Testfall 3 für Req " + i));
            req.getTestCases().add(new Testcase(4L, "Testfall 4 für Req " + i));
            req.getTestCases().add(new Testcase(5L, "Testfall 5 für Req " + i));
            req.getTestCases().add(new Testcase(6L, "Testfall 6 für Req " + i));

            requirements.add(req);
        }
    }

    public List<Requirement> getRequirements(int page, int size) {
        int start = page * size;
        int end = Math.min(start + size, requirements.size());

        if (start > requirements.size()) {
            return List.of();
        }

        return requirements.subList(start, end);
    }

    public int getTotalPages(int size) {
        return (int) Math.ceil((double) requirements.size() / size);
    }

    public Requirement findById(Long id) {
        return requirements.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
