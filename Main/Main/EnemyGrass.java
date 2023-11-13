package Main;

public class EnemyGrass {
	/*
	 * instance variables
	 * Types of Enemies
	 * Slime
	 * Wolf
	 */
	private String name,dmgType;
	private int type,hp,maxHP, xp;
	private double magRes,physRes;
	private Misc m = new Misc();

	// Constructor that has 2 possible types
	// Selects specific type according to chance
	public EnemyGrass() {
		type=(int)(Math.random()*2)+1;
		
		if(type==1) {//Slime
			initSlime();
		}else if(type==2) {//Wolf
			initWolf();
		}
	}
	// Sets values according to slime type
	public void initSlime() {
		name="Slime";
		hp=6;
		maxHP=5;
		magRes=.8;
		physRes=1.2;
		dmgType=slimeType;
		xp = 100;
	}
	// Sets values according to wolf type
	public void initWolf() {
		name="Wolf";
		hp=4;
		maxHP=3;
		magRes=1.2;
		physRes=1;
		dmgType=wolfType;
		xp = 120;
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
	 * Organizes what moves will be used according to the enemy
	 * @param int type
	 */
	public int wholeMoves(int type) {
		int dmg = 0;
		if(type==1) {
			dmg=slimeMoves();
		} else if(type==2) {
			dmg=wolfMoves();
		}
		return dmg;
	}
	//Slime Attacks: Strike and Heal?
	String slimeType="magi";
	public int slimeMoves() {
		int dmg=0;
		if(m.percentRoller(70)||hp==maxHP) {
			dmg=slimeStrike();
		} else {
			slimeHeal();
		}
		return dmg;
	}
	//
	public int slimeStrike() {
		System.out.println("The Slime strikes!");
		return 3;
	}
	
	// if slime is less than full it can increase its hp variable
	public void slimeHeal() {
		if(hp<maxHP) {
			System.out.println("The Slime heals!");
			hp++;
		}
	}
	//Wolf Attacks: Bite and Jugular
	
	String wolfType="phys";
	public int wolfMoves() {
		int dmg = 0;
		if(m.percentRoller(60)) {
			dmg=wolfBite();
		} else {
			dmg = wolfJug();
		}
		return dmg;
	}
	/**
	 * Outputs flavor text and gives back dmg value
	 * @return int 5
	 */
	public int wolfBite() {
		System.out.println("The Wolf bites!");
		return 5;
	}
	/**
	 * Outputs flavor text and gives back 2 possible dmg values according to chance
	 * @return int 7 or int 0
	 */
	public int wolfJug() {
		if(m.percentRoller(50)) {
			System.out.println("The Wolf Bites into ur neck!");
			return 7;
		} else {
			System.out.println("The wolf tries to bite, but misses!");
			return 0;
		}
	}
	//stuff?
}
