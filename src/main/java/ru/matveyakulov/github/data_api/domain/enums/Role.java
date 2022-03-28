package ru.matveyakulov.github.data_api.domain.enums;

public enum Role {

    ROLE_USER("USER"),

    ROLE_ADMIN("ADMIN");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

