package Main;

public class EnemyBoss {
	 
	// Instance variables
	private String name,dmgType;
	private int type, hp, xp;
	private double magRes, physRes,dmgMult;
	private Misc m = new Misc();
	
	
	// Initializes enemy values according to your statistics
	// Instance variables mirror Player inst variables
	public EnemyBoss (Player p) {
		name = "Yourself";
		hp = p.getMaxHP();
		magRes = p.getMagRes();
		physRes = p.getPhysRes();
		dmgMult=p.getDmgMult();
		xp=0;
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
		
	// attacks
	// attack on yourself: slash/fireball
	// an attack method is picked based on probability
	public int wholeMoves () {
		int dmg = 0;
		if (m.percentRoller(50)) {
			dmgType="phys";
			dmg = slash();
		} else {
			dmgType="magi";
			dmg = fireBall();
		}
		return dmg;
	}
	
	/**
	 * Outputs flavor text and gives back a dmg value multiplied from your dmg multiplier
	 * @return int 10 * dmgMult 
	 */
	public int slash() {
		System.out.println("You got slashed!");
		return (int)(10*dmgMult);
	}
	
	/**
	 * Outputs flavor text and gives back a dmg value multiplied from your dmg multiplier
	 * Chance of missing (doing 0 dmg)
	 * @return int 8 * dmgMult or int 0
	 */
	public int fireBall() {
		if (m.percentRoller(70)) {
			System.out.println("You have been struck by a fireball!");
			return (int)(8*dmgMult);
		} else {
			System.out.println("You have dodged the fireball!");
			return 0;
		}
	}
}
	
