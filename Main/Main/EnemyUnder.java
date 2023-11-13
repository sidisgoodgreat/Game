package Main;
public class EnemyUnder {
	/*
	 * Types of Enemies
	 * Demon
	 * Yourself
	 */
	private String name, dmgType;
	private int type, hp, maxHP,xp;
	private double magRes, physRes;
	private Misc m = new Misc();
	
	public EnemyUnder () {//demons
		initDemon();
	}
	public void initDemon () {
		name= "demon";
		hp = 4;
		maxHP = 4;
		magRes = .4;
		physRes = .7;
		xp=200;
		dmgType = demonType;
	}
	
	public String getName() {
		return name;
	}
	public int getHP () {
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
	public void setName (String initName) {
		name =  initName;
	}
	public void setHP (int initHP) {
		hp = initHP;
	}
	public void setMagRes (int initMagRes) {
		magRes = initMagRes;
	}
	public void setPhysRes (int initPhysRes) {
		physRes = initPhysRes;
	}
	public int wholeMoves(int type) {
		int dmg = 0;
		dmg=demonMoves();
		return dmg;
	}
	// attacks
	String demonType = "magi";
	public int demonMoves () {
		int dmg=0;
		if (m.percentRoller (60) || hp == maxHP) {
			dmg = demonStrike ();
		} else {
			dmg=demonCurse();
		}
		return dmg;
		}
	public int demonStrike () {
		System.out.println("Demon strikes at you!");
		return 6;
	}
	public int demonCurse () {
		if (m.percentRoller (10)) {
			System.out.println("The demon cursed you!"); //meant to be a one shot kill
			return 50;
		} else {
			System.out.println("The demon tried to curse you but missed!");
			return 0;
		}
	}
}
	
