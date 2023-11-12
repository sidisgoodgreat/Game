
package Main;
import java.util.Scanner;

public class Player {
	private String name,dmgType;
	private int hp=20, maxHP=20,level=1, xp=0,xpNeeded = 100,hpPotCount=3;
	private double dmgMult=1,physRes = 1, magRes=1;
	
	private String moveDisplay="0: Slash"
			+ "\n1: Stab"
			+ "\n2: Fireball"
			+ "\n3: Drink Healing Potion";
	
	//constructor
	public Player(String name){
		this.name=name;
	}
	public Player(){
		name="bob";
	}
  //object declaration
  	private Misc m = new Misc();
	
	//Accessor Methods
	public String getName(){
		return name;
	}
	public String getDmgType() {
		return dmgType;
	}
	public String getMoveDisplay() {
		return moveDisplay;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public int getHP() {
		return hp;
	}
	public int getLevel() {
		return level;
	}
	public double getMagRes() {
		return magRes;
	}
	public double getPhysRes() {
		return physRes;
	}
	//Mutator methods
	public void setHP(int init) {
		hp=init;
	}
	public void setLevel(int init) {
		level=init;
	}
	public void setXP(int init) {
		xp=init;
	}
public void addXP(int init) {
		System.out.println("You gained "+init+" xp!");
		xp+=init;
	}
	//Display
	public String toString(){
		String s = "Name: "+name
			+"\nLevel: "+level
			+"\nHP: "+hp
			+"\nMagical Resistance: "+magResDisplay()
			+"\nPhysical Resistance: "+physResDisplay();
		return s;
	}
	public String magResDisplay(){
		double percent = (1.0-physRes)*100;
		return percent+"%";
	}
	public String physResDisplay(){
		double percent = (1.0-magRes)*100;
		return percent+"%";
	}
	public String displayMoves() {
		String s = "";
		return s;
	}
	
	//Level Up Methods
	public void levelUp(){
		int levelCount=0;
		while(xp>=xpNeeded){
			xp-=xpNeeded;
			levelCount++;
			xpNeeded += 100; //makes you need 100 more to go to next level. :)))
		}
		String levelUpString = "You leveled up "+levelCount+" time";
		if(levelCount==1){
			levelUpString+="s!";
		} else {
			levelUpString+="!";
		}
		System.out.println(levelUpString);
		for(int i=levelCount;i>0;i--){
			maxHP+=maxHP/4;
			hp=maxHP;
			level++;
			dmgMult*=4;
			dmgMult/=3;
			xp-=100;
		}
  	}
	public void resChange(int level){
		System.out.println("Choose resistance to raise"+
				  "\n0: Magical"+
				  "\n1: Physical");
		int chosen = m.intChoose('0', '1');
		if(chosen==0){
			magRes-=0.05;
		} else {
			physRes-=0.05;
		}
	}
	
	/*
	 * Moveset
	 * Slash
	 * Stab
	 * Fireball
	 * Healing Potion
	 *Resistances
	 *
	 */
	public int moveRunner(int choice) {
		int dmg=0;
		if(choice==0) {
			dmgType=type0;
			dmg=slash();
		}else if(choice==1) {
			dmgType=type1;
			dmg=stab();
		}else if(choice==2) {
			dmgType=type2;
			dmg=fireball();
		} else {
			drinkPot();
		}
		return dmg;
	}
	String type0="phys";
	public int slash() {
   		int dmg= 2*m.crit(20,2);
   		System.out.println("You slash with your sword!");
   		return (int)(dmg*dmgMult);
	}
	String type1="phys";
	public int stab() {
		int dmg = 0;
		if(m.percentRoller(60)) {
			dmg= 2*m.crit(50,3);
			System.out.println("You stab with your sword!");
		} else {
			System.out.println("You miss your stab!");
		}
		return (int)(dmg*dmgMult);
	}
	String type2="magi";
	public int fireball() {
		int dmg= 3;
		System.out.println("You throw a fireball!");
		return (int)(dmg*dmgMult);
	}
	String type3="self";
	public void drinkPot() {
		int healAmount = (int)(5*dmgMult);
		if(hpPotCount>0) {
			hp+=healAmount;
			System.out.println("You drink the healing potion. "+healAmount+" hp healed!");
			hpPotCount--;
		} else {
			System.out.println("out of pots!");
		}
		
	}
}
