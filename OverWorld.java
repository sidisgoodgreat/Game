package Overworld;

import java.util.Scanner;
public class Overworld {
	private int area;
	private String input;
	int level; // should be in another class, 
	int health; // health should be in abother class
	
	public void promptUser() {
		if (health <= 0) {
			System.out.println("Lol you died");
			
		}
		System.out.println("On your quest to reach level 100...");
		System.out.println("Currently you're level " + level);
		System.out.println("Where go?");
		System.out.println("1 - greenlands");
		System.out.println("2 - desert");
		System.out.println("3 - rainforest");
		System.out.println("4 - underworld");
	}
	
	public void area1() {
		
	}
	
	public static void main(String args[]) {
		Overworld main = new Overworld();
		
		while (level < 100) {
			Scanner sc = new Scanner(System.in);
			
			promptUser();
			overwrld.area = sc.nextInt();
			
			if(overwrld.area == 1) {
				main.area1();
			} else if (ovrwrld.area == 2) {
				area2();
			}
		}
	}
	public void greenLand () {
		
	}
}

