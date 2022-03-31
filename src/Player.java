import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Player {
    Scanner input = new Scanner(System.in);
    private Room currentRoom;
    final String cantGo = "You can't go that direction.";
    final String reachLocation = "You reach ";
    private final ArrayList<Item> inventory;
    private final UserInterface ui; // her gør vi at Player klassen kender UserInterface klasen.
    private int health = 100;
    private Weapon equippedWeapon;

    public Player(UserInterface ui) { // her giver vi ui med i constructor for Player, som vi bruger inde i Adventure klassen, når vi laver player.
        inventory = new ArrayList<>();
        this.ui = ui;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    // TODO: 17-03-2022 LAV SAMLET MOVE METODE MED RETNING SOME INDPUT.
    // De fire metoder goNorth, goSouth etc. minder dog så meget om hinanden.
    // Så mon ikke I kunne overveje at fjerne de redundante kodelinjer ved at have én move-metode i Player klassen,
    // der tager retning som parameter? Og så i en if-sætning tjekker på retning ....

    public void goNorth() {
        if (currentRoom.getNorth() == null) {
            System.out.println(cantGo);
        } else if (currentRoom.getNorth().isVisited()) {
            if (currentRoom.getNorth() != null) {
                currentRoom = currentRoom.getNorth();
                System.out.println("Going north \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
                listItems(currentRoom);
                currentRoom.setVisited(true);
            }
        } else if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            System.out.println("Going north \n");
            System.out.println(reachLocation + currentRoom.getName() + "\n");
            System.out.println(currentRoom.getShortDescription());
            listItems(currentRoom);
        } else {
            System.out.println(cantGo);
        }
    }

    public void goSouth() {
        if (currentRoom.getSouth() == null) {
            System.out.println(cantGo);
        } else if (currentRoom.getSouth().isVisited()) {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                System.out.println("Going south \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
                listItems(currentRoom);
                currentRoom.setVisited(true);
            }
        } else if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            System.out.println("Going south \n");
            System.out.println(reachLocation + currentRoom.getName() + "\n");
            System.out.println(currentRoom.getShortDescription());
            listItems(currentRoom);
        } else {
            System.out.println(cantGo);
        }
    }

    public void goEast() {
        if (currentRoom.getEast() == null) {
            System.out.println(cantGo);
        } else if (currentRoom.getEast().isVisited()) {
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                System.out.println("Going east \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
                listItems(currentRoom);
                currentRoom.setVisited(true);
            }
        } else if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            System.out.println("Going east \n");
            System.out.println(reachLocation + currentRoom.getName() + "\n");
            System.out.println(currentRoom.getShortDescription());
            listItems(currentRoom);
        } else {
            System.out.println(cantGo);
        }
    }

    public void goWest() {
        if (currentRoom.getWest() == null) {
            System.out.println(cantGo);
        } else if (currentRoom.getWest().isVisited()) {
            if (currentRoom.getWest() != null) {
                currentRoom = currentRoom.getWest();
                System.out.println("Going west \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
                listItems(currentRoom);
                currentRoom.setVisited(true);
            }
        } else if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            System.out.println("Going west \n");
            System.out.println(reachLocation + currentRoom.getName() + "\n");
            System.out.println(currentRoom.getShortDescription());
            listItems(currentRoom);
        } else {
            System.out.println(cantGo);
        }
    }

    public void listItems(Room currentRoom) {
        System.out.println("\nThere is also a number of items around you:");
        System.out.println("\n" + currentRoom.getItems());
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void takeItem(Player player, String itemName) {
        Room currentRoom = player.getCurrentRoom();
        if (itemName == null) {
            ui.printItemErrorMessage(itemName);
            return;
        }

        for (Item item : currentRoom.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName) || item.getDescription().equalsIgnoreCase(itemName)) {
                player.addItemPlayer(item);
                System.out.println("Added " + itemName + " item to inventory");
                return;
            }
        }
        ui.printItemErrorMessage(itemName);
    }

    public void dropItem(Player player, String itemName) {
        if (itemName == null) {
            System.out.println("You need to specify which Item you want!");
            return;
        }
        for (Item item : player.getInventory()) {
            if (item.getName().equalsIgnoreCase(itemName) || item.getDescription().equalsIgnoreCase(itemName)) {
                player.dropItemPlayer(item);
                System.out.println("Removed " + itemName + " item from inventory");
                return;
            }
        }

        System.out.println(" ");
    }

    public void addItemPlayer(Item item) {
        currentRoom.removeItem(item);
        inventory.add(item);
    }

    public void dropItemPlayer(Item item) {
        inventory.remove(item);
        getCurrentRoom().addItem(item);
    }

    public String takeItemAnswer() {
        System.out.println("What item would you like to take?");
        String playerAnswer = input.nextLine().toLowerCase(Locale.ROOT);
        return playerAnswer;
    }

    public String dropItemAnswer() {
        System.out.println("What item would you like to drop from your inventory?");
        System.out.println(getInventory());
        String playerAnswer = input.nextLine().toLowerCase(Locale.ROOT);
        return playerAnswer;
    }

    public void playerHealth() {
        System.out.println(health);
    }

    public void eat(String foodName) {
        // TODO hvis vi har flere items i inventory og spiser apple printer er output forkert

        for (int i = 0; i < getInventory().size(); i++) {
            Item tempItem = inventory.get(i);
            if (tempItem.getName().equalsIgnoreCase(foodName)) {
                if (inventory.get(i) instanceof Food) {
                    health = (health + ((Food) tempItem).getHealthPoints());
                    System.out.println("You are currently at " + health + "/100 health.");
                    //TODO add metode der tjekker 100/100
                    System.out.println("You have eaten " + tempItem.getName());
                    inventory.remove(i);
                } else
                    System.out.println("Uhm... " + tempItem.getName() + " isn't food.");
            } else
                System.out.println("You dont have anything called " + foodName + " in your inventory.");
        }
    }


    public String eatFoodAnswer() {
        System.out.println("What food would you like to eat?");
        String playerEatAnswer = input.nextLine().toLowerCase(Locale.ROOT);
        return playerEatAnswer;
    }


    public void equipWeapon(String weapon) {
        for (int i = 0; i < getInventory().size(); i++) {
            Item tempItem = inventory.get(i);
            if (tempItem.getName().equalsIgnoreCase(weapon)) {
                if (equippedWeapon != null) {
                    System.out.println("You already have a weapon equipped");
                    System.out.println("Unequip your current weapon first");
                } else if (inventory.get(i) instanceof Weapon) {
                    equippedWeapon = ((Weapon)tempItem);
                    System.out.println("You have equipped " + tempItem.getName());
                } else if (!(inventory.get(i) instanceof Weapon)) {
                    System.out.println("That's not a weapon!");
                } else
                    System.out.println("You dont have anything like that in your inventory");
            }
        }
    }

    public String equipWeaponAnswer() {
        System.out.println("What weapon would you like to equip?");
        String playerEquipAnswer = input.nextLine().toLowerCase(Locale.ROOT);
        return playerEquipAnswer;
    }

    public void unequipWeapon(String weapon) {
        for (int i = 0; i < getInventory().size(); i++) {
                Item tempItem = inventory.get(i);
                if (!(tempItem.getName().equalsIgnoreCase(weapon))) {
                    //if (equippedWeapon == null) {
                      //  System.out.println("You dont have a weapon equipped");

                    if (inventory.get(i) instanceof Weapon && equippedWeapon.getName() == weapon) {
                        System.out.println("You have unequipped " + tempItem.getName());
                        equippedWeapon = null;
                    } else if (inventory.get(i) instanceof Weapon && equippedWeapon.getName() != weapon) {
                        System.out.println("You dont have that weapon equipped");
                    } else if (equippedWeapon == null) {
                        System.out.println("You dont have a weapon equipped");
                    } else if (!(inventory.get(i) instanceof Weapon && equippedWeapon.getName() == weapon)){
                        System.out.println("That's not a weapon and its not equipped");
                    } else
                        System.out.println("ERROR try again");

            }
        }
    }

    public String unequipWeaponAnswer() {
        System.out.println("What weapon would you like to unequip?");
        String playerUnequipAnswer = input.nextLine().toLowerCase(Locale.ROOT);
        return playerUnequipAnswer;
    }

    public void attack() {
        if (equippedWeapon == null) {
            System.out.println("You need to equip first");
        } else
            System.out.println("You attacked the air!");
    }

    public String attackAnswer() {
      System.out.println("Which weapon would you like to attack with?");
      String playerAttackAnswer = input.nextLine().toLowerCase(Locale.ROOT);
      return playerAttackAnswer;
    }

}