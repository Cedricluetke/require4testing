package de.require4testing.require4testing.service;

import de.require4testing.require4testing.model.Tester;
import de.require4testing.require4testing.repository.TesterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesterService {

    private final TesterRepository testerRepository;

    public TesterService(TesterRepository testerRepository) {
        this.testerRepository = testerRepository;
    }

    public List<Tester> findAll() {
        return testerRepository.findAll();
    }

    public Tester findById(Long id) {
        return testerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tester nicht gefunden"));
    }
}