import java.util.Locale;
import java.util.Scanner;

public class Player {

    private Room currentRoom;
    final String cantGo = "You can't go that direction.";
    final String reachLocation = "You reach ";

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String userCommand() {
        Scanner input = new Scanner(System.in);
        return input.nextLine().toLowerCase(Locale.ROOT);
    }

    public void goNorth() {
        if (currentRoom.getNorth() == null) {
            System.out.println(cantGo);
        } else if (!currentRoom.getNorth().isVisited()) {
            if (currentRoom.getNorth() != null) {
                currentRoom = currentRoom.getNorth();
                System.out.println("Going north \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
                currentRoom.setVisited(true);
            }
        } else if (currentRoom.getNorth().isVisited()) {
            if (currentRoom.getNorth() != null) {
                currentRoom = currentRoom.getNorth();
                System.out.println("Going north \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getShortDescription());
            } else {
                System.out.println(cantGo);
            }
        }
    }

    public void goSouth() {
        if (currentRoom.getSouth() == null) {
            System.out.println(cantGo);
        } else if (!currentRoom.getSouth().isVisited()) {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                System.out.println("Going south \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
                currentRoom.setVisited(true);
            }
        } else if (currentRoom.getSouth().isVisited()) {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                System.out.println("Going south \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getShortDescription());
            } else {
                System.out.println(cantGo);
            }
        }
    }

    public void goEast() {
        if (currentRoom.getEast() == null) {
            System.out.println(cantGo);
        } else if (!currentRoom.getEast().isVisited()) {
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                System.out.println("Going east \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
                currentRoom.setVisited(true);
            }
        } else if (currentRoom.getEast().isVisited()) {
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                System.out.println("Going east \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getShortDescription());
            } else {
                System.out.println(cantGo);
            }
        }
    }

    public void goWest() {
        if (currentRoom.getWest() == null) {
            System.out.println(cantGo);
        } else if (!currentRoom.getWest().isVisited()) {
            if (currentRoom.getWest() != null) {
                currentRoom = currentRoom.getWest();
                System.out.println("Going west \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
                currentRoom.setVisited(true);
            }
        } else if (currentRoom.getWest().isVisited()) {
            if (currentRoom.getWest() != null) {
                currentRoom = currentRoom.getWest();
                System.out.println("Going west \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getShortDescription());
            } else {
                System.out.println(cantGo);
            }
        }
    }
}

