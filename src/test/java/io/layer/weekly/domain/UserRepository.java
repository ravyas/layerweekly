package io.layer.weekly.domain;

import io.layer.weekly.domain.users.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public User userById(String id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }

    public boolean saveUser(User user) {
        return users.add(user);
    }
}
