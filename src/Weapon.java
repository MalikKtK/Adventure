public class Weapon extends Item {

  private int damage;
  private boolean canUse;

  Weapon(String name, String description, int damage) {
    super(name, description);

    this.damage = damage;
  }

  public int remainingUses() {
    return 0;
  }

  public boolean canUse() {
    return true;
  }

  public int getDamage() {
    return damage;
  }
}
