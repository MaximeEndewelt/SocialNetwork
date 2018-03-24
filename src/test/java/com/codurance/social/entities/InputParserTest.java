package com.codurance.social.entities;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class InputParserTest
{
    @Test
    public void parseInputPostTest()
    {
        Input input = InputParser.parseInput("maxime -> hello how are you");
        Assert.assertThat(input.getType(), Is.is(Input.InputType.EPost));
        Assert.assertThat(input.getMessage(), Is.is(" hello how are you"));
        Assert.assertThat(input.getUserName(), Is.is("maxime"));
    }

    @Test
    public void parseInputReadTest()
    {
        Input input = InputParser.parseInput("maxime");
        Assert.assertThat(input.getType(), Is.is(Input.InputType.ERead));
        Assert.assertThat(input.getUserName(), Is.is("maxime"));
    }

    @Test
    public void parseInputFollowTest()
    {
        Input input = InputParser.parseInput("maxime follows francis");
        Assert.assertThat(input.getType(), Is.is(Input.InputType.EFollow));
        Assert.assertThat(input.getUserName(), Is.is("maxime"));
        Assert.assertThat(input.getFollowedUserName(), Is.is("francis"));
    }

    @Test
    public void parseInputWallTest()
    {
        Input input = InputParser.parseInput("maxime wall");
        Assert.assertThat(input.getType(), Is.is(Input.InputType.EWall));
        Assert.assertThat(input.getUserName(), Is.is("maxime"));
    }
}
