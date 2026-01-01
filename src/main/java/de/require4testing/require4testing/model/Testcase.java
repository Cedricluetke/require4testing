package de.require4testing.require4testing.model;

public class Testcase {
    private Long id;
    private String title;
    private boolean completed;

    public Testcase(Long id, String title) {
        this.id = id;
        this.title = title;
        completed = false;
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
