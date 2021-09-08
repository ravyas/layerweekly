package io.layer.weekly.domain.users;

public class Journalist extends User {
    public Journalist(String name){
        super(Role.JOURNALIST, name);
    }
}
