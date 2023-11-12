package csaProject;
import java.util.Scanner;
public class Overworld {
	private String area;
	private int step;
	private int lvl;
	private int pos;
	
	private Misc m = new Misc();
	private Scanner sc = new Scanner(System.in);
	private Player player1;
	
	public String promptUser(int lvl, String pos) {
		System.out.println("\nOn your quest to reach level 100...");
		System.out.println("Currently you're level " + lvl + " and you're in the " + pos);
		System.out.println("Do you wanna go forward? Or backward...?");
		System.out.println("^ forward | backward v");
		String movement = sc.nextLine();
		return movement;
	}
	public void begin() {
		System.out.println("Welcome to the game!");
		System.out.print("Enter your name: ");
		String name = sc.nextLine();
		player1=new Player(name);
	}
	
	public void game() {
		begin();
		while (getStep() <= 15) {
			
			String input = promptUser(player1.getLevel(), navigateArea() );
			while(!(input.equals("^")||input.equals("v"))){
				System.out.println("Invalid, please try again");
				input = sc.next();
			}
			if (input.equals( "^")) {
				addStep();
			} else if (input.equals("v")&&getStep() > 0) {
				subStep();
			}

			// add rando chance of fight and all that stuff here
			if (getStep() > 0) {
				//Roll for a combat encounter
				if(m.percentRoller(60)) {
					Enemy e = new Enemy(step);
					CombatEncounter ce = new CombatEncounter(e,player1);
					if(ce.mainCombat()) {
						player1.addXP(20);
					}
					player1.levelUp();
				}
				navigateArea();
			} else {
				System.out.println("\nYou cannot go back any further!");
			}

			// if lost/won... get back here to this class!
			// if you lose you restart hahahaha
			if (player1.getHP() <= 0) {
				setStep(0);
				System.out.println("You hurriedly retreat back to your house after a tragic defeat!");
				System.out.println("Time to come back stronger...");
			}
			
			// to do: add an ending!!! and maybe an introduction cus we cool like that B )
	
		}
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
