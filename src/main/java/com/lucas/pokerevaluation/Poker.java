package com.lucas.pokerevaluation;

import com.lucas.pokerevaluation.beans.PokerHand;

public class Poker {

	public static void main(String[] args) {
		args=new String[]{"7d","4d","8d", "6d", "5d"};
		PokerHand hand = new PokerHand();
		hand.parseFromInput(args);
		System.out.println(hand.getPokerHandRank());	
		
	}

}
