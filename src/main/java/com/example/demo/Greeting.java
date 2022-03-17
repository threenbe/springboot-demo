package com.example.demo;

public class Greeting {
    //This is what will comprise the body of the JSON that we get
    //when we call a GET request for our /greeting service.
    private final long id;//a unique identifier for the greeting
    private final String content;//textual representation of the greeting

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
