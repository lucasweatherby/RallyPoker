package com.lucas.pokerevaluation;

import com.lucas.pokerevaluation.beans.PokerHand;

public class Poker {

	public static void main(String[] args) {
		args=new String[]{"7d","7s","5h", "7c", "5d"};
		PokerHand hand = new PokerHand();
		hand.parseFromInput(args);
		System.out.println(hand.getPokerHandRank());		
	}

}
