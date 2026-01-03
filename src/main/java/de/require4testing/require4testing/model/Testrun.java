package de.require4testing.require4testing.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.function.Consumer;

@Entity
public class Testrun {

    public enum TestrunStatus {
        OPEN,
        PASSED,
        FAILED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate executionDate;

    @Enumerated(EnumType.STRING)
    private TestrunStatus status;

    @ManyToOne
    private Tester tester;

    @ManyToOne
    private Testcase testcase;

    protected Testrun() {}

    public Testrun(LocalDate executionDate, Tester tester, Testcase testcase) {
        this.executionDate = executionDate;
        this.status = TestrunStatus.OPEN;
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

    public TestrunStatus getStatus() {
        return status;
    }

    public void setStatus(TestrunStatus status) {
        this.status = status;
    }
}