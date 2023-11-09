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
	
	public void rolling() {
		Encounter enc = new Encounter();
		String enemy = "nothing";
		if (area.equals("Grasslands")) {
			enemy = enc.encounterGrass(enc.randomize());
			
		} else if (area.equals("Desert")) {
			enemy = enc.encounterDesert(enc.randomize());
			
		} else if (area.equals("Underworld")) {
			enemy = enc.encounterUnder(enc.randomize(), step);
		}
		
		
		if (!enemy.equals("nothing")) {
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
		System.out.println();
		System.out.println("You encounter " + enemy + "!" );
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

