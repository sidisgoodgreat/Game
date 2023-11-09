package Main;
import java.util.Scanner;

public class CombatEncounter {
	
	private Misc m = new Misc();
	private Enemy e;
	private Player p;
	public CombatEncounter(Enemy e, Player p) {
		this.p = p;
		this.e=e;
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
	public void mainCombat() {
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
		if(playerAlive()) {
			System.out.println("You win!");
		} else {
			System.out.println("You died!");
		}
	}
	public void playerCombatCycle() {
		System.out.println(p);
		System.out.println("Choose your move!");
		System.out.println(p.getMoveDisplay());
		damageDealer(false,p.moveRunner(m.intChoose('0', '3')),p.getDmgType());
	}
	public void enemyCombatCycle() {
		damageDealer(true,e.moveRunner());
	}
	public void damageDealer(boolean isPlayer, int dmg,String dmgType) {
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
