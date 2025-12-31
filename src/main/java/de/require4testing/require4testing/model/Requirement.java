package de.require4testing.model;

import de.require4testing.require4testing.model.Testcase;

import java.util.ArrayList;
import java.util.List;

public class Requirement {

    private Long id;
    private String title;
    private String description;

    private List<Testcase> testCases = new ArrayList<>();

    public List<Testcase> getTestCases() {
        return testCases;
    }
    public void setTestCases(List<Testcase> testCases) {
        this.testCases = testCases;
    }

    public Requirement(Long ID, String title, String description) {
        this.id = ID;
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
}

