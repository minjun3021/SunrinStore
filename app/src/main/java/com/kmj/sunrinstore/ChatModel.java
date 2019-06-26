package com.kmj.sunrinstore;

public class ChatModel {
    private String content;
    private String name;

    public ChatModel(String content, String name) {
        this.content = content;
        this.name = name;
    }
    public ChatModel(){}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
