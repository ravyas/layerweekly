package io.layer.weekly.domain;

public abstract class Entity {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
