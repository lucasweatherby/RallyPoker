package com.lucas.pokerevaluation.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lucas.pokerevaluation.interfaces.PokerHandRankValidator;
import com.lucas.pokerevaluation.pojos.Card;
import com.lucas.pokerevaluation.pojos.Card.suit;

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
