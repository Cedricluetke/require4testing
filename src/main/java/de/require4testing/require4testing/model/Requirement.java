package de.require4testing.require4testing.model;

import de.require4testing.require4testing.model.Testcase;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Testcase> testCases = new ArrayList<>();

    // für JPA
    protected Requirement() {}

    public Requirement(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

    public List<Testcase> getTestCases() {
        return testCases;
    }
}

