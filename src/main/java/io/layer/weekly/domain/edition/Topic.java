package io.layer.weekly.domain.edition;

import io.layer.weekly.domain.Entity;

public class Topic extends Entity {

    private String topic;

    public Topic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
