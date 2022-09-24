package WarGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	List<Card> cards = new ArrayList<Card>();           //list of cards
	
	/*
	 * Deck Constructor
	 * populates the 52 cards in the deck
	 * there are 4 suits: hearts,spades,diamonds,hearts
	 */
	public Deck() {                                     
		for(int suit = 0; suit < 4; suit++) {           
			for(int rank = 2; rank < 15; rank ++) {     
				cards.add(new Card(suit, rank));        
			}
		}
	}

	//method that randomizes/shuffles the order of all the cards
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	//method that removes/returns the top card-index 0
	public Card draw() {
		return cards.remove(0); 
	}
}

