Package Main;

public class EnemyBoss {
	/*
	 * Types of Enemies
	 * Demon
	 * Yourself
	 */
	private String name,dmgType;
	private int type, hp, maxHP,xp;
	private double magRes, physRes,dmgMult;
	private Misc m = new Misc();
	
	public EnemyBoss (Player p) {
		name = "Yourself";
		hp = p.getMaxHP();
		maxHP = p.getMaxHP();
		magRes = p.getMagRes();
		physRes = p.getPhysRes();
		dmgMult=p.getDmgMult();
		xp=99999;
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
	// attacks
	// attack on yourself: slash/fireball
	public int wholeMoves () {
		int dmg = 0;
		if (m.percentRoller(50)) {
			dmgType="phys";
			dmg = slash;
		} else if {
			dmgType="magi";
			dmg = fireBall;
		}
		return dmg;
	}
	public int slash () {
		System.out.println("You got slashed!");
		return (int)(10*dmgMult);
	}
	public int fireBall () {
		if (m.percentRoller(70)) {
			System.out.println("You have been struck by a fireball!");
			return (int)(8*dmgMult);
		} else {
			System.out.println("You have dodged the fireball!");
			return 0;
		}
	}
}
	
