import java.util.ArrayList;

public class Enemy {

  private String name;
  private String description;
  private int hp;
  private ArrayList<Item> monsterInventory;

  public Enemy(String name, String description, int hp){
    this.name = name;
    this.description = description;
    this.hp = hp;
  }

  public void attack(Player player){

  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public ArrayList<Item> getMonsterInventory() {
    return monsterInventory;
  }

  @Override
  public String toString() {
    return description;

  }
}
