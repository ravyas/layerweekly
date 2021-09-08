package io.layer.weekly.domain;

import io.layer.weekly.domain.users.User;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userById(String id) {
        return userRepository.userById(id);
    }
}
