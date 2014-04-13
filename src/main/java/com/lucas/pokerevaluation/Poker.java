package com.lucas.pokerevaluation;

import com.lucas.pokerevaluation.beans.PokerHand;

public class Poker {

	public static void main(String[] args) {
		args=new String[]{"Ad","10d","7d", "8c", "Kd"};
		PokerHand hand = new PokerHand();
		hand.parseFromInput(args);
		System.out.println(hand.getPokerHandRank());		
	}

}
