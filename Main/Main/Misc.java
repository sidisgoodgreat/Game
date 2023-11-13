package Main;

import java.util.Scanner;
public class Misc {
	/**
	 * 
	 * @param chance - Chance for percentRoller to return true, from 1-100
	 * @return - true if roll is successful, false if not
	 */
	public boolean percentRoller(int chance) {
		int roll = (int) (Math.random()*100)+1;
		return roll<=chance;
	}
	/**
	 * 
	 * @param chance - The chance for crit to land, otherwise return as multipler
	 * @param multiplier - multiplier for damage if crit succeeds.
	 * @return - 1 or multiplier
	 */
	public int crit(int chance, int multiplier){
    		if(percentRoller(chance)){
      			return multiplier;
    		} else {
			return 1;
		}
	}
	/**
	 * @param minRange A char with a decimal value from 48-56
	 * @param maxRange A char with a decimal value from 49-57
	 * @return An integer that is -48 of the decimal value of the char choice
	 */
	public int intChoose(char minRange, char maxRange) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter an single-digit integer");
		System.out.println("("+minRange+","+maxRange+")");
		char choice = (s.next()).charAt(0);
		while(choice<minRange||choice>maxRange) {
			System.out.println("Invalid choice, please input another integer");
			choice = (s.next()).charAt(0);
		}
		return ((int)choice)-48;
	}
}
