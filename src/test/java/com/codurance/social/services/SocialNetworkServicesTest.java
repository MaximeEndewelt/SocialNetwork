package com.codurance.social.services;

import com.codurance.social.entities.Input;
import com.codurance.social.entities.InputGenerator;
import com.codurance.social.entities.Post;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SocialNetworkServicesTest
{
    private  SocialNetworkServices services;

    @Before
    public void setUp()
    {
        services = new SocialNetworkServices();
    }

    @Test
    public void processInputTest()
    {
        Input input = InputGenerator.generatePost("maxime", "hello");
        Input input1 = InputGenerator.generatePost("francis", "I'm francis");
        Input read = InputGenerator.generateRead("maxime");
        Input read1 = InputGenerator.generateRead("maxime");

        Input follow = InputGenerator.generateFollow("maxime", "francis");
        Input wall = InputGenerator.generateWall("maxime");

        List<Post> responses;

        services.processInput(input);
        responses = services.processInput(read);
        Assert.assertThat(responses.size(), Is.is(1));

        services.processInput(input1);
        responses = services.processInput(read1);
        Assert.assertThat(responses.size(), Is.is(1));

        responses = services.processInput(wall);
        Assert.assertThat(responses.size(), Is.is(1));

        // After follow, should have maxime and francis timeline
        services.processInput(follow);
        responses = services.processInput(wall);
        Assert.assertThat(responses.size(), Is.is(2));


    }
}
