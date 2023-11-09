package Main;

import java.util.Scanner;
public class Misc{
	//Returns true if the roll is below the chance
	public boolean percentRoller(int chance) {
		int roll = (int) (Math.random()*100)+1;
		return roll<=chance;
	}
	public int crit(int chance, int multiplier){
    		if(percentRoller(chance)){
      			return multiplier;
    		} else {
			return 1;
		}
	}
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
