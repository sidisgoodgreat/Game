package Main;

import java.util.Random;


//we import from overworld.
public class Encounter {
	private String eType;
	private String area;
	public int randomize() {
		Random rand = new Random();
        return rand.nextInt(6);
	}
	
	public String encounterGrass(int random){
		System.out.println("As you venture in the lands that you call... home...\n");
		eType = "nothing";
        if (random == 3 || random == 4) {
        	eType = "a snake";
        	//function that prompts you into a battle
        } else if (random == 5) {
        	eType = "a tree ent";
        	//function that prompts you into a battle
		}
		return eType;

    }

	public String encounterDesert(int random){
		System.out.println("As you wander around this relentless, scorching stove of an area...\n");
		eType = "nothing";
	    if (random == 3 || random == 4) {
	    	eType = "a golem";
	    	//function that prompts you into a battle
	    } else if (random == 5) {
	    	eType = "a sandworm";
	    	//function that prompts you into a battle
		}
	    return eType;
	}
	

	
	public String encounterUnder(int random, int step){
		System.out.println("As you carry your unyielding determination towards the light within the depths of hell...\n");
	    if (step < 15) {
	    	eType = "a demon";
	    	//function that prompts you into a battle
	    } else {
	    	eType = "yourself";
	    	//function that prompts you into a battle
	    	// confronting yourself...
		}
	    return eType;
	}

}
