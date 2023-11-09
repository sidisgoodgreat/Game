package Main;

import java.util.Scanner;
import java.util.Random;

public class Driver {
	public static void main(String args[]) {
			
			Scanner sc = new Scanner(System.in);
			Overworld main = new Overworld();
			
			System.out.print("Enter your name!: ");
			
			String name = sc.nextLine();
			Player player1 = new Player(name);
			
			
			while (main.getStep() <= 15) {
				
				String input = main.promptUser(player1.getLevel(), main.navigateArea() );
				
				if (input.equals( "^")) {
					main.addStep();
				} else if (input.equals("v")&&main.getStep() > 0) {
					main.subStep();
				} else {
					//Did not input eihter of them, then need to redo the choose cycle?
				}
	
				// add rando chance of fight and all that stuff here
				if (main.getStep() > 0) {
					main.rolling();
					main.navigateArea();
				} else {
					System.out.println("\nYou cannot go back any further!");
				}

				// if lost/won... get back here to this class!
				// if you lose you restart hahahaha
				if (player1.getHP() <= 0) {
					main.setStep(0);
					System.out.println("You hurriedly retreat back to your house after a tragic defeat!");
					System.out.println("Time to come back stronger...");
				}
				
		
			}
			
			// Peak ending ik ik i love cliches
			System.out.println("\nSo the big final boss was yourself...");
			System.out.println("Wow! What a twist!");
			System.out.println("You glance back to the world you once journeyed so hard across...");
			System.out.println("It is in ruins.");
			System.out.println("Because of you.");
			System.out.println("Maybe losing yourself in the underworld was a bad idea after all!\n");
			System.out.println("-- END --");
		}
}
