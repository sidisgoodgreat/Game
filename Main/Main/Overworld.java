package Main;
import java.util.Scanner;
public class Overworld {
	private String area;
	private int step;
	
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
		boolean gameWon = false;
		while(!gameWon){
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
			boolean wonFight;
			if (getStep() > 0) {
				//Roll for a combat encounter
				if(m.percentRoller(60)) {
					Enemy e = new Enemy(step);
					CombatEncounter ce = new CombatEncounter(e,player1);
					wonFight=ce.mainCombat();
				}
				navigateArea();
			} else {
				System.out.println("\nYou cannot go back any further!");
			}

			// if lost/won... get back here to this class!
			// if you lose you restart hahahaha
			lostFight(!wonFight);
			
			// to do: add an ending!!! and maybe an introduction cus we cool like that B )
	
		}
			Enemy boss = new Enemy(player1);
			CombatEncounter bossFight = new CombatEncounter(boss,player1);
			gameWon=bossFight.mainCombat();
			lostFight(!gameWon);
		}
		// Ending Text
		//very cliche - Ethan
			System.out.println("\nSo the big final boss was yourself...");
			System.out.println("Wow! What a twist!");
			System.out.println("\nSo the big boss was yourself...");
			System.out.println("Sounds reasonable!");
			System.out.println("You glance back to the world you once journeyed so hard across...");
			System.out.println("It is in ruins.");
			System.out.println("Because of you.");
			System.out.println("Maybe losing yourself in the underworld was a bad idea after all!\n");
			System.out.println("-- END --");
	}

	public void lostFight(boolean lost){
		if(lost){
			setStep(0);
			System.out.println("You hurriedly retreat back to your house after a tragic defeat!");
			System.out.println("Time to come back stronger...");
		}
	}
	
	public String navigateArea() {
		if (step < 5) {
			setArea("Grasslands");
		} else if (step < 10) {
			setArea("Desert");
		} else if (step < 15) {
			setArea("Underworld");
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
}
