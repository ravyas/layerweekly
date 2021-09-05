package io.layer.weekly.domain.users;

public class User {

    public User(Role role) {
        this.role = role;
    }

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
