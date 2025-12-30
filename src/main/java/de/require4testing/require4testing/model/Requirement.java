package de.require4testing.model;

public class Requirement {

    private Long id;
    private String title;
    private String description;

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

