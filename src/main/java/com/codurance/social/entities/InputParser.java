package com.codurance.social.entities;

public class InputParser
{
    public static Input parseInput(String inputString)
    {
        Input input = null;
        if (inputString == null)
        {
            return input;
        }

        String[] splittedInput = inputString.split("\\s+");
        if(splittedInput.length < 1)
        {
            return input;
        }

        int length = splittedInput.length;
        String userName = splittedInput[0];

        if(length == 1)
        {
            //
            // Arguments length is 1, then it's a READ type or EXIT program
            //
            if(userName.equalsIgnoreCase("exit"))
            {
                input = InputGenerator.generateExit();
            }
            else
            {
                input =  InputGenerator.generateRead(userName);
            }
        }

        if(length == 2)
        {
            //
            // Arguments length is 2, then it's a WALL type
            // As per requirements, I'm not checking that the value is actually "wall"
            //
            input = InputGenerator.generateWall(userName);
        }

        if(length == 3)
        {
            //
            // Arguments length is 3, then it's a POST or FOLLOW type
            // Let's check the 2nd argument
            //
            String command = splittedInput[1];
            String value = splittedInput[2];
            if(command.equalsIgnoreCase("follows"))
            {
                input = InputGenerator.generateFollow(userName, value);
            }
            else
            {
                input = InputGenerator.generatePost(userName, value);
            }
        }

        return input;
    }
}
