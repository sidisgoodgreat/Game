package Main;

import java.util.Scanner;
public class Player {
	private String name;
	private String dmgType;
	private int hp=20;
	private int maxHP=20;
	private int level=1;
	private int xp;
	private int dmgMult=1;
	private double physRes=1;
	private double magRes=1;
	
	//constructor
	public Player(String name){
		this.name=name;
	}

  //object declaration
  	private Misc m = new Misc();
	private Scanner s = new Scanner(System.in);
	
	//Accessor Methods
	public String getName(){
		return name;
	}
	public int getHP() {
		return hp;
	}
	public int getLevel() {
		return level;
	}
	public int getXP(){
		return xp;
	}
	public int getDMG() {
		return dmg;
	}
	public int getDmgType() {
		return dmgType;
	}
	//Mutator methods
	public void setHP(int init) {
		hp=init;
	}
	public void setLevel(int init) {
		level=init;
	}
	public void setXP(int init){
		xp=init;
	}
	public void setDMG(int init) {
		dmg=init;
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
	
	//Level Up Methods
	public void levelCheck() {
		//Max level is 20, and xp to level up is 100
    		if((level < 21)&&(xp >= 100)) {
			levelUp();
        		resChange();
    		}
  	}
	//Damage Scaling?
	public void levelUp(){
		int levelCount=0;
		while(xp>=100){
			xp-=100;
			levelCount++;
		}
		String levelUpString = "You leveled up "+levelCount+"time"
		if(levelCount>1){
			levelUpString+="s!";
		} else {
			levelUpString+="!";
		}
		for(levelCount;levelCount>0;levelCount--){
			maxHP+=maxHP/4;
			hp=maxHP;
			level++;
			dmgMult/=(dmgMult*4);
			xp-=100;
		}
  	}
	public void resChange(){
		System.out.println("Choose resistance to raise"+
				  "\n0: Magical"+
				  "\n1: Physical");
		int chosen = s.nextInt();
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
	 * Spells
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
   		return 1*m.crit(20,2)*dmgMult;
	}
	String type1="phys";
	public int stab() {
		if(m.percentRoller(60)) {
			return 2*m.crit(50,3)*dmgMult;
		} else {
			return 0;
		}		
	}
	String type2="magi";
	public int fireball() {
		return 3*dmgMult;
	}
	String type3="self";
	public void drinkPot() {
		if(hpPotCount>0) {
			hp+=5*dmgMult;
			hpPotCount--;
		} else {
			System.out.println("out of pots!");
		}
		
	}
}
