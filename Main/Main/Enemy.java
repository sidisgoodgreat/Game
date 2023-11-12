package Main;

public class Enemy {
	private String name,dmgType;
	private int type,hp,dmg;
	private double physRes,magRes;
	private String area;
	
	private EnemyGrass eg = new EnemyGrass();
	private EnemyForest ed = new EnemyDesert();
	//private EnemyUnder eu = new EnemyUnder();
	
	
	public Enemy(int areaInit) {
		if (areaInit < 5) {
			area = "gLands";
			name=eg.getName();
			hp=eg.getHP();
			physRes=eg.getPhysRes();
			magRes=eg.getMagRes();
			type=eg.getType();
		} else if (areaInit > 10) {
			area = "desert";
			name=ed.getName();
			hp=ed.getHP();
			physRes=ed.getPhysRes();
			magRes=ed.getMagRes();
			type=ed.getType();
		}  else if (areaInit > 15) {
			area = "under";
			//name=eu.getName();
			//hp=eu.getHP();
			//physRes=eu.getPhysRes();
			//magRes=eu.getMagRes();
			//type=eu.getType();
		}
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
	public int moveRunner() {
		dmg=0;
		if(area.equals("gLands")) {
			System.out.println(hp);
			dmgType=eg.getDmgType();
			dmg=eg.wholeMoves(type);
		} else if(area.equals("desert")) {
			System.out.println(hp);
			dmgType=ed.getDmgType();
			dmg=ed.wholeMoves(type);
		}else if(area.equals("under")) {
			//System.out.println(hp);
			//dmgType=ed.getDmgType();
			//dmg=ed.wholeMoves(type);
		}
		return dmg;
	}
}
