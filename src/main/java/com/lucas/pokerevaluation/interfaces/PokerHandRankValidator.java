package com.lucas.pokerevaluation.interfaces;

public interface PokerHandRankValidator {
	public boolean isPair();
	public boolean isTwoPair();
	public boolean isThreeOfAKind();
	public boolean isStraight();
	public boolean isFlush();
	public boolean isFullHouse();
	public boolean isFourOfAKind();
	public boolean isStraightFlush();
	public boolean isRoyalFlush();
	
}
