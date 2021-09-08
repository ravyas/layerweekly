package io.layer.weekly.service;

import io.layer.weekly.dao.WeeklyEditionRepository;
import io.layer.weekly.domain.*;
import io.layer.weekly.domain.article.*;
import io.layer.weekly.domain.edition.Topic;
import io.layer.weekly.domain.edition.WeeklyEdition;
import io.layer.weekly.domain.users.Journalist;
import io.layer.weekly.domain.users.User;

import java.util.List;

public class WeeklyEditionService {

    private ArticleService articleService;

    private WeeklyEditionRepository weeklyEditionRepository;

    public WeeklyEditionService(WeeklyEditionRepository weeklyEditionRepository) {
        this.weeklyEditionRepository = weeklyEditionRepository;
    }

    public Article publishArticle(WeeklyEdition weeklyEdition, DraftArticle draftArticle) {
        return weeklyEdition.publishArticle(draftArticle);
    }

    public DraftArticle submitDraftArticle(Journalist journalist, WeeklyEdition weeklyEdition, String title, String content, List<Topic> connectedTopics) throws InvalidUserException {
        DraftArticle draftArticle = new DraftArticle(journalist, title, content, connectedTopics);
        weeklyEdition.submitDraftArticle(journalist, draftArticle);
        return draftArticle;
    }

    public void addTopics(User user, WeeklyEdition weeklyEdition, Topic topic) throws InvalidUserException {
        weeklyEdition.addTopic(user, topic);
    }

    public void suggestChanges(User user, DraftArticle draftArticle, List<Suggestion> suggestedChanges) throws InvalidUserException {
        draftArticle.suggestChanges(user, suggestedChanges);
    }

}
