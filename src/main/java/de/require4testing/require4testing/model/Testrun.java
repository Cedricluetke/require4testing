package de.require4testing.require4testing.model;

import java.time.LocalDate;

public class Testrun {

    private Long id;
    private Long testcaseId;
    private LocalDate executionDate;
    private boolean passed;
    private Tester tester;

    public Testrun(Long id, Long testcaseId, LocalDate executionDate, boolean passed, Tester tester) {
        this.id = id;
        this.testcaseId = testcaseId;
        this.executionDate = executionDate;
        this.passed = passed;
        this.tester = tester;
    }

    public Long getId() {
        return id;
    }

    public Long getTestcaseId() {
        return testcaseId;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public boolean isPassed() {
        return passed;
    }

    public Tester getTester() {
        return tester;
    }

}
