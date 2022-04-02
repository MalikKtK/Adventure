public class CaveTroll extends Enemy{


  private int damage = 20;

  public CaveTroll(String name, String description, int hp) {
    super(name, description, hp);
  }

  @Override
  public void attack(Player player){
    System.out.printf("%s attacks you for %d", getName(), damage);
    player.setHealth(player.getHealth()-damage);
    System.out.printf("Your remaining health is %d", player.getHealth());
  }


}
