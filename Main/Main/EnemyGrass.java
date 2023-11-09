package csaProject;

public class EnemyGrass {
	/*
	 * Types of Enemies
	 * Slime
	 * Wolf
	 * Bandit
	 */
	private String name;
	private int type,hp,maxHP;
	private double magRes,physRes;
	private boolean sendSteal;
	private Misc m = new Misc();
	
	public EnemyGrass() {
		type=(int)(Math.random()*3)+1;
		if(type==1) {//Slime
			name="Slime";
			hp=5;
			maxHP=5;
			magRes=1;
			physRes=1;
		}else if(type==2) {//Wolf
			name="Wolf";
			hp=3;
			maxHP=3;
			magRes=1;
			physRes=1;
		} else {//Bandit
			name="Bandit";
			hp=7;
			maxHP=7;
			magRes=1;
			physRes=1;
		}
	}
	public EnemyGrass(int type) {
		if(type==1) {//Slime
			name="Slime";
			hp=5;
			magRes=1;
			physRes=1;
		}else if(type==2) {//Wolf
			name="Wolf";
			hp=3;
			magRes=1;
			physRes=1;
		} else {//Bandit
			name="Bandit";
			hp=7;
			magRes=1;
			physRes=1;
		}
	}
	public String getName() {
		return name;
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
		} else {
			dmg=banditMoves();
		}
		return dmg;
	}
	//Slime Attacks: Strike and Heal?
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
		return 3;
	}
	public void slimeHeal() {
		if(hp<maxHP) {
			hp++;
		}
	}
	//Wolf Attacks: Bite and Jugular
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
		return 5;
	}
	public int wolfJug() {
		if(m.percentRoller(50)) {
			return 7;
		} else {
			return 0;
		}
	}
	//Bandit Attacks: Stab, Steal
	public int banditMoves() {
		int dmg=0;
		if(m.percentRoller(60)) {
			dmg=banditStab();
		} else {
			sendSteal = banditSteal();
		}
		return dmg;
	}
	public int banditStab() {
		return 5;
	}
	public boolean banditSteal() {
		return m.percentRoller(30);
	}
	//stuff?
}