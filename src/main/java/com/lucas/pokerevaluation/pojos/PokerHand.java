package com.lucas.pokerevaluation.pojos;

import java.util.ArrayList;
import java.util.List;

import com.lucas.pokerevaluation.interfaces.PokerHandRankValidator;

public class PokerHand implements PokerHandRankValidator{
	
	private List<Card> cards = new ArrayList<Card>();

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public String getPokerHandRank()
	{
		return "";
	}
	
	public void parseFromInput(String[] args)
	{
		List<String> segments = new ArrayList<String>();
		for (int i = 0; i < args.length; i++) 
		{
				segments.add(args[i]);
		}
	}

	@Override
	public boolean isPair(List<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTwoPair(List<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isThreeOfAKind(List<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStraight(List<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFlush(List<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFullHouse(List<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFourOfAKind(List<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStraightFlush(List<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRoyalFlush(List<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}
}
