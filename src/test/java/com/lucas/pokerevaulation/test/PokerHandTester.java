package com.lucas.pokerevaulation.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lucas.pokerevaluation.pojos.PokerHand;

public class PokerHandTester {

	@Test
	public void pairTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 8c Qh 5s");
		assertEquals("Pair",hand.getPokerHandRank());
	}
	
	@Test
	public void twoPairTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 8c Qh 4s");
		assertEquals("Two Pair",hand.getPokerHandRank());
	}
	
	@Test
	public void threeOfAKindTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 8c 4h 4s");
		assertEquals("Three of a Kind",hand.getPokerHandRank());
	}
	
	@Test
	public void straightTest() {
		PokerHand hand = createTestPokerHand("7d 4c 8c 6h 5s");
		assertEquals("Straight",hand.getPokerHandRank());
	}

	@Test
	public void flushTest() {
		PokerHand hand = createTestPokerHand("7d 9d Jd 5d 4d");
		assertEquals("Flush",hand.getPokerHandRank());
	}
	
	@Test
	public void fullHouseTest() {
		PokerHand hand = createTestPokerHand("7d 7c 7s 5d 5h");
		assertEquals("Full House",hand.getPokerHandRank());
	}
	@Test
	public void fourOfAKindTest() {
		PokerHand hand = createTestPokerHand("Qd 4c 4c 4h 4s");
		assertEquals("Four of a Kind",hand.getPokerHandRank());
	}
	
	@Test
	public void straightFlushtest() {
		PokerHand hand = createTestPokerHand("7d 4d 8d 6d 5d");
		assertEquals("Straight Flush",hand.getPokerHandRank());
	}
	
	@Test
	public void royalFlushtest() {
		PokerHand hand = createTestPokerHand("Ah Kh Qh Jh 10h");
		assertEquals("Straight Flush",hand.getPokerHandRank());
	}
	
	private PokerHand createTestPokerHand(String inputString)
	{
		return null;
	}
}
