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
			
			
			while (main.getStep() < 100) {
				
				main.promptUser(player1.getLevel(), main.navigateArea( main.getStep() ) );
				
				if (sc.next() == "^") {
					main.addStep();
				} else if (sc.next() == "v") {
					main.subStep();
				}
	
				// add rando chance of fight and all that stuff here
				// if lost/won... get back here to this class!
				
				// if you lose you restart hahahaha
				if (player1.getHP() <= 0) {
					main.setStep(0);
					System.out.println("You hurriedly retreat back to your house after a tragic defeat!");
					System.out.println("Time to come back stronger...");
				}
				
				// to do: add an ending!!! and maybe an introduction cus we cool like that B )
		
			}
		}
}
