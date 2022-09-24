package WarGame;

import java.util.ArrayList;
import java.util.List;

public class Player {

	String name;                                          //player name
	int score;                                            //player score
	
	List<Card> hand = new ArrayList<Card>();              //player hand(their stack of cards)
			
	public Player(String name) {                          //constructs the players
		this.name = name; 
		score = 0; 
	}	
		
	//method that removes and returns the top card of the hand
	public Card flip() {
		return hand.remove(0); 		
	}
	
	//method that calls the draw method on the deck, adds the returned card to the hand field
	public void draw(Deck deck) {
		hand.add(deck.draw());			
	}
	
	/*
	 * method that adds up player's score
	 * for every round won it increases score by 1
	 */
	public void incrementScore() {
		score++; 
	}

	//toString is needed to display player names as a String
	@Override
	public String toString() {                
		return name;
	}	
}
