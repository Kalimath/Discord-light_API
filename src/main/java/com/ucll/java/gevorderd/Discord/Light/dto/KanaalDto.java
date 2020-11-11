package com.ucll.java.gevorderd.Discord.Light.dto;

public class KanaalDto {
    private long id;
    private String name, topic;

    public KanaalDto(long id, String name, String topic) {
        this.id = id;
        this.name = name;
        this.topic = topic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
