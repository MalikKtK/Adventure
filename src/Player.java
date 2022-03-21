import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Scanner input = new Scanner(System.in);
    private Room currentRoom;
    final String cantGo = "You can't go that direction.";
    final String reachLocation = "You reach ";
    private final ArrayList<Item> inventory;


    public Player() {
        inventory = new ArrayList<>();
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
            System.out.println("Sorry but there isn´t an item named" + itemName + " in the room");
            return;
        }

        for (Item item : currentRoom.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName) || item.getDescription().equalsIgnoreCase(itemName)) {
                player.takeItemInv(item);
                System.out.println("Added item to inventory");
                return;
            }
        }

        System.out.println("Sorry but there isn´t an item named" + itemName + " in the room");
    }

    public void dropItem(Player player, String itemName) {
        if (itemName == null) {
            System.out.println("You need to specify which Item you want!");
            return;
        }
        for (Item item : player.getInventory()) {
            if (item.getName().equalsIgnoreCase(itemName) || item.getDescription().equalsIgnoreCase(itemName)) {
                player.dropItemInv(item);
                System.out.println("Removed item from inventory");
                return;
            }
        }

        System.out.println(" ");
    }
    public void takeItemInv(Item item) {
        currentRoom.removeItem(item);
        inventory.add(item);
    }

    public void dropItemInv(Item item) {
        inventory.remove(item);
        getCurrentRoom().addItem(item);
    }
}


