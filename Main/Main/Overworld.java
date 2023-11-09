package Main;
import java.util.Scanner;


public class Overworld {
	private String area;
	private int step;
	private int lvl;
	private int pos;
	
	public String promptUser(int lvl, String pos) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nOn your quest to reach level 100...");
		System.out.println("Currently you're level " + lvl + " and you're at " + pos);
		System.out.println("Do you wanna go forward? Or backward...?");
		System.out.println("^ forward | backward v");
		String movement = scan.nextLine();
		return movement;
	}
	
	/**
	 * Checks what area player is in
	 * Then plays a function that randomly has you encounter area-centric enemies
	 * If you do you get cool ascii art (string manipulation ez)
	 */
	public void rolling() {
		

		if (area.equals("Grasslands")) {
			System.out.println("As you venture in the lands that you call... home...\n");
			
			
		} else if (area.equals("Desert")) {
			System.out.println("As you wander around this relentless, scorching stove of an area...\n");
			
		} else if (area.equals("Underworld")) {
			System.out.println("As you carry your unyielding determination towards the light within the depths of hell...\n");
		}
		
		Enemy enc = new Enemy(-1);
		
		if ( (int)(Math.random()*2)+1 == 1){
			enc = new Enemy(step);
		} 
		

		
		if (!enc.equals("nothing")) {
			for (int i = 0; i <= 11; i++) {
				String bar = "@@@@@@@@@@@@";
				System.out.println(bar.substring(0,i) + "*" + bar.substring(i));
			}
		
			for (int n = 11; n >= 0; n--) {
				String bar = "@@@@@@@@@@@@";
				System.out.println(bar.substring(0,n) + "*" + bar.substring(n));
			}
			
			for (int i = 0; i <= 11; i++) {
				String bar = "@@@@@@@@@@@@";
				System.out.println(bar.substring(0,i) + "*" + bar.substring(i));
			}
		}
		
		String name = enc.getName();
		
		System.out.println();
		if (!name.equals("nothing") || !name.equals("yourself")) {
			System.out.println("You encounter a " + name + "!" );
		} else {
			System.out.println("You encounter " + name + "!" );
		}
		
		//Battle.fight(enc);
	}
	
	public String navigateArea() {
		if (step < 5) {
			area = "Grasslands";
		} else if (step < 10) {
			area = "Desert";
		} else if (step < 15) {
			area = "Underworld";
		}
		
		return area;
	}
	
	public int getStep() {
		return step;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	
	public void addStep() {
		step++;
	}
	
	public void subStep() {
		step--;
	}
	
	public void area1() {
		
	}
	
		
	
}

