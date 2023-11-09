package Game;

public class Enemy {
	private String name;
	private int type,hp,dmg;
	private double physRes,magRes;
	private String area;
	
	private EnemyGrass eg = new EnemyGrass();
	//private EnemyForest ef = new EnemyForest();
	//private EnemyCaves ec = new EnemyCaves();
	//private EnemyHeck eh = new EnemyHeck();
	//private EnemyNoNo en = new EnemyNoNo();
	
	
	public Enemy(int areaInit) {
		if (areaInit < 5) {
			area = "gLands";
			name=eg.getName();
			hp=eg.getHP();
			physRes=eg.getPhysRes();
			magRes=eg.getMagRes();
			type=eg.getType();
		} else if (areaInit > 10) {
			area = "dForest";
			//name=ef.getName();
			//hp=ef.getHP();
			//physRes=ef.getPhysRes();
			//magRes=ef.getMagRes();
			//type=ef.getType();
		} else if (areaInit > 15) {
			area = "caves";
			//name=ec.getName();
			//hp=ec.getHP();
			//physRes=ec.getPhysRes();
			//magRes=ec.getMagRes();
			//type=ec.getType();
		} else if (areaInit > 20) {
			area = "heck";
			//name=ef.getName();
			//hp=ef.getHP();
			//physRes=ef.getPhysRes();
			//magRes=ef.getMagRes();
			//type=ef.getType();
		} else if (areaInit > 25) {
			area = "nono";
			//name=en.getName();
			//hp=en.getHP();
			//physRes=en.getPhysRes();
			//magRes=en.getMagRes();
			//type=en.getType();
		}
	}
	public int moveRunner() {
		dmg=0;
		if(area.equals("gLands")) {
			dmg=eg.wholeMoves(type);
		}
		return dmg;
	}
}
