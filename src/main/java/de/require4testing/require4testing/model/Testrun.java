package de.require4testing.require4testing.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Testrun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate executionDate;
    private String status;

    @ManyToOne
    private Tester tester;

    @ManyToOne
    private Testcase testcase;

    protected Testrun() {}

    public Testrun(LocalDate executionDate, Tester tester, Testcase testcase) {
        this.executionDate = executionDate;
        this.status = "Offen";
        this.tester = tester;
        this.testcase = testcase;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public Testcase getTestcase() {
        return testcase;
    }

    public Tester getTester() {
        return tester;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
