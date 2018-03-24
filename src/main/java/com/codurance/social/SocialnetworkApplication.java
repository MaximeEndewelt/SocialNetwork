package com.codurance.social;

import com.codurance.social.entities.Input;
import com.codurance.social.entities.InputParser;
import com.codurance.social.services.SocialNetworkServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SocialnetworkApplication implements CommandLineRunner
{
	public static void main(String[] args)
	{
		SpringApplication.run(SocialnetworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("Social Network is ON");

		SocialNetworkServices services = new SocialNetworkServices();
		Scanner scanner = null;
		boolean running = true;

		try
		{
			scanner = new Scanner(System.in);
			String inputString;

			//
			// Create a loop waiting for user input
			//
			while (running)
			{
				inputString = scanner.nextLine();
				Input input = InputParser.parseInput(inputString);
				if (input.getType().equals(Input.InputType.EExit))
				{
					// Exit program
					running = false;
				}
				else
				{
					services.processInput(input);
				}
			}
		}
		finally
		{
			scanner.close();
		}

		System.out.println("Social Network is OFF");


	}
}
