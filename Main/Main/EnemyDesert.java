package Main;

public class EnemyDesert {
	/*
	 * Types of Enemies
	 * golem
	 * sandworm
	 */
	private String name, dmgType;
	private int type,hp,maxHP, xp;
	private double magRes,physRes;
	private Misc m = new Misc();
	
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
	public String getName() {
		return name;
	}
	public String getDmgType(){
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
	public int getXP() {
		return xp;
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
	
	//Their Attacks
	public int wholeMoves(int type) {
		int dmg = 0;
		if(type==1) {
			dmg=golemMoves();
		} else if(type==2) {
			dmg=sandwormMoves();
		}
		return dmg;
	}
	//Golem Attacks
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
		return 5;
	}
	public void golemDefense() {
    		physRes-=0.05;
	}
	//SandWorm Attacks
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
	public int sandwormSandStorm() {
    		int totalDamage = 0;
		for (int i = 0; i < 3; i++) {
        		totalDamage += 2;
    		}
    		return totalDamage;
    	}
	public int sandwormBite() {
		if(m.percentRoller(50)) {
			return 7;
		} else {
			return 0;
		}
	}
}