public class Weapon extends Item {

  private int damage;
  private boolean canUse;

  Weapon(String name, String description, int damage) {
    super(name, description);

    this.damage = damage;
  }

  public int remainingUses(Weapon weapon) {
    return ((RangedWeapon) weapon).getAmmunition();
  }

  public void canUse(Weapon weapon){
    if (remainingUses(weapon) > 0)
      canUse = true;
  }




}
