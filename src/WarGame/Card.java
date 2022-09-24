package WarGame;

public class Card {

	int value;                 //contains a value from 2-14 representing cards 2-Ace
	String name;               //name of card, for example Ace of Diamonds, two of Hearts
	
	public Card(int suit, int rank) {
		value = rank; 
		StringBuilder name = new StringBuilder(); 
		
		//assigns card suit/value 
		if(value == 14) {                          
			name.append("Ace"); 
		} else if (value == 13) {
			name.append("King"); 
		} else if (value == 12) {
			name.append("Queen"); 
		} else if (value == 11) {
			name.append("Jack"); 
		} else {
			name.append(value); 
		}
		
		if(suit == 0) {
			name.append(" of Hearts"); 
		} else if(suit == 1) {
			name.append(" of Spades"); 
		} else if(suit == 2) {
			name.append(" of Diamonds"); 
		} else if(suit == 3) {
			name.append(" of Clubs"); 
		}
		this.name = name.toString();
	}
	
	//the describe method will print the card 
	public String describe() {
		return name; 
	}
}
