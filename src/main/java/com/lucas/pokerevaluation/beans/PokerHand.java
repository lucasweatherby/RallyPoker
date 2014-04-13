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
		PAIR,TWO_PAIR,THREE_OF_A_KIND,STRAIGHT,FLUSH,FULL_HOUSE,FOUR_OF_A_KIND,STRAIGHT_FLUSH,ROYAL_FLUSH,HIGH_CARD,INVALID_INPUT,UNDECIDED
	}	

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public String getPokerHandRank()
	{
		//First we check to make sure that the hand isn't already invalid
		if(this.rank == handRank.INVALID_INPUT)
		{
			return this.getRank().toString();
		}
		//Then we check for the hand rank by priority of Poker rules.
		//If a hand rank is round it will be immediately returned
		if(isRoyalFlush())
		{
			this.rank= handRank.ROYAL_FLUSH;
			return this.getRank().toString();
		}
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
		if(isFullHouse())
		{
			this.rank= handRank.FULL_HOUSE;
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
		if(isTwoPair())
		{
			this.rank= handRank.TWO_PAIR;
			return this.getRank().toString();
		}
		if(isPair())
		{
			this.rank= handRank.PAIR;
			return this.getRank().toString();
		}
		//If we make it through all of the hand ranks,
		//then we know the hand must be played as a high card.
		this.rank = handRank.HIGH_CARD;
		return this.getRank().toString() + " " +  this.getHighCard();
	}
	
	public void parseFromInput(String[] args)
	{
		//Create a string list for holding the input arguments for manipulation
		List<String> segments = new ArrayList<String>();
		for (int i = 0; i < args.length; i++) 
		{
				segments.add(args[i]);
		}
		
		//If the input does not contain the correct amount of cards return invalid input
		if(segments.size() > 5 || segments.size() < 5)
		{
			this.rank = handRank.INVALID_INPUT;
			return;
		}
		
		//Iterate though the string list holding input to convert the data
		//so that the program can properly read it
		for (Iterator<String> iterator = segments.iterator(); iterator.hasNext();) {
			String segmentName=  (String) iterator.next();
			
			//This string will hold the value of the card
			String a = "";
			
			//This character will hold the suit of the card
			Character b=null;
			
			//Create the card for the input argument that we are on
			Card card = new Card();
			
			//Check to see that the segment length is the proper size
			//it could only be a length of 3 if the card is a 10
			//anything else would be improper input
			if(segmentName.length() < 2 || segmentName.length() >3)
			{
				this.rank = handRank.INVALID_INPUT;
    			return;
			}
			else if(segmentName.length()==2)
			{
				//Read and store the values from the input
				a = segmentName.substring(0, 1);
				b = segmentName.charAt(1);
			}
			else if(segmentName.length()==3)
			{
				//Read and store the values from the input
				a = segmentName.substring(0, 2);
				b = segmentName.charAt(2);
			}
			else
			{
				//This will never happen
				//System.out.println("This is a problem");
			}
			
			//Switch case to store the actual value of the card object to the
			//numeric representation of the input value
			switch (a) 
			{
	            case "A":  card.setCardValue(14);break;
	            case "K":  card.setCardValue(13);break;
	            case "Q":  card.setCardValue(12);break;
	            case "J":  card.setCardValue(11);break;
	            default:
	            	//If the user inputs a value that is not an interger and it reaches this point
	            	//or he/she puts in a value that is not in the set of numbers 2-10,
	            	//then an invalid_input status will be set for the hand
	            	if(!isInteger(a) || Integer.parseInt(a) < 2 || Integer.parseInt(a) > 14)
	            	{
	            		this.rank = handRank.INVALID_INPUT;
	        			return;
	            	}
	            	//otherwise the value will be parsed and set for the card
	            	card.setCardValue(Integer.parseInt(a));
	            	break;
			}
			//Switch statement to set the suit of the card from the input
			switch (b) 
			{
	            case 'c':  card.setSuit(suit.CLUBS);break;
	            case 'h':  card.setSuit(suit.HEARTS);break;
	            case 'd':  card.setSuit(suit.DIAMONDS);break;
	            case 's':  card.setSuit(suit.SPADES);break;
	            default:
	            	//if the suit is not one of the correct inputs it will return an
	            	//invalid_input rank
	            	this.rank = handRank.INVALID_INPUT;
        			return;
			}
			cards.add(card);
		}
	}

	@Override
	public boolean isPair() {
		//create an array ints to hold the count of each card number's occurrence
		int[] rankCount = new int[15];
		
		//iterate through the cards in the hand
		for (Card card : cards) {
			//Increase that particular card number's occurrence
            rankCount[card.getCardValue()]++;
        }
		
		//Now loop through the array and see if any card has an occurence of two, is
		//so, return true.
		for (int i = 1; i < rankCount.length; i++) {
			if(rankCount[i] == 2)
				return true;
		}
		return false;
	}

	@Override
	public boolean isTwoPair() {
		//create an array ints to hold the count of each card number's occurrence
		int[] rankCount = new int[15];
		//create an int for keeping a count of the number of pairs in a hand
		int pairCount = 0;
		//iterate through the cards in the hand
		for (Card card : cards) {
			//Increase that particular card number's occurrence
            rankCount[card.getCardValue()]++;
        }
		//Now loop through the array and see if any card has an occurence of two
		for (int i = 1; i < rankCount.length; i++) {
			if(rankCount[i] == 2)
				pairCount++;
		}
		//if the paircounter equals two, then we know we have to pair
		if(pairCount==2)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isThreeOfAKind() {
		//create an array ints to hold the count of each card number's occurrence
		int[] rankCount = new int[15];
		//iterate through the cards in the hand
		for (Card card : cards) {
			//Increase that particular card number's occurrence
            rankCount[card.getCardValue()]++;
        }
		//Now loop through the array and see if any card has an occurence of three, is
		//so, return true.
		for (int i = 1; i < rankCount.length; i++) {
			if(rankCount[i] == 3)
				return true;
		}
		return false;
	}

	@Override
	public boolean isStraight() {
		//Need to create a list for storing the values of the cards in the hand
		List<Integer> list = new ArrayList<Integer>();
		
		//Iterate through the cards in the hand
		for (Iterator<Card> iterator = cards.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
			//Add the value of the card to the newly created list
			list.add(card.getCardValue());
		}
		
		//Sort the list
		Collections.sort( list );
		//Functionality to test for low Ace Straight
		//We know if the hand contains and Ace and a 2, then the ace must be low card
		if(list.get(0) == 2 && list.get(list.size()-1) == 14)
		{
			//remove the high ace
			list.remove(list.size()-1);
			//add the low ace
			list.add(1);
			//Need to sort the list again
			Collections.sort( list );
		}
		//Iterate through the list and check the differences between consecutive cards
		for (int i = 0; i < list.size()-1; i++) 
		{
			//If the difference between two consecutive cards is one for the entire hand
			//then we know we have a straight. Otherwise, if any difference does not
			//equal one, we know a straight cannot exist, so return false
            if (list.get(i) !=  list.get(i + 1) -1) 
            {
                return false;
            }
        }
		
		return true;
	}

	@Override
	public boolean isFlush() {
		//We need to get the suit of the first card because all cards in 
		//a flush must be the same. Thus we know by just checking that all
		//cards match the first card's suit, we can successfully determine a flush
		suit flushSuit = cards.get(0).getSuit();
		
		//Iterate through the list of cards in the hand
		for (Iterator<Card> iterator = cards.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
			//If any one card does not have the same suit, then we know that 
			//hand is not a flush
			if(!card.getSuit().equals(flushSuit))
			{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean isFullHouse() {
		//create an array ints to hold the count of each card number's occurrence
		int[] rankCount = new int[15];
		
		//boolean for indicating whether or not the hand contains a pair
		boolean pair = false;
		//boolean for indicating whether or not the hand contains a three of a kind
		boolean three = false;
		
		//iterate through the cards in the hand
		for (Card card : cards) {
			//Increase that particular card number's occurrence
            rankCount[card.getCardValue()]++;
        }
		//Now loop through the array and see if any card has an occurence of three and two
		for (int i = 1; i < rankCount.length; i++) {
			//If an occurence of two is found, then we know we have a pair
			if(rankCount[i] == 2)
				pair = true;
			//If an occurence of three is found, then we know we have a three of a kind
			if(rankCount[i] == 3)
				three = true;
		}
		//If we have both a pair and a three of a kind, we know we have a full house
		if(pair && three)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isFourOfAKind() {
		//create an array ints to hold the count of each card number's occurrence
		int[] rankCount = new int[15];
		//iterate through the cards in the hand
		for (Card card : cards) {
			//Increase that particular card number's occurrence
            rankCount[card.getCardValue()]++;
        }
		//Now loop through the array and see if any card has an occurence of four, if
		//so, return true.
		for (int i = 1; i < rankCount.length; i++) {
			if(rankCount[i] == 4)
				return true;
		}
		return false;
	}

	@Override
	public boolean isStraightFlush() {
		//Here we know to be a straight flush, a hand must also be a straight and a flush
		//so we can just test that preexisting functionality
		return (isFlush() && isStraight());
	}

	@Override
	public boolean isRoyalFlush() {
		//Need to create a list for storing the values of the cards in the hand
		List<Integer> list = new ArrayList<Integer>();
		//Iterate through the cards in the hand
		for (Iterator<Card> iterator = cards.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
			//Add the value of the card to the newly created list
			list.add(card.getCardValue());
		}
		//Sort the list
		Collections.sort( list );
		
		//Here we know to be a royal flush you must be straight flush starting with a 10 ending
		//with an ace
		//so we can just test that preexisting functionality and look for 10 and ace
		if(isFlush() && isStraight() && list.get(0)==10 && list.get(list.size()-1) == 14)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String getHighCard()
	{
		//Need to create a list for storing the values of the cards in the hand
		List<Integer> list = new ArrayList<Integer>();
		//Iterate through the cards in the hand
		for (Iterator<Card> iterator = cards.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
			//Add the value of the card to the newly created list
			list.add(card.getCardValue());
		}
		//Sort the list
		Collections.sort( list );
		//Create a string for holding the high card
		String highCard = list.get(list.size()-1).toString();
		//Switch statement to convert back to lettered cards
		switch (highCard) 
		{
            case "14":  highCard = "A";break;
            case "13":  highCard = "K";break;
            case "12":  highCard = "Q";break;
            case "11":  highCard = "J";break;
            default: 	
            	break;
		}
		return highCard;
	}
	public boolean isInteger(String s) {
        try {
        	Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
	
}
