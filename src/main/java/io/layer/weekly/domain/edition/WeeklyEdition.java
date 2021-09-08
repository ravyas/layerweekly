package io.layer.weekly.domain.edition;

import io.layer.weekly.domain.Entity;
import io.layer.weekly.domain.InvalidUserException;
import io.layer.weekly.domain.article.Article;
import io.layer.weekly.domain.article.Content;
import io.layer.weekly.domain.article.DraftArticle;
import io.layer.weekly.domain.article.Heading;
import io.layer.weekly.domain.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WeeklyEdition extends Entity {

    private List<Topic> topics = new ArrayList<>();

    private List<DraftArticle> draftArticles = new ArrayList<>();

    private List<Article> articles = new ArrayList<>();

    private boolean currentEdition = false;

    public WeeklyEdition(){
        this.setId(UUID.randomUUID().toString());
    }

    public void addTopic(User user, Topic topic) throws InvalidUserException {
        if(!User.Role.CHIEFEDITOR.equals(user.getRole())) {
            throw new InvalidUserException();
        }
        topics.add(topic);
    }

    public Article publishArticle(DraftArticle draftArticle) {
        Article article = new Article();
        article.setTitle(draftArticle.getTitle());
        article.setHeadings(convertToHeadings(draftArticle.getContent()));
        return article;
    }

    private List<Heading> convertToHeadings(Content content) {
        List<Heading> headings = new ArrayList<>();
        String heading = content.getContent();
        if(content.getContent().contains(" ")) {
            heading = content.getContent().split(" ")[0];
        }
        headings.add(new Heading(heading, content.getContent()));
        return headings;
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
        draftArticle.setJournalistAssigneeId(user.getId());
        draftArticles.add(draftArticle);
    }


    public void setDraftArticles(List<DraftArticle> draftArticles) {
        this.draftArticles = draftArticles;
    }

    public boolean isCurrentEdition() {
        return currentEdition;
    }

    public void setCurrentEdition(boolean currentEdition) {
        this.currentEdition = currentEdition;
    }
}