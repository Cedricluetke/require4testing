package de.require4testing.require4testing.model;

public class Requirement {

    private Long ID;
    private String title;
    private String description;

    public Requirement(Long ID, String title, String description) {
        this.ID = ID;
        this.title = title;
        this.description = description;
    }

    public Long getID() {
        return ID;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
}

