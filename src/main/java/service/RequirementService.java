package service;

import de.require4testing.model.Requirement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequirementService {

    private final List<Requirement> requirements = new ArrayList<>();

    public RequirementService() {
        for (long i = 1; i <= 25; i++) {
            requirements.add(
                    new Requirement(
                            i,
                            "Requirement " + i,
                            "Beschreibung für Requirement " + i
                    )
            );
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
