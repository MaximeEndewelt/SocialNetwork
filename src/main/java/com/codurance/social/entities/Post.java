package com.codurance.social.entities;

/**
 * Entity representing a post
 * defined by a user, a message and a timestamp
 */
public class Post
{
    private final String username;
    private final String message;
    private final long timestamp;

    public Post(String username, String message)
    {
        this.username = username;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
