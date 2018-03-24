package com.codurance.social.services;

import com.codurance.social.entities.Input;
import com.codurance.social.entities.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialNetworkServices
{
    private Map<String, List<Post>> userPosts = new HashMap<>();
    private Map<String, List<String>> followers = new HashMap<>();

    public List<Post> processInput(Input input)
    {
        String username = input.getUserName();
        List<Post> response = null;

        switch (input.getType())
        {
            case EPost:
                Post post = new Post(input.getMessage());
                List<Post> posts = userPosts.get(username);
                if(posts == null)
                {
                    posts = new ArrayList<>();
                }
                posts.add(post);
                break;

            case ERead:
                response = userPosts.get(username);
                break;

            case EWall:
                //
                // First, retrieve people the user follows
                // and get their posts
                //
                List<String> followed = followers.get(username);
                if(followed != null)
                {
                    for(String user : followed)
                    {
                        List<Post> followedPosts = userPosts.get(user);
                        if(followedPosts != null)
                        {
                            response.addAll(followedPosts);
                        }
                    }
                }

                //
                // And add user's own post as well
                //
                List<Post> ownPosts = userPosts.get(username);
                if (ownPosts != null)
                {
                    response.addAll(ownPosts);
                }

                break;

            case EFollow:
                String followedUser = input.getFollowedUserName();
                List<String> followedUsers =  followers.get(username);
                if(followedUsers == null)
                {
                    followedUsers = new ArrayList<>();
                }
                followedUsers.add(followedUser);
                break;

            default:
                break;
        }

        return response;
    }
}
