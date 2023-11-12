package Main;
import java.util.Scanner;

public class CombatEncounter {
	
	private Misc m = new Misc();
	private Enemy e;
	private Player p;
	public CombatEncounter(Enemy e, Player p) {
		this.p = p;
		this.e= e;
	}
	/*
	 * LOOP
	 * Player chooses their move
	 * Move is run
	 * Damage is run through resistances
	 * Damage is applied
	 * 
	 * Enemy makes move based off rng
	 * Move is run, resitances
	 * damage applied
	 * 
	 * Repeat until one person is dead
	 */
	//returns true if player wins the battle
	public boolean mainCombat() {
		art();
		System.out.println("You encounter a(n) "+e.getName()+"!");
		
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
		boolean playerWin;
		int xpGet;
		if(playerAlive()) {
			System.out.println("You win!");
			xpGet = e.getXP();
			playerWin=true;
		} else {
			System.out.println("You died!");
			xpGet = 0;
			playerWin=false;
		}
		p.setHP(p.getMaxHP());
		p.setXP(p.getXP()+xpGet);
		return playerWin;
	}
	public void playerCombatCycle() {
		System.out.println(p);
		System.out.println("Choose your move!");
		System.out.println(p.getMoveDisplay());
		int dmg=p.moveRunner(m.intChoose('0', '3'));
		damageDealer(false,dmg,p.getDmgType());
	}
	public void enemyCombatCycle() {
		int dmg=e.moveRunner();
		damageDealer(true,dmg,e.getDmgType());
	}
	//isPlayer means that the player is taking damage
	public void damageDealer(boolean isPlayer, int dmg,String dmgType) {
		int actDmg=dmg;
		if(isPlayer&&dmgType.equals("magi")) {
			actDmg=(int)(actDmg*e.getMagRes());
		} else if(isPlayer&&dmgType.equals("phys")) {
			actDmg=(int)(actDmg*e.getPhysRes());
		} else if(!isPlayer&&dmgType.equals("magi")) {
			actDmg=(int)(actDmg*p.getMagRes());
		}else if(!isPlayer&&dmgType.equals("phys")) {
			actDmg=(int)(actDmg*p.getPhysRes());
		}
		if(isPlayer) {
			p.setHP(p.getHP()-dmg);
		} else {
			e.setHP(e.getHP()-dmg);
		}
	}
	public boolean isAlive() {
		return (p.getHP()>0)&&(e.getHP()>0);
	}
	public boolean playerAlive() {
		return (p.getHP()>=0);
	}
	public void art() {
			for (int i = 0; i <= 11; i++) {
				String bar = "@@@@@@@@@@@@";
				System.out.println(bar.substring(0,i) + "*" + bar.substring(i));
			}
		
			for (int n = 11; n >= 0; n--) {
				String bar = "@@@@@@@@@@@@";
				System.out.println(bar.substring(0,n) + "*" + bar.substring(n));
			}
			
			for (int i = 0; i <= 11; i++) {
				String bar = "@@@@@@@@@@@@";
				System.out.println(bar.substring(0,i) + "*" + bar.substring(i));
			}
			System.out.println();
	}
}
