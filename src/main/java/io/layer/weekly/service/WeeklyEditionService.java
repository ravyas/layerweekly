package io.layer.weekly.service;

import io.layer.weekly.dao.WeeklyEditionRepository;
import io.layer.weekly.domain.*;
import io.layer.weekly.domain.users.User;

public class WeeklyEditionService {

    private ArticleService articleService;

    private WeeklyEditionRepository weeklyEditionRepository;

    public WeeklyEditionService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public Article publishArticle(WeeklyEdition weeklyEdition, DraftArticle draftArticle) {
        return weeklyEdition.publishArticle(draftArticle);
    }

    public void submitDraftArticle(User user, WeeklyEdition weeklyEdition, DraftArticle draftArticle) throws InvalidUserException {
        weeklyEdition.submitDraftArticle(user, draftArticle);
    }

    public void addTopics(User user, WeeklyEdition weeklyEdition, Topic topic) throws InvalidUserException {
        weeklyEdition.addTopic(user, topic);
    }

}
