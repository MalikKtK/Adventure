public class RangedWeapon extends Weapon {


  private int ammunition;

  RangedWeapon(String name, String description, int damage, int ammunition) {
    super(name, description, damage);
    this.ammunition = ammunition;

  }

  public int getAmmunition() {
    return ammunition;
  }

  @Override
  public int remainingUses() {
    return ammunition;
  }

  @Override
  public boolean canUse() {
    if (ammunition > 0)
      return true;
    else
      return false;
  }

}
