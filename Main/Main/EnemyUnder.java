package Main;
public class EnemyUnderworld {
	/*
	 * Types of Enemies
	 * Demon
	 * Yourself
	 */
	private String name, dmgType;
	private int type, hp, maxHP,xp;
	private double magRes, physRes;
	private Misc m = new Misc();
	
	public EnemyUnderworld () {//demons
		initDemon();
	}
	public void initDemon () {
		name "demon";
		hp = 4;
		mapHP = 4;
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
	public double getType() {
		return type;
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
		if (m.percentRoller (60) || hp == maxHP)) {
			dmg = demonStrike ();
		} else {
			demonCurse();
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
	
