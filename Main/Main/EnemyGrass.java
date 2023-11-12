package Main;

public class EnemyGrass {
	/*
	 * Types of Enemies
	 * Slime
	 * Wolf
	 * Bandit
	 */
	private String name,dmgType;
	private int type,hp,maxHP;
	private double magRes,physRes;
	private Misc m = new Misc();

	
	public EnemyGrass() {
		type=(int)(Math.random()*2)+1;
		
		if(type==1) {//Slime
			initSlime();
		}else if(type==2) {//Wolf
			initWolf();
		}
	}
	public void initSlime() {
		name="Slime";
		hp=5;
		maxHP=5;
		magRes=1;
		physRes=1;
		dmgType=slimeType;
	}
	public void initWolf() {
		name="Wolf";
		hp=3;
		maxHP=3;
		magRes=1;
		physRes=1;
		dmgType=wolfType;
	}
	public String getName() {
		return name;
	}
	public String getDmgType() {
		return dmgType;
	}
	public int getHP() {
		return hp;
	}
	public double getMagRes() {
		return magRes;
	}
	public double getPhysRes() {
		return physRes;
	}
	public int getType() {
		return type;
	}
	public void setName(String init) {
		name=init;
	}
	public void setHP(int init) {
		hp=init;
	}
	public void setMagRes(double init) {
		magRes=init;
	}
	public void setPhysRes(double init) {
		physRes=init;
	}
	
	//Attacks?
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
	public int slimeStrike() {
		System.out.println("The Slime strikes!");
		return 3;
	}
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
	public int wolfBite() {
		System.out.println("The Wolf bites!");
		return 5;
	}
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

