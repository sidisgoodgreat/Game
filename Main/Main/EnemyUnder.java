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
	// Sets values for demon enemy
	public void initDemon () {

		name= "demon";
		hp = 20;
		maxHP = 20;
		magRes = .4;
		physRes = .7;
		xp=200;
		dmgType = demonType;
	}
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return hp
	 */
	public int getHP () {
		return hp;
	}
	/**
	 * @return magRes
	 */
	public double getMagRes() {
		return magRes;
	}
	/**
	 * @return physRes
	 */
	public double getPhysRes() {
		return physRes;
	}
	/**
	 * @return type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @return dmgType
	 */
	public String getDmgType() {
		return dmgType;
	}
	/**
	 * @return xp
	 */
	public int getXP() {
		return xp;
	}
	// Mutator methods
	
	/**
	 * @param String initName
	 */
	public void setName (String initName) {
		name =  initName;
	}
	/**
	 * @param int initHP
	 */
	public void setHP (int initHP) {
		hp = initHP;
	}
	/**
	 * @param int initMagRes
	 */
	public void setMagRes (int initMagRes) {
		magRes = initMagRes;
	}
	/**
	 * @param int initPhysRes
	 */
	public void setPhysRes (int initPhysRes) {
		physRes = initPhysRes;
	}
	/**
	 * @param String initName
	 */
	public int wholeMoves(int type) {
		int dmg = 0;
		dmg=demonMoves();
		return dmg;
	}
	
	// attacks
	String demonType = "magi";
	// changes dmg int according to the move used
	public int demonMoves () {
		int dmg = 0;
		if (m.percentRoller (60) || hp == maxHP) {
			dmg = demonStrike ();
		} else {
			demonCurse();
		}
		return dmg;
		}
	/**
	 * Outputs flavor text and gives back dmg value
	 * @return int 6
	 */
	public int demonStrike () {
		System.out.println("Demon strikes at you!");
		return 6;
	}
	/**
	 * Outputs flavor text and gives back a value that changes according to random
	 * @return int 0 or int 50 
	 */
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
	
