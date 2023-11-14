package Main;
import java.util.Scanner;
public class Overworld {
	private String area;
	private int step;
	
	private Misc m = new Misc();
	private Scanner sc = new Scanner(System.in);
	private Player player1;

	/**
 	* Prompts the user on what direction they want to move
 	*@param lvl - For display purposes, level of the player
  	*@param pos - String of the player's area: Grasslands, Desert, or Underworld
   	*@return - String user inputed, either "^" or "v"
	*/
	public String promptUser(int lvl, String pos) {
		System.out.println("\nOn your quest to reach level 100...");
		System.out.println("Currently you're level " + lvl + " and you're in the " + pos);
		System.out.println("Do you wanna go forward? Or backward...?");
		System.out.println("^ forward | backward v");
		String movement = sc.next();
		while(!(movement.equals("^")||movement.equals("v"))){
				System.out.println("Invalid, please try again");
				movement = sc.next();
			}
		return movement;
	}
	/**
	* Asks the player for a name, and initilizes the Player object with this name as an argument
	*/
	public void begin() {
		System.out.println("Welcome to the game!");
		System.out.print("Enter your name: ");
		String name = sc.nextLine();
		player1=new Player(name);
	}
	/**
	*Main game cycle, Prompts user for movement using promptUser method, then rolls for a fight using 
	*CombatEncounter, Player, and Enemy objects
	*At the end, runs another CombatEncounter with a bossEnemy
	*/
	public void game() {
		begin();
		boolean gameWon = false;
		
		while(!gameWon){
			while (getStep() <= 15) {
				
				String input = promptUser(player1.getLevel(), navigateArea() );
				
				if (input.equals( "^")) { addStep();
				} else if (input.equals("v")&&getStep() > 0) { subStep();	}
	
				// add rando chance of fight and all that stuff here
				boolean wonFight = false;
				if (getStep() > 0) {
					//Roll for a combat encounter
					if(m.percentRoller(60)) {
						Enemy e = new Enemy(step);
						CombatEncounter ce = new CombatEncounter(e,player1);
						wonFight=ce.mainCombat();
						if (!wonFight) {
							lostFight();
						}
					} else { System.out.println("You encountered nothing!"); }
					navigateArea();
				} else {
					System.out.println("\nYou cannot go back any further!");
			}

			// if lost/won... get back here to this class!
			// if you lose you restart hahahaha
			//lostFight(!wonFight);
			
			// to do: add an ending!!! and maybe an introduction cus we cool like that B )
	
		}
			Enemy boss = new Enemy(player1);
			CombatEncounter bossFight = new CombatEncounter(boss,player1);
			gameWon=bossFight.mainCombat();
			//lostFight(!gameWon);
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


	/**
	* In event of losing a fight, the step variable is set to 0, otherwise returning player to the start of the game
	* and prints some flavor text
	*/
	public void lostFight(){
			setStep(0);
			System.out.println("You hurriedly retreat back to your house after a tragic defeat!");
			System.out.println("Time to come back stronger...\n");
		}
	
	/**
	* Uses global variable step and returns a String value based on what area the player should be in based on step
	* @return - area that the player is in based on variable step, Grasslands, Desert, or Underworld.
	*/
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
	/**
	*@return int variable step
	*/
	public int getStep() {
		return step;
	}
	/**
	*@return String variable area
	*/
	public String getArea() {
		return area;
	}
	/**
	* sets value of step to new value
 	* @param step - new value that global variable this.step will be initialized to
	*/
	public void setStep(int step) {
		this.step = step;
	}
	/**
	*sets value of area to new value
 	* @param area - new value global variable area is initialized to.
	*/
	public void setArea(String area) {
		this.area = area;
	}
	/**
	* Adds 1 to the variable step
	*/
	public void addStep() {
		step++;
	}
	/**
	* removes 1 from the variable step
	*/
	public void subStep() {
		step--;
	}	
}
