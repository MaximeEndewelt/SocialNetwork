package com.codurance.social.entities;

/**
 * Entity representing an input based on its type
 */
public class Input
{
    private final InputType type;
    private final String userName;
    private String followedUserName;
    private String message;

    public Input(InputType type, String userName)
    {
        this.type = type;
        this.userName = userName;
    }

    public void setFollowedUserName(String followedUserName) {
        this.followedUserName = followedUserName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InputType getType() {
        return type;
    }

    public String getUserName() {
        return userName;
    }

    public String getFollowedUserName() {
        return followedUserName;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Type of Input
     */
    public enum InputType
    {
        EPost,
        ERead,
        EFollow,
        EWall,
        EExit
    }
}
