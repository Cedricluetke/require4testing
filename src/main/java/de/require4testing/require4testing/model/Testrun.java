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

    public Testrun(LocalDate executionDate, String status, Tester tester, Testcase testcase) {
        this.executionDate = executionDate;
        this.status = status;
        this.tester = tester;
        this.testcase = testcase;
    }

    public Testcase getTestcase() {
        return testcase;
    }
}
