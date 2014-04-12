package com.lucas.pokerevaluation.pojos;

public class Card {
	private suit cardSuit;
	
	public enum suit {
		DIAMONDS,HEARTS,SPADES,CLUBS
	}	
	private int cardValue = 0;
	
	public int getCardValue() {
		return cardValue;
	}
	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public suit getSuit() {
		return cardSuit;
	}


	public void setSuit(suit cardSuit) {
		this.cardSuit = cardSuit;
	}
}
