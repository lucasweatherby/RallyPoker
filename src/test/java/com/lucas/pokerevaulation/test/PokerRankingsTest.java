package com.lucas.pokerevaulation.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lucas.pokerevaluation.beans.PokerHand;

public class PokerRankingsTest {

	@Test
	public void pairTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 8c Qh 5s");
		assertEquals(true,hand.isPair());
	}
	
	@Test
	public void twoPairTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 8c Qh 4s");
		assertEquals(true,hand.isTwoPair());
	}
	
	@Test
	public void threeOfAKindTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 8c 4h 4s");
		assertEquals(true,hand.isThreeOfAKind());
	}
	
	@Test
	public void straightTest() {
		PokerHand hand = createTestPokerHand("7d 4c 8c 6h 5s");
		assertEquals(true,hand.isStraight());
	}

	@Test
	public void flushTest() {
		PokerHand hand = createTestPokerHand("7d 9d Jd 5d 4d");
		assertEquals(true,hand.isFlush());
	}
	
	@Test
	public void fullHouseTest() {
		PokerHand hand = createTestPokerHand("7d 7c 7s 5d 5h");
		assertEquals(true,hand.isFullHouse());
	}
	@Test
	public void fourOfAKindTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 4c 4h 4s");
		assertEquals(true,hand.isFourOfAKind());
	}
	
	@Test
	public void straightFlushtest() {
		PokerHand hand = createTestPokerHand("7d 4d 8d 6d 5d");
		assertEquals(true,hand.isStraightFlush());
	}
	
	@Test
	public void royalFlushtest() {
		PokerHand hand = createTestPokerHand("Ah Kh Qh Jh 10h");
		assertEquals(true,hand.isRoyalFlush());
	}
	
	
	private PokerHand createTestPokerHand(String inputString)
	{
		String[] args = inputString.split(" ");
		PokerHand hand = new PokerHand();
		hand.parseFromInput(args);
		return hand;
	}

}
