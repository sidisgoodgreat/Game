package Main;
import java.util.Scanner;
public class Overworld {
	private String area;
	private int step;
	private int lvl;
	private int pos;
	public String promptUser(int lvl, String pos) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("On your quest to reach level 100...");
		System.out.println("Currently you're level " + lvl + "and you're at " + pos);
		System.out.println("Do you wanna go forward? Or backward...?");
		System.out.println("^ forward | backward v");
		String movement = scan.nextLine();
		return movement;
	}
	
	public String navigateArea(int step) {
		if (step < 5) {
			area = "grasslands";
		} else if (step > 10) {
			area = "dark forest";
		} else if (step > 15) {
			area = "caves";
		} else if (step > 20) {
			area = "underworld";
		} else if (step > 25) {
			area = "$%@#$%#??";
		}
		
		return area;
	}
	
	public int getStep() {
		return step;
	}
	
	public int getArea() {
		return area;
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
	public void setArea(int area) {
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
	
	public void grassLand (int pos, int lvl) {
		this.pos = pos;
		this.lvl = lvl;
		System.out.println("Congratulations, you reached the grasslands");
		while(pos < 10) {
			promptUser(lvl, pos);
			if(movement == "forward") {
				pos = pos + 1;
				if(pos % 2 == 0) {
					Encounter("grassland");	
				}
			}
			if(movement == "backward") {
				pos = pos - 1;
			}
			
		}
		
	}
}

