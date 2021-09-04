package com.layer.domain;

import com.layer.domain.users.User;

import java.util.List;

public class DraftArticle extends Entity {

    private String title;

    private String content;

    private List<Topic> connectedTopics;

    private List<String> suggestedChanges;

    public DraftArticle(String title, String content, List<Topic> connectedTopics) {
        this.title = title;
        this.content = content;
        this.connectedTopics = connectedTopics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getSuggestedChanges() {
        return suggestedChanges;
    }

    public void setSuggestedChanges(List<String> suggestedChanges) {
        this.suggestedChanges = suggestedChanges;
    }

    public void suggestChanges(User user, List<String> suggestions) throws InvalidUserException {
        if(!User.Role.COPYWRITER.equals(user.getRole())) {
            throw new InvalidUserException("Only CopyWriter can make suggestions");
        }
        this.suggestedChanges = suggestions;
    }

    public Article publishArticle() {
        Article article = new Article();
        article.setTitle(getTitle());
//        this.headings = draftArticle.getHeadings();
        return article;
    }
}
