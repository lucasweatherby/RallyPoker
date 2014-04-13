package com.lucas.pokerevaluation;

import com.lucas.pokerevaluation.beans.PokerHand;

public class Poker {

	public static void main(String[] args) {
		args=new String[]{"7d","4d","8d", "6d", "5d"};
		PokerHand hand = new PokerHand();
		hand.parseFromInput(args);
		
		if(hand.isStraight())
		{
			System.out.println("Hand is a straight");
		}
		else
		{
			System.out.println("Not a straight");
		}
		if(hand.isFlush())
		{
			System.out.println("Hand is a flush");
		}
		else
		{
			System.out.println("Not a flush");
		}
		if(hand.isStraightFlush())
		{
			System.out.println("Hand is a straight flush");
		}
		else
		{
			System.out.println("Not a straight flush");
		}
	}

}
