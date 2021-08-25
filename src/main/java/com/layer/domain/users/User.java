package com.layer.domain.users;

public class User {

    public enum Role {
        COPYWRITER, JOURNALIST, CHIEFEDITOR;
    }

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
