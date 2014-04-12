package com.lucas.pokerevaluation.pojos;

import java.util.ArrayList;
import java.util.List;

public class PokerHand {
	
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
	
}
