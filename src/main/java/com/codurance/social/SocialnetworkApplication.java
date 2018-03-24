package com.codurance.social;

import com.codurance.social.entities.Input;
import com.codurance.social.entities.InputParser;
import com.codurance.social.entities.Post;
import com.codurance.social.services.SocialNetworkServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
					List<Post> posts = services.processInput(input);
					renderOutput(posts);
				}
			}
		}
		finally
		{
			scanner.close();
		}

		System.out.println("Social Network is OFF");
	}

	/**
	 * Render a formatted output when the user
	 * wants to read posts
	 * @param posts a list of posts
	 */
	private void renderOutput(List<Post> posts)
	{
		//
		// The sort can be done here in O(n * log(n))
		//
		if(posts != null)
		{
			Collections.sort(posts, Comparator.comparingLong(Post::getTimestamp));
			posts.forEach((post) -> System.out.println(post.getUsername()+" - "+post.getMessage()+" ("+convertTimestamp(post.getTimestamp())+")"));
		}
	}

	/**
	 * Convert a timestamp into a human readable format
	 * @param timestamp
	 * @return
	 */
	private String convertTimestamp(long timestamp)
	{
		long minutesAgo = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - timestamp);
		String response = minutesAgo+ " minutes ago";
		return  response;
	}
}
