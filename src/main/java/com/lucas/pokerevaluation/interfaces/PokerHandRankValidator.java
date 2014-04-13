package com.lucas.pokerevaluation.interfaces;

import java.util.List;

import com.lucas.pokerevaluation.pojos.Card;


public interface PokerHandRankValidator {
	public boolean isPair(List<Card> cards);
	public boolean isTwoPair(List<Card> cards);
	public boolean isThreeOfAKind(List<Card> cards);
	public boolean isStraight(List<Card> cards);
	public boolean isFlush();
	public boolean isFullHouse(List<Card> cards);
	public boolean isFourOfAKind(List<Card> cards);
	public boolean isStraightFlush(List<Card> cards);
	public boolean isRoyalFlush(List<Card> cards);
	
}
