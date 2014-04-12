package com.lucas.pokerevaluation;

import java.util.ArrayList;
import java.util.List;

public class Poker {

	public static void main(String[] args) {
		//Test Commit2
		System.out.println("Hello world");
		args=new String[]{"-h","7d","4c","8c", "6h", "5s"};
		List<String> segments = new ArrayList<String>();
		
		for (int i = 0; i < args.length; i++) 
		{
				segments.add(args[i]);
		}
		
	}

}
