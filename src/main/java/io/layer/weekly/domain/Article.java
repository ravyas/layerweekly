package io.layer.weekly.domain;

import java.util.List;
import java.util.UUID;

public class Article extends Entity {

    private String title;

    private List<Heading> headings;

    public Article(){
        this.setId(UUID.randomUUID().toString());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Heading> getHeadings() {
        return headings;
    }

    public void setHeadings(List<Heading> headings) {
        this.headings = headings;
    }
}
