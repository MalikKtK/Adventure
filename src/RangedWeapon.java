public class RangedWeapon extends Weapon {


  private int ammunition;

  RangedWeapon(String name, String description, int damage, int ammunition) {
    super(name, description, damage);
      this.ammunition = ammunition;

  }
}