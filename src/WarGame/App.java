package WarGame;

import java.util.Scanner;

/* How the game is played: 
 * The 52 card deck will divided evenly, dealt face down, between the two players.
 * Each player will place their top card face up at the same time.
 * The player with the higher card wins the round.
 * Points are given based on the value of the cards. 
 */

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {      
		
		/*
		 * Prints the introduction to the game
		 * Name of game and name of players
		 */
		System.out.println("********** Welcome to the card game of WAR! **********\n");
		
		//using Scanner to prompt the user to type in the player names
		Scanner playerNames = new Scanner(System.in); 		
		System.out.print("Please enter the name of Player 1: ");
		Player player1 = new Player(playerNames.next().toUpperCase()); 
		System.out.print("Please enter the name of Player 2: ");
		Player player2 = new Player(playerNames.next().toUpperCase()); 
		
		System.out.println("\n" + player1 + " and " + player2 + " let's play the game!");
		System.out.println("\nReady... set... GO!!!\n");
		
		/*
		 * builds the card deck and shuffles it
		 */
		Deck deck = new Deck();                   
		deck.shuffle();                           
	
		/*
		 * for loop will iterate through the 52 cards in the deck
		 * splits them between both players
		 */
		for(int i = 1; i <= 52; i++) {            
			if (i % 2 == 0) {
				player1.draw(deck); 
			} else {
				player2.draw(deck);
			}
		}
		
		/*
		 * for loop to play the game
		 * iterates through player's hand
		 * flips each card & describes it
		 * uses card value to determine winner each round
		 * since each player has 26 cards there are 26 rounds 
		 * round count starts at 1
		 */	
		for(int i = 1; i < 27; i++) {             
			Card player1Card = player1.flip(); 
			Card player2Card = player2.flip(); 
			
			//provides round number and which card the player drew from their deck
			System.out.println("Round #: " + i);
			System.out.println(player1.name + "'s card is " + player1Card.describe());
			System.out.println(player2.name + "'s card is " + player2Card.describe());
			
			/*
			 * compares value of cards returned for each player
			 * incrementScore method adds a point to player with card of highest value
			 * prints results from the draw
			 */
			if(player1Card.value > player2Card.value) {
				player1.incrementScore();
				System.out.println(player1.name + " WINS THIS ROUND!\n");
			} else if(player1Card.value < player2Card.value) {
				player2.incrementScore();
				System.out.println(player2.name + " WINS THIS ROUND!\n");
			} else {
				System.out.println("IT'S A DRAW!\n");
			}		
		}	
		
		//prints final score totals
		System.out.println("**** FINAL SCORES: *****");		
		if(player1.score == player2.score) {
			System.out.println(player1.name + "'s total score: " + player1.score);
			System.out.println(player2.name + "'s total score: " + player2.score + "\n");
			System.out.println("IT'S A TIE!");
		}else if (player1.score < player2.score) {
			System.out.println(player1.name + "'s total score: " + player1.score);
			System.out.println(player2.name + "'s total score: " + player2.score + "\n");
			System.out.println(player2.name + " WINS THE GAME!!!");		
		} else {
			System.out.println(player1.name + "'s total score: " + player1.score);
			System.out.println(player2.name + "'s total score: " + player2.score + "\n");
			System.out.println(player1.name + " WINS THE GAME!!!");			
		}
	}
}
