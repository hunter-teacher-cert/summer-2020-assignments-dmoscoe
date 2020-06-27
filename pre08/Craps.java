/**This does not exactly conform to the requirements yet, because everything that roll
needed to do is contained in shoot. And everything that round needed to do is contained in main.
I also have another method called decider, which takes a list of rolls and determines whether they 
represent a win, loss, or neither yet. I could also clean up the language and use either only roll or only shot
to describe one random outcome from the dice. 
Figuring out the loop-in-a-loop was tricky, but here's what I came up
with:

FOR EVERY GAME:
 Choose number of rounds;
 Choose number of dice;
 Choose faces per die;
 Play rounds;
 End the game.

OUTER LOOP: ROUND
For every round:
 roundsLeft decreases by 1;
 wins or losses increases by 1;
 wins, losses, rounds are printed.
 
 INNER LOOP: SHOOT-SEQUENCE
 For every shoot-sequence:
  shoot dice;
  print shot;
  append shot to shots;
  is the sequence over?;
  print shoot again, or print nothing, clear shots, and end the shoot-sequence;
  
*/

import java.util.*;
public class Craps {
	public static int shoot(int dice, int faces) {
		int[] rolls = new int[dice];
		int total = 0;
		for (int i = 0; i < rolls.length; i++) {
			rolls[i] = (int) (Math.random() * faces) + 1;
		}
		for (int i = 0; i < rolls.length; i++) {
			total += rolls[i];
		}
		return total;
	}
	
	public static int decider(ArrayList<Integer> rolls) {
		if (rolls.get(0) == 2 || rolls.get(0) == 3 || rolls.get(0) == 12) {
			return -1;
		} else if (rolls.get(0) == 7 || rolls.get(0) == 11) {
			return 1;
		} else if (rolls.size() > 1 && rolls.get(0) == rolls.get(rolls.size() - 1)) {
			return 1;
		} else if (rolls.size() > 1 && rolls.get(rolls.size() - 1) == 7) {
			return -1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		
		int rounds;
		int roundsLeft;
		int dice;
		int faces;
		int decider_state = 0;
		int wins = 0;
		int losses = 0;
		ArrayList<Integer> rolls = new ArrayList<Integer>();

		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Craps! Please enter the number of rounds you'd like to play. ");
		rounds = in.nextInt();
		roundsLeft = rounds;
		System.out.println("Enter the number of dice to shoot. ");
		dice = in.nextInt();
		System.out.println("Enter the number of faces on each die. ");
		faces = in.nextInt();

		while (roundsLeft > 0) {
			
			while (decider_state == 0) {
				rolls.add(shoot(dice,faces));
				System.out.println("You shot a " + rolls.get(rolls.size() - 1) + ".");
				System.out.println("So far this round you've shot " + rolls);
				decider_state = decider(rolls);
			}
						
			roundsLeft--;
			rolls.clear();
			if (decider_state == 1) {
				System.out.println("You won this round!");
				wins++;
			} else {
				System.out.println("Better luck next time.");
				losses++;
			}
			decider_state = 0;
			System.out.println("There are " + roundsLeft + " rounds left. Wins = " + wins + ". Losses = " + losses + ".");
		}
	}
}