package com.lucas.pokerevaluation;

import com.lucas.pokerevaluation.beans.PokerHand;

public class Poker {

	public static void main(String[] args) {
		args=new String[]{"7d","4c","8c", "6h", "5s"};
		PokerHand hand = new PokerHand();
		hand.parseFromInput(args);
		
		
	}

}
