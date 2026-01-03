package de.require4testing.require4testing.model;

public enum Rolle {
    ADMIN("admin123"),
    REQUIREMENTS_ENGINEER("re123"),
    TESTMANAGER("tm123"),
    TESTFALLERSTELLER("tf123"),
    TESTER("tester123");

    private final String password;

    Rolle(String password) {
        this.password = password;
    }

    public boolean matchesPassword(String input) {
        return password.equals(input);
    }
}
