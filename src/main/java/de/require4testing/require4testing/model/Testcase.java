package de.require4testing.require4testing.model;

import jakarta.persistence.*;

@Entity
public class Testcase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean completed;

    @ManyToOne
    private Requirement requirement;

    // extra konstruktor für jpa
    protected Testcase() {}

    public Testcase(String title) {
        this.title = title;
        completed = false;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
