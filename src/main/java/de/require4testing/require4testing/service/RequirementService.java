package de.require4testing.require4testing.service;

import de.require4testing.require4testing.model.Requirement;
import de.require4testing.require4testing.repository.RequirementRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RequirementService {

    private final RequirementRepository requirementRepository;

    public RequirementService(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    public Page<Requirement> findPaginated(int page, int size) {
        return requirementRepository.findAll(PageRequest.of(page, size));
    }

    public void save(Requirement requirement) {
        requirementRepository.save(requirement);
    }

    public Requirement findById(Long id) {
        return requirementRepository.findById(id).orElse(null);
    }
}
