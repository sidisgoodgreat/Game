package Main;

public class EnemyDesert {
	// Instance variables
	
	private String name, dmgType;
	private int type,hp,maxHP, xp;
	private double magRes,physRes;
	private Misc m = new Misc();
	
	// Constructor that picks 1 out of 2 possible types of enemies
	// Selects specific type according to chance
	public EnemyDesert() {
		type=(int)(Math.random()*2)+1;
		if(type==1) {//golem
			name="golem";
			hp=30;
			maxHP=30;
			magRes=1.5;
			physRes=.75;
			xp = 160;
			dmgType=golemType;
		}else if (type ==2){//sandworm
			name="sandworm";
			hp=60;
			maxHP=60;
			magRes=.25;
			physRes=1;
			dmgType=sandwormType;
			xp = 300;
		} 
	}
	//Accessor methods

	/**
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return String dmgType
	 */
	public String getDmgType() {
		return dmgType;
	}
	/**
	 * @return int hp
	 */
	public int getHP() {
		return hp;
	}
	/**
	 * @return double magRes
	 */
	public double getMagRes() {
		return magRes;
	}
	/**
	 * @return double physRes
	 */
	public double getPhysRes() {
		return physRes;
	}
	/**
	 * @return int type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @return int xp
	 */
	public int getXP() {
		return xp;
	}
	// setter methods
	
	/**
	 * @param String init
	 */
	public void setName(String init) {
		name=init;
	}
	/**
	 * @param int init
	 */
	public void setHP(int init) {
		hp=init;
	}
	/**
	 * @param double init
	 */
	public void setMagRes(double init) {
		magRes=init;
	}
	/**
	 * @param double init
	 */
	public void setPhysRes(double init) {
		physRes=init;
	}
	
	
	/**
	 * Attacks that cahnge according to the enemy type
	 * @param int type
	 * @return int dmg - dmg according to enemy's moveset
	 */
	public int wholeMoves(int type) {
		int dmg = 0;
		if(type==1) {
			dmg=golemMoves();
		} else if(type==2) {
			dmg=sandwormMoves();
		}
		return dmg;
	}
	// Plays a specific attack/heal method depending on chance (golemSmash, golemDefense)
	String golemType="phys";
	public int golemMoves() {
		int dmg=0;
		if(m.percentRoller(60)||hp==maxHP) {
			dmg=golemSmash();
		} else {
			golemDefense();
		}
		return dmg;
	}
	
	public int golemSmash() {
		System.out.println("The golem crushes you with all its might!");
		return 5;
	}
	
	// Increase physical resistance for golem
	public void golemDefense() {
			System.out.println("The golem bulks up!");
    		physRes-=0.05;
	}
	// Plays a specific attack/heal method depending on chance (sandwormSandStorm, sandwormBite)
	String sandwormType="phys";
	public int sandwormMoves() {
		int dmg = 0;
		if(m.percentRoller(40)) {
			dmg=sandwormSandStorm();
		} else {
			dmg = sandwormBite();
		}
		return dmg;
	}
	
	/**
	 * Outputs flavor text and gives back a dmg value summed from a for loop
	 * @return int 7 or int 0
	 */
	public int sandwormSandStorm() {
    		int totalDamage = 0;
    	System.out.println("The sandworm brings in a terrifying sandstorm!");
		for (int i = 0; i < 3; i++) {
        		totalDamage += 2;
    		}
    		return totalDamage;
    	}
	
	/**
	 * Outputs flavor text and gives back 2 possible dmg values according to chance
	 * @return int 7 or int 0
	 */
	public int sandwormBite() {
		
		if(m.percentRoller(50)) {
			System.out.println("The sandworm lunges and bites you!");
			return 7;
		} else {
			System.out.println("The sandworm lunges but misses!");
			return 0;
		}
	}
}