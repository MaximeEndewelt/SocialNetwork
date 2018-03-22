package com.codurance.social;

import com.codurance.social.entities.Input;
import com.codurance.social.entities.InputParser;
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

		Scanner scanner = new Scanner(System.in);
		String inputString;

		//
		// Create a loop waiting for user input
		//
		while (true)
		{
			inputString = scanner.nextLine();
			Input input = InputParser.parseInput(inputString);

			// Do something
		}


	}
}
