import java.util.Locale;
import java.util.Scanner;

public class Adventure {
    private Room currentRoom;
    private boolean isRunning = true;

    public static void main(String[] args) {
        Adventure adventure = new Adventure();
        adventure.createRooms();
        adventure.greeting();
        adventure.navigate();
    }

    public Room createRooms() {
        Room room1 = new Room();
        room1.setName("Forest clearing");
        room1.setDescription("You are in a pine forest. You are standing in a clearing with trees surrounding you and light shining down into the clearing");

        Room room2 = new Room();
        room2.setName("Swamp");
        room2.setDescription("You are in a swampy marsh. Water is reaching your angles and making your toes wet, eww");

        Room room3 = new Room();
        room3.setName("Burnt down forest");
        room3.setDescription("You reached a part of the forest that has been burned down and it looks charred");

        Room room4 = new Room();
        room4.setName("Eerie lake");
        room4.setDescription("You reach an eerie lake covered in mist. It looks scary");

        Room room5 = new Room();
        room5.setName("Cave");
        room5.setDescription("You reach a dark and dingy cave. The walls are moist and cold");

        Room room6 = new Room();
        room6.setName("Crashed plane");
        room6.setDescription("You reach the site of a crashed plane. There is blood on the plane doors, but no human remains anywhere");

        Room room7 = new Room();
        room7.setName("Graveyard");
        room7.setDescription("You reach a small graveyard. In the middle stands a mausoleum with the door pried open");

        Room room8 = new Room();
        room8.setName("Wooded cave entrance");
        room8.setDescription("You reach a wooded area with a massive cave. The cave entrance is a black hole dark as the night");

        Room room9 = new Room();
        room9.setName("Haunted house");
        room9.setDescription("You reach a small 2 story house. It looks abandoned with boarded up windows.");

        //Room 1
        room1.setNorth(null);
        room1.setSouth(room4);
        room1.setEast(room2);
        room1.setWest(null);

        //Room 2
        room2.setNorth(null);
        room2.setSouth(null);
        room2.setEast(room3);
        room2.setWest(room1);

        //Room 3
        room3.setNorth(null);
        room3.setSouth(room6);
        room3.setEast(null);
        room3.setWest(room2);

        //Room 4
        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.setEast(null);
        room4.setWest(null);

        //Room 5
        room5.setNorth(null);
        room5.setSouth(room8);
        room5.setEast(null);
        room5.setWest(null);

        //Room 6
        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.setEast(null);
        room6.setWest(null);

        //Room 7
        room7.setNorth(room4);
        room7.setSouth(null);
        room7.setEast(room8);
        room7.setWest(null);

        //Room 8
        room8.setNorth(room5);
        room8.setSouth(null);
        room8.setEast(room9);
        room8.setWest(room7);

        //Room 9
        room9.setNorth(room6);
        room9.setSouth(null);
        room9.setEast(room8);
        room9.setWest(null);

        return room1;
    }

    public void greeting() {
        currentRoom = createRooms();
        System.out.println("Hello! Welcome to the Adventure game.");
        System.out.println();
        System.out.println("""
                You will start the game at a certain location.\s
                From this point you can navigate around in the game by typing 'North', 'South', 'West' and 'East'\s
                depending on the direction you wish to go.\s""");
        System.out.println();
        System.out.println("""
                You have some commands at your disposal:
                Type 'Help' to get help.\s
                Type 'Look' to get a description of the room you are currently in.\s
                Type 'Exit' to exit the game."""
        );
        System.out.println();
        System.out.println("You are currently in a " + currentRoom.getName());
        System.out.println(currentRoom.getDescription());

    }

    public String userCommand() {
        Scanner input = new Scanner(System.in);
        String command = input.nextLine().toLowerCase(Locale.ROOT);
        return command;
    }

    public void navigate() {
        while (isRunning) {
            switch (userCommand()) {
                case "north", "n", "go north" -> {
                    if (currentRoom.getNorth() != null) {
                        currentRoom = currentRoom.getNorth();
                        System.out.println("Going north");
                        System.out.println("You are standing in: " + currentRoom.getName());
                        System.out.println(currentRoom.getDescription());
                    } else {
                        System.out.println("You can't go that direction");
                    }
                }
                case "south", "s", "go south" -> {
                    if (currentRoom.getSouth() != null) {
                        currentRoom = currentRoom.getSouth();
                        System.out.println("Going south");
                        System.out.println("You are standing in: " + currentRoom.getName());
                        System.out.println(currentRoom.getDescription());
                    } else {
                        System.out.println("You can't go that direction");
                    }
                }
                case "east", "e", "go east" -> {
                    if (currentRoom.getEast() != null) {
                        currentRoom = currentRoom.getEast();
                        System.out.println("Going East");
                        System.out.println("You are standing in: " + currentRoom.getName());
                        System.out.println(currentRoom.getDescription());
                    } else {
                        System.out.println("You can't go that direction");
                    }
                }
                case "west", "w", "go west" -> {
                    if (currentRoom.getWest() != null) {
                        currentRoom = currentRoom.getWest();
                        System.out.println("Going west");
                        System.out.println("You are standing in: " + currentRoom.getName());
                        System.out.println(currentRoom.getDescription());
                    } else {
                        System.out.println("You can't go that direction");
                    }
                }
                case "help" -> System.out.println("""
                        You can navigate around in the game by typing 'North', 'South', 'West' and 'East'
                        depending on the direction you wish to go.
                        You have some commands at your disposal.
                        Type 'Help' to get help.\s
                        Type 'Look' to get a description of the room you are currently in.\s
                        Type 'Exit' to exit the game.""");

                case "look" -> {
                    System.out.println("You looks around the room.\n");
                    System.out.println(currentRoom.getDescription());
                }
                case "exit" -> {
                    System.out.println("The program is shutting down, Thanks for playing!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid answer");
            }
        }
    }
}
