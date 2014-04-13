package com.lucas.pokerevaluation;

import com.lucas.pokerevaluation.beans.PokerHand;

public class Poker {

	public static void main(String[] args) {
		//This is just one quick way to simulate args through eclipse
		//args=new String[]{"Ad","2d","3d", "4c", "5d"};
		
		//Make The Object
		PokerHand hand = new PokerHand();
		
		//Parse through the arguments
		hand.parseFromInput(args);
		
		//Print out the hands rank
		System.out.println(hand.getPokerHandRank());		
	}

}
