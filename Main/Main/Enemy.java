package Main;

public class Enemy {
	
	// instance variables
	private String name,dmgType;
	private int type,hp,dmg, xp;
	private double physRes,magRes;
	private String area;
	
	private EnemyGrass eg = new EnemyGrass();
	private EnemyDesert ed = new EnemyDesert();
	private EnemyUnder eu = new EnemyUnder();
	private EnemyBoss eb;
	
	/**
	 * Assigns instance variables according to area that is picked
	 * according to the step taken from Overworld class
	 * @param int areaInit
	 */
	public Enemy(int areaInit) {
		if (areaInit < 0) {
			name = "nothing";
		}
		else if (areaInit < 5) {
			initGrass();
		} else if (areaInit < 10) {
			initDesert();
		}  else if (areaInit < 15) {
			initUnder();
		}
	}
	/**
 	* Constructor if given a player Object, initializes the boss enemy class and assigns instance variables
  	* the corresponding values
  	*/
	public Enemy(Player p){
		eb = new EnemyBoss(p);
			area = "boss";
			name=eb.getName();
			hp=eb.getHP();
			physRes=eb.getPhysRes();
			magRes=eb.getMagRes();
			type=eb.getType();
			xp = eb.getXP();
		}
	
	// initializes inst variables according to enemy taken from Underworld class
	public void initUnder() {
		area = "under";
		name=eu.getName();
		hp=eu.getHP();
		physRes=eu.getPhysRes();
		magRes=eu.getMagRes();
		type=eu.getType();
		xp = eu.getXP();
	}
	
	// initializes inst variables according to enemy taken from Desert class
	public void initDesert() {
		area = "desert";
		name=ed.getName();
		hp=ed.getHP();
		physRes=ed.getPhysRes();
		magRes=ed.getMagRes();
		type=ed.getType();
		xp = ed.getXP();
	}
	// initializes inst variables according to enemy taken from Grasslands class
	public void initGrass() {
		area = "gLands";
		name=eg.getName();
		hp=eg.getHP();
		physRes=eg.getPhysRes();
		magRes=eg.getMagRes();
		type=eg.getType();
		xp = eg.getXP();
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
	* Runs the move of the Enemy Class based on what area the enemy is from
 	* @return damage dealt by the 
	*/
	public int moveRunner() {
		dmg=0;
		if(area.equals("gLands")) {
			dmg=runGrass();
		} else if(area.equals("desert")) {
			dmg=runDesert();
		}else if(area.equals("under")) {
			dmg=runUnder();
		}else if(area.equals("boss")) {
			dmg=runBoss();
		}
		return dmg;
	}
	
	/**
	* Runs move for the specified area enemy
 	* @return dmg from the wholeMoves method of the specified area enemy Class
	*/
	public int runGrass() {
		System.out.println(eg.getName() + " is at " + hp + " HP left!\n");
		dmgType=eg.getDmgType();
		
		return eg.wholeMoves(type);
	}
	/**
	* Runs move for the specified area enemy
 	* @return dmg from the wholeMoves method of the specified area enemy Class
	*/
	public int runDesert() {
		System.out.println(ed.getName() + " is at " + hp + " HP left!\n");
		dmgType=ed.getDmgType();
		return ed.wholeMoves(type);
	}
	/**
	* Runs move for the specified area enemy
 	* @return dmg from the wholeMoves method of the specified area enemy Class
	*/
	public int runUnder() {
		System.out.println(eu.getName() + " is at " + hp + " HP left!\n");
		dmgType=eu.getDmgType();
		return eu.wholeMoves(type);
	}
	/**
	* Runs move for the specified area enemy
 	* @return dmg from the wholeMoves method of the specified area enemy Class
	*/
	public int runBoss() {
		System.out.println("You're at " + hp + "HP left!\n");
		//dmg and dmgType re-initialization switched here because dmgType changes per move for this enemy only
		int dmg=eb.wholeMoves(); 
		dmgType=eb.getDmgType();
		return dmg;
	}
}
