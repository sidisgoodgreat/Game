package Main;
import java.util.Scanner;

public class CombatEncounter {
	
	// instance variables
	private Misc m = new Misc();
	private Enemy e;
	private Player p;
	public CombatEncounter(Enemy e, Player p) {
		this.p = p;
		this.e= e;
	}
	/**
 	* Main combat cycle that repeats until either enemy or player is dead
  	* @return wonFight - true if the player's health is above 0, false otherwise
  	*/
	public boolean mainCombat() {
		art();
		System.out.println("You encounter a(n) "+e.getName()+"!");
		cycleBattle();
		int xpGet = 0;
		boolean wonFight = playerAlive();
		if(wonFight) {
			System.out.println("You win!");
			xpGet = e.getXP();
		} else {
			System.out.println("You died!");
		}
		p.setHP(p.getMaxHP());
		p.addXP(xpGet);
		return wonFight;
	}
	
	// runs the battle until either enemy or player dies
	public void cycleBattle() {
		while(isAlive()) {
			playerCombatCycle();
			if(!isAlive()) {
				break;
			}
			enemyCombatCycle();
			if(!isAlive()) {
				break;
			}
		}
	}
	
	/**
 	*Prompts user for input, then runs the method damageDealer with the input
  	*/
	public void playerCombatCycle() {
		System.out.println(p+
				   "\nChoose your move!"+
				   "\n"+p.getMoveDisplay());
		int dmg=p.moveRunner(m.intChoose('0', '3'));
		damageDealer(false,dmg,p.getDmgType());
	}
	
	//Plays enemy moveset and connect's enemies' dmg to their move=
	public void enemyCombatCycle() {
		int dmg=e.moveRunner();
		damageDealer(true,dmg,e.getDmgType());
	}
	
	/**
	 * Calculates how much damage player OR enemy should take
	 * according to opposing move
	 * @param isPlayer - If true, then dealas damage to enemy and uses enemy reistances
	 * @param dmg - value of the damage being dealt
	 * @param dmgType - Type of damage, either "magi" or "phys"
	 */
	public void damageDealer(boolean isPlayer, int dmg,String dmgType) {
		int actDmg=dmg;
		if(isPlayer&&dmgType.equals("magi")) { actDmg=(int)(actDmg*e.getMagRes());
		} else if(isPlayer&&dmgType.equals("phys")) { actDmg=(int)(actDmg*e.getPhysRes());
		} else if(!isPlayer&&dmgType.equals("magi")) { actDmg=(int)(actDmg*p.getMagRes());
		} else if(!isPlayer&&dmgType.equals("phys")) { actDmg=(int)(actDmg*p.getPhysRes()); 
		}
		if(isPlayer) {
			p.setHP(p.getHP()-dmg);
		} else {
			e.setHP(e.getHP()-dmg);
		}
	}
	/**
	 * Detects whether either the player and enemy is alive
	 * @return true if player and enemy has an hp greater than 0, false otherwise
	 */
	public boolean isAlive() {
		return (p.getHP()>0)&&(e.getHP()>0);
	}
	/**
	 * Detects whether the player is alive
	 * @return true if player has an hp greater than 0, false otherwise
	 */
	public boolean playerAlive() {
		return (p.getHP()>=0);
	}
	/**
	 * Outputs art that is displayed when you encounter an enemy
	 */
	public void art() {
			String bar = "@@@@@@@@@@@@";
			for (int i = 0; i <= 11; i++) {
				System.out.println(bar.substring(0,i) + "*" + bar.substring(i));
			}
			for (int n = 11; n >= 0; n--) {
				System.out.println(bar.substring(0,n) + "*" + bar.substring(n));
			}
			for (int i = 0; i <= 11; i++) {
				System.out.println(bar.substring(0,i) + "*" + bar.substring(i));
			}
			System.out.println();
	}
}
