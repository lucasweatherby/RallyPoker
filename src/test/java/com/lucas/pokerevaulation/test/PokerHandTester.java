package com.lucas.pokerevaulation.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lucas.pokerevaluation.beans.PokerHand;

public class PokerHandTester {

	@Test
	public void pairTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 8c Qh 5s");
		assertEquals("PAIR",hand.getPokerHandRank());
	}
	
	@Test
	public void twoPairTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 8c Qh 4s");
		assertEquals("TWO_PAIR",hand.getPokerHandRank());
	}
	
	@Test
	public void threeOfAKindTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 8c 4h 4s");
		assertEquals("THREE_OF_A_KIND",hand.getPokerHandRank());
	}
	
	@Test
	public void straightTest() {
		PokerHand hand = createTestPokerHand("7d 4c 8c 6h 5s");
		assertEquals("STRAIGHT",hand.getPokerHandRank());
	}

	@Test
	public void flushTest() {
		PokerHand hand = createTestPokerHand("7d 9d Jd 5d 4d");
		assertEquals("FLUSH",hand.getPokerHandRank());
	}
	
	@Test
	public void fullHouseTest() {
		PokerHand hand = createTestPokerHand("7d 7c 7s 5d 5h");
		assertEquals("FULL_HOUSE",hand.getPokerHandRank());
	}
	@Test
	public void fourOfAKindTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 4c 4h 4s");
		assertEquals("FOUR_OF_A_KIND",hand.getPokerHandRank());
	}
	
	@Test
	public void straightFlushtest() {
		PokerHand hand = createTestPokerHand("7d 4d 8d 6d 5d");
		assertEquals("STRAIGHT_FLUSH",hand.getPokerHandRank());
	}
	
	@Test
	public void royalFlushtest() {
		PokerHand hand = createTestPokerHand("Ah Kh Qh Jh 10h");
		assertEquals("ROYAL_FLUSH",hand.getPokerHandRank());
	}
	
	@Test
	public void highCardtest() {
		PokerHand hand = createTestPokerHand("Ah Kc 7s 5c 10h");
		assertEquals("HIGH_CARD A",hand.getPokerHandRank());
	}
	
	@Test
	public void twentyFiveTest() {
		PokerHand hand = createTestPokerHand("Ah 25h Qh Jh 10h");
		assertEquals("INVALID_INPUT",hand.getPokerHandRank());
	}
	
	@Test
	public void notEnoughCardsTest() {
		PokerHand hand = createTestPokerHand("Ah 25h Qh Jh");
		assertEquals("INVALID_INPUT",hand.getPokerHandRank());
	}
	
	@Test
	public void gibberishTest() {
		PokerHand hand = createTestPokerHand("Ah 25h Qh sdfsdfs Jh");
		assertEquals("INVALID_INPUT",hand.getPokerHandRank());
	}
	
	@Test
	public void tooManyCardsTest() {
		PokerHand hand = createTestPokerHand("7d 4d 8d 6d 5d 2c");
		assertEquals("INVALID_INPUT",hand.getPokerHandRank());
	}
	
	@Test
	public void invalidSuitTest() {
		PokerHand hand = createTestPokerHand("7d 4z 8d 6d 5d");
		assertEquals("INVALID_INPUT",hand.getPokerHandRank());
	}
	
	@Test
	public void missingSuitTest() {
		PokerHand hand = createTestPokerHand("7d 4 8d 6d 5d");
		assertEquals("INVALID_INPUT",hand.getPokerHandRank());
	}
	
	@Test
	public void missingValueTest() {
		PokerHand hand = createTestPokerHand("7d c 8d 6d 5d");
		assertEquals("INVALID_INPUT",hand.getPokerHandRank());
	}
	
	@Test
	public void upperCaseSuitTest() {
		PokerHand hand = createTestPokerHand("7d 4C 8d 6d 5d");
		assertEquals("INVALID_INPUT",hand.getPokerHandRank());
	}
	
	@Test
	public void lowerCaseValueTest() {
		PokerHand hand = createTestPokerHand("ad 5c 8d 6d 5d");
		assertEquals("INVALID_INPUT",hand.getPokerHandRank());
	}
	
	@Test
	public void wrongValueTest() {
		PokerHand hand = createTestPokerHand("Zd 5c 8d 6d 5d");
		assertEquals("INVALID_INPUT",hand.getPokerHandRank());
	}
	
	
	@Test
	public void noSpacesTest() {
		PokerHand hand = createTestPokerHand("Ad5c8d6d5d");
		assertEquals("INVALID_INPUT",hand.getPokerHandRank());
	}
	
	private PokerHand createTestPokerHand(String inputString)
	{
		String[] args = inputString.split(" ");
		PokerHand hand = new PokerHand();
		hand.parseFromInput(args);
		return hand;
	}
}
