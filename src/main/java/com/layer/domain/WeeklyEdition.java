package com.layer.domain;

import com.layer.domain.users.User;

import java.util.ArrayList;
import java.util.List;

public class WeeklyEdition extends Entity {

    private List<Topic> topics = new ArrayList<>();

    private List<DraftArticle> draftArticles = new ArrayList<>();

    public void addTopic(User user, Topic topic) throws InvalidUserException{
        if(!User.Role.CHIEFEDITOR.equals(user.getRole())) {
            throw new InvalidUserException();
        }
        topics.add(topic);
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<DraftArticle> getDraftArticles() {
        return draftArticles;
    }

    public void submitDraftArticle(User user, DraftArticle draftArticle) throws InvalidUserException {
        if(!User.Role.JOURNALIST.equals(user.getRole())) {
            throw new InvalidUserException("Only journalist can submit the draft article");
        }
        draftArticles.add(draftArticle);
    }
}