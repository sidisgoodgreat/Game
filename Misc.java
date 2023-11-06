package Game;
public class Misc{
	public boolean percentRoller(int chance) {
		int roll = (int) (Math.random()*100)+1;
		return roll<=chance;
	}
	public int crit(int chance, int multiplier){
    		if(percentRoller(chance)){
      			return multiplier;
    		} else {
			return 1;
		}
	}
  
}
