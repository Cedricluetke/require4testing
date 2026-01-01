package de.require4testing.require4testing.model;

import java.time.LocalDate;

public class Testrun {

    private Long id;
    private Long testcaseId;
    private LocalDate executionDate;
    private String status;
    private Tester tester;

    public Testrun(Long id, Long testcaseId, LocalDate executionDate, String status, Tester tester) {
        this.id = id;
        this.testcaseId = testcaseId;
        this.executionDate = executionDate;
        this.status = status;
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

    public String getStatus() {

        return status;
    }

    public Tester getTester() {

        return tester;
    }

}
