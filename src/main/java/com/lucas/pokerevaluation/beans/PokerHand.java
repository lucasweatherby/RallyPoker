package com.lucas.pokerevaluation.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.lucas.pokerevaluation.interfaces.PokerHandRankValidator;
import com.lucas.pokerevaluation.pojos.Card;
import com.lucas.pokerevaluation.pojos.Card.suit;

public class PokerHand implements PokerHandRankValidator{
	
	private List<Card> cards = new ArrayList<Card>();
	private handRank rank = handRank.UNDECIDED;
	public handRank getRank() {
		return rank;
	}

	public void setRank(handRank rank) {
		this.rank = rank;
	}

	public enum handRank {
		PAIR,TWO_PAIR,THREE_OF_A_KIND,STRAIGHT,FLUSH,FULL_HOUSE,FOUR_OF_A_KIND,STRAIGHT_FLUSH,ROYAL_FLUSH,INVALID_INPUT,UNDECIDED
	}	

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public String getPokerHandRank()
	{
		if(isStraightFlush())
		{
			this.rank= handRank.STRAIGHT_FLUSH;
			return this.getRank().toString();
		}
		if(isFourOfAKind())
		{
			this.rank= handRank.FOUR_OF_A_KIND;
			return this.getRank().toString();
		}
		if(isFlush())
		{
			this.rank= handRank.FLUSH;
			return this.getRank().toString();
		}
		if(isStraight())
		{
			this.rank= handRank.STRAIGHT;
			return this.getRank().toString();
		}
		if(isThreeOfAKind())
		{
			this.rank= handRank.THREE_OF_A_KIND;
			return this.getRank().toString();
		}
		if(isPair())
		{
			this.rank= handRank.PAIR;
			return this.getRank().toString();
		}
		return this.getRank().toString();
	}
	
	public void parseFromInput(String[] args)
	{
		List<String> segments = new ArrayList<String>();
		for (int i = 0; i < args.length; i++) 
		{
				segments.add(args[i]);
		}
		
		for (Iterator<String> iterator = segments.iterator(); iterator.hasNext();) {
			String segmentName=  (String) iterator.next();
			String a = "";
			Character b=null;
			Card card = new Card();
			if(segmentName.length()==2)
			{
				a = segmentName.substring(0, 1);
				b = segmentName.charAt(1);
			}
			else if(segmentName.length()==3)
			{
				a = segmentName.substring(0, 2);
				b = segmentName.charAt(2);
			}
			else
			{
				System.out.println("This is a problem");
			}
			
			switch (a) 
			{
	            case "A":  card.setCardValue(14);break;
	            case "K":  card.setCardValue(13);break;
	            case "Q":  card.setCardValue(12);break;
	            case "J":  card.setCardValue(11);break;
	            default: 	card.setCardValue(Integer.parseInt(a));break;
			}
			
			switch (b) 
			{
	            case 'c':  card.setSuit(suit.CLUBS);break;
	            case 'h':  card.setSuit(suit.HEARTS);break;
	            case 'd':  card.setSuit(suit.DIAMONDS);break;
	            case 's':  card.setSuit(suit.SPADES);break;
			}
			System.out.println(card.getCardValue() + card.getSuit().toString());
			cards.add(card);
		}
	}

	@Override
	public boolean isPair() {
		int[] rankCount = new int[14];
		for (Card card : cards) {
            rankCount[card.getCardValue()]++;
        }
		for (int i = 1; i < rankCount.length; i++) {
			if(rankCount[i] == 2)
				return true;
		}
		return false;
	}

	@Override
	public boolean isTwoPair() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isThreeOfAKind() {
		int[] rankCount = new int[14];
		for (Card card : cards) {
            rankCount[card.getCardValue()]++;
        }
		for (int i = 1; i < rankCount.length; i++) {
			if(rankCount[i] == 3)
				return true;
		}
		return false;
	}

	@Override
	public boolean isStraight() {
		List<Integer> list = new ArrayList<Integer>();
		for (Iterator iterator = cards.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
			list.add(card.getCardValue());
		}
		Collections.sort( list );
		
		for (int i = 0; i < list.size()-1; i++) 
		{
            if (list.get(i) !=  list.get(i + 1) -1) 
            {
                return false;
            }
        }
		
		return true;
	}

	@Override
	public boolean isFlush() {
		suit flushSuit = cards.get(0).getSuit();
		for (Iterator iterator = cards.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
			if(!card.getSuit().equals(flushSuit))
			{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean isFullHouse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFourOfAKind() {
		int[] rankCount = new int[14];
		for (Card card : cards) {
            rankCount[card.getCardValue()]++;
        }
		for (int i = 1; i < rankCount.length; i++) {
			if(rankCount[i] == 4)
				return true;
		}
		return false;
	}

	@Override
	public boolean isStraightFlush() {
		return (isFlush() && isStraight());
	}

	@Override
	public boolean isRoyalFlush() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
