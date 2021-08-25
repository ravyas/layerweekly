package com.layer.domain;

import com.layer.domain.users.User;

import java.util.ArrayList;
import java.util.List;

public class LayerWeeklyMagazine {

    private List<Topic> topics = new ArrayList<>();

    public void addTopics(User user, Topic topic) throws InvalidUserException{
        if(!User.Role.CHIEFEDITOR.equals(user.getRole())) {
            throw new InvalidUserException();
        }
        topics.add(topic);
    }

}
