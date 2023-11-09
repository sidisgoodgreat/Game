package main;
import java.util.Scanner;
public class LevelingSystem {
  Player player = new Player();
  public void levelUp() {
    Scanner scan = new Scanner(System.in);
    //placehold for xp
    int xp;
    int level = player.getLevel();

    if((level < 21)&&(xp >= 100)) {
        player.resChange();
    }
  }
}
