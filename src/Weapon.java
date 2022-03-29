public class Weapon extends Item {

  private int damage;

  Weapon(String name, String description, int damage) {
    super(name, description);

    this.damage = damage;
  }
}
