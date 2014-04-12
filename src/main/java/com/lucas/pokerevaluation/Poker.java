package com.lucas.pokerevaluation;

import com.lucas.pokerevaluation.beans.PokerHand;

public class Poker {

	public static void main(String[] args) {
		//Test Commit2
		System.out.println("Hello world");
		args=new String[]{"-h","7d","4c","8c", "6h", "5s"};
		
		
		PokerHand hand = new PokerHand();
		hand.parseFromInput(args);
		
		
	}

}
