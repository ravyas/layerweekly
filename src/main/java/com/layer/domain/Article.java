package com.layer.domain;

import java.util.List;

public class Article extends Entity {

    private String title;

    private List<Heading> headings;

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
