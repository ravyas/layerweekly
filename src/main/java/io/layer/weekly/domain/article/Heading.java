package io.layer.weekly.domain.article;

public class Heading {

    private String heading;
    private String text;

    public Heading(String heading, String text) {
        this.heading = heading;
        this.text = text;
    }

    public String getHeading() {
        return heading;
    }

    public String getText() {
        return text;
    }

}
