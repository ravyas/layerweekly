package io.layer.weekly.domain.article;

import io.layer.weekly.domain.Entity;
import io.layer.weekly.domain.InvalidUserException;
import io.layer.weekly.domain.edition.Topic;
import io.layer.weekly.domain.users.CopyWriter;
import io.layer.weekly.domain.users.Journalist;
import io.layer.weekly.domain.users.User;

import java.util.List;
import java.util.UUID;

public class DraftArticle extends Entity {

    private Title title;

    private Content content;

    private List<Topic> connectedTopics;

    private List<Suggestion> suggestedChanges;

    private String journalistAssigneeId;

    private String copywriterAssigneeId;

    public DraftArticle(Journalist journalist, String title, String content, List<Topic> connectedTopics) {
        this.title = new Title(title);
        this.content = new Content(content);
        this.connectedTopics = connectedTopics;
        this.journalistAssigneeId = journalist.getId();
        this.setId(UUID.randomUUID().toString());
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<Suggestion> getSuggestedChanges() {
        return suggestedChanges;
    }

    public void setSuggestedChanges(List<Suggestion> suggestedChanges) {
        this.suggestedChanges = suggestedChanges;
    }

    public void suggestChanges(User user, List<Suggestion> suggestions) throws InvalidUserException {
        if(!User.Role.COPYWRITER.equals(user.getRole())) {
            throw new InvalidUserException("Only CopyWriter can make suggestions");
        }
        this.suggestedChanges = suggestions;
    }

    public void updateDraftArticle(Journalist journalist, String title, String content, List<Topic> connectedTopics) throws InvalidUserException {
        if(journalistAssigneeId != journalist.getId()) {
            throw new InvalidUserException("Only assigned journalist can update the draft article");
        }
        this.title = new Title(title);
        this.content = new Content(content);
        this.connectedTopics = connectedTopics;
    }

    public boolean assignToCopyWriter(CopyWriter copyWriter) {
        this.copywriterAssigneeId = copyWriter.getId();
        return true;
    }

    public List<Topic> getConnectedTopics() {
        return connectedTopics;
    }

    public void setConnectedTopics(List<Topic> connectedTopics) {
        this.connectedTopics = connectedTopics;
    }

    public String getJournalistAssigneeId() {
        return journalistAssigneeId;
    }

    public void setJournalistAssigneeId(String journalistAssigneeId) {
        this.journalistAssigneeId = journalistAssigneeId;
    }
}
