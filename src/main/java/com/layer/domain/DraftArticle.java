package com.layer.domain;

import java.util.List;

public class DraftArticle {

    private String title;

    private String content;

    private List<Topic> relatedTopics;

    private List<String> suggestedChanges;

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

    public List<Topic> getRelatedTopics() {
        return relatedTopics;
    }

    public void setRelatedTopics(List<Topic> relatedTopics) {
        this.relatedTopics = relatedTopics;
    }

    public List<String> getSuggestedChanges() {
        return suggestedChanges;
    }

    public void setSuggestedChanges(List<String> suggestedChanges) {
        this.suggestedChanges = suggestedChanges;
    }
}
