package io.layer.weekly.domain.users;

import io.layer.weekly.domain.Entity;

public class User extends Entity {

    public User(Role role, String name) {
        this.role = role;
        this.name = new Name(name);
    }

    public enum Role {
        COPYWRITER, JOURNALIST, CHIEFEDITOR;
    }

    private Role role;

    private Name name;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
