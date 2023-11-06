
package Game;
public class Player {
	private int hp=100;
	private int level=1;
	private int dmg;
	private double physRes = 1;
	private double magRes=1;

  //object declaration
  Misc m = new Misc();
	
	//Accessor Methods
	public int getHP() {
		return hp;
	}
	public int getLevel() {
		return level;
	}
	public int getDMG() {
		return dmg;
	}
	//Mutator methods
	public void setHP(int init) {
		hp=init;
	}
	public void setLevel(int init) {
		level=init;
	}
	public void setDMG(int init) {
		dmg=init;
	}
	
	//Level Up Methods
	public void levelUp(){
  }
	/*
	 * Moveset
	 * Slash
	 * Stab
	 * Spells
	 *Resistances
	 *
	 */
	
	public int slash() {
   		return 50*m.crit(20,2);
	}
	public int stab() {
    		return 40*m.crit(50,3);
	}
	
}
