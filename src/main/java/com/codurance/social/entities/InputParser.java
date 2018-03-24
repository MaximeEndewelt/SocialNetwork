package com.codurance.social.entities;

/**
 * Utility class used for parsing user input
 */
public class InputParser
{
    /**
     * Parse the user input
     * @param inputString the rwa input
     * @return a entity representing a user input
     */
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

        if(length > 2)
        {
            //
            // Arguments length is greater than 2, then it's a POST or FOLLOW type (length == 3)
            // Let's check the 2nd argument
            //
            String command = splittedInput[1];

            if(command.equalsIgnoreCase("follows"))
            {
                String followed = splittedInput[2];
                input = InputGenerator.generateFollow(userName, followed);
            }
            else
            {
                // Reconcatenate further words
                // (I'm not making sure that the input has the correct format as per requirements)
                String message = inputString.split("->")[1];
                input = InputGenerator.generatePost(userName, message);
            }
        }

        return input;
    }
}
