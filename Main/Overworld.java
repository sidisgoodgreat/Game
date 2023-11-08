package Main;


public class Overworld {
	private String area;
	private int step;
	
	public void promptUser(int lvl, String a) {

		
		System.out.println("On your quest to reach level 100...");
		System.out.println("Currently you're level " + lvl + "and you're at " + a);
		System.out.println("Do you wanna go forward? Or backward...?");
		System.out.println("^ forward | backward v");
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
	
	public void greenLand () {
		
	}
}

