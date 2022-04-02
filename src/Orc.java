import java.util.ArrayList;
import java.util.Arrays;

public class Orc extends Enemy {

  private int damage = 10;
  private ArrayList<Item> monsterInventory = new ArrayList<>();


  public Orc(String name, String description, int hp) {
    super(name, description, hp);
    // Her giver vi vores monster nogle items i den inventory, som den kan droppe når vi dræber den.
    monsterInventory.add(new MeleeWeapon("Dagger", "A shiny long knife", 8));
    monsterInventory.add(new Food("Lamb-chop", "A charred old lamb-chop", 5));
  }

  @Override
  public void attack(Player player){
    System.out.printf("%s attacks you for %d damage. ", getName(), damage);
    player.setHealth(player.getHealth()-damage);
    System.out.printf("\nYour remaining health is %d", player.getHealth());
  }

}