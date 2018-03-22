package com.codurance.social.entities;

public class InputGenerator
{
    public static Input generatePost(String userName, String message)
    {
        Input input = new Input(Input.InputType.EPost, userName);
        input.setMessage(message);

        return input;
    }

    public static Input generateRead(String userName)
    {
        Input input = new Input(Input.InputType.ERead, userName);

        return input;
    }

    public static Input generateFollow(String userName, String followedUserName)
    {
        Input input = new Input(Input.InputType.EFollow, userName);
        input.setFollowedUserName(followedUserName);

        return input;
    }

    public static Input generateWall(String userName)
    {
        Input input = new Input(Input.InputType.EWall, userName);

        return input;
    }
}
