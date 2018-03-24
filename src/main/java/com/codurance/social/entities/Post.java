package com.codurance.social.entities;

public class Post
{
    private final String message;
    private final long timestamp;

    public Post(String message)
    {
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
}
