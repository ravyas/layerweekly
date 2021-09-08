package io.layer.weekly.domain.article;

import io.layer.weekly.domain.Entity;
import io.layer.weekly.domain.InvalidUserException;
import io.layer.weekly.domain.users.Journalist;

import java.util.List;
import java.util.UUID;

public class Article extends Entity {

    private Title title;

    private List<Heading> headings;

    public Article(){
        this.setId(UUID.randomUUID().toString());
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<Heading> getHeadings() {
        return headings;
    }

    public void setHeadings(List<Heading> headings) {
        this.headings = headings;
    }

    public void updateDraftArticle(Journalist journalist, DraftArticle draftArticle) throws InvalidUserException {
        if(draftArticle.getJournalistAssigneeId() != journalist.getId()) {
            throw new InvalidUserException("Only assigned journalist can update the draft article");
        }
    }
}
