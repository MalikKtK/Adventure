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
        room1.setName("a forest clearing.");
        room1.setDescription("There are trees surrounding you all around and light shining down into the clearing.");

        Room room2 = new Room();
        room2.setName("a swamp.");
        room2.setDescription("Water is reaching your angles and making your toes wet. There are strange sounds coming from all around you.");

        Room room3 = new Room();
        room3.setName("a burned down forest.");
        room3.setDescription("Most of the surrounding trees has burned down, leaving only charred stumpy remains. There is a general lack of life, and a smell of charred flesh fills the air.");

        Room room4 = new Room();
        room4.setName("an eerie lake.");
        room4.setDescription("The lake covered in a thick mist. It looks unsettling, and through the mist two green eyes stares back at you.");

        Room room5 = new Room();
        room5.setName("a cave.");
        room5.setDescription("Inside the cave it is pitch black. The walls are moist and cold, and so is the air. Critters can be heard skittering around the darkness, but a faint beam of light shines down from a crack in the top of the cave, to reveal a faint glinting in dark distance.");

        Room room6 = new Room();
        room6.setName("a crash site.");
        room6.setDescription("Around you are the remains of a crashed plane. There is blood on the plane doors, but no human remains anywhere.");

        Room room7 = new Room();
        room7.setName("a graveyard.");
        room7.setDescription("The graveyard is small, and looks long abandoned. Small cracked tombstones are spread around the yard, and in the middle stands a mausoleum with the door pried open.");

        Room room8 = new Room();
        room8.setName("a wooded cave entrance.");
        room8.setDescription("The entrance to the cave is surrounded by thick brush and trees. It's a large dark hole, that is just big enough to squeeze through. ");

        Room room9 = new Room();
        room9.setName("a haunted house.");
        room9.setDescription("It looks abandoned with boarded up windows and cobwebs all over.");

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
        System.out.println("Hello! Welcome to the Adventure game.\n");

        System.out.println("""
                You will start the game at a forest clearing.
                From this point you can navigate around in the game by typing:
                'go North', 'go South', 'go West' and 'go East' depending on the direction you wish to go.""");

        System.out.println("""
                \nYou have some commands at your disposal:
                Type 'Help' to get help.\s
                Type 'Look' to get a description of the room you are currently in.\s
                Type 'Exit' to exit the game."""
        );
        System.out.println("\nYou are currently in " + currentRoom.getName());
        System.out.println(currentRoom.getDescription());

    }

    public String userCommand() {
        Scanner input = new Scanner(System.in);
        String command = input.nextLine().toLowerCase(Locale.ROOT);
        return command;
    }

    public void navigate() {
        while (isRunning) {
            String cantGo = "You can't go that direction.";
            String reach = "You reach ";
            switch (userCommand()) {
                case "north", "n", "go north", "go n" -> {
                    if (currentRoom.getNorth() != null) {
                        currentRoom = currentRoom.getNorth();
                        System.out.println("Going north");
                        System.out.println(reach + currentRoom.getName());
                        System.out.println(currentRoom.getDescription());
                    } else {
                        System.out.println(cantGo);
                    }
                }
                case "south", "s", "go south", "go s" -> {
                    if (currentRoom.getSouth() != null) {
                        currentRoom = currentRoom.getSouth();
                        System.out.println("Going south");
                        System.out.println(reach + currentRoom.getName());
                        System.out.println(currentRoom.getDescription());
                    } else {
                        System.out.println(cantGo);
                    }
                }
                case "east", "e", "go east", "go e" -> {
                    if (currentRoom.getEast() != null) {
                        currentRoom = currentRoom.getEast();
                        System.out.println("Going East");
                        System.out.println(reach + currentRoom.getName());
                        System.out.println(currentRoom.getDescription());
                    } else {
                        System.out.println(cantGo);
                    }
                }
                case "west", "w", "go west", "go w" -> {
                    if (currentRoom.getWest() != null) {
                        currentRoom = currentRoom.getWest();
                        System.out.println("Going west");
                        System.out.println(reach + currentRoom.getName());
                        System.out.println(currentRoom.getDescription());
                    } else {
                        System.out.println(cantGo);
                    }
                }
                case "help", "h", "help me" -> System.out.println("""
                        You can navigate around in the game by typing 'North', 'South', 'West' and 'East'
                        depending on the direction you wish to go. \n
                        You have some commands at your disposal.
                        Type 'Help' to get help.\s
                        Type 'Look' to get a description of the room you are currently in.\s
                        Type 'Exit' to exit the game.""");

                case "look", "look around", "l" -> {
                    System.out.println("You look around the room.\n");
                    System.out.println(currentRoom.getDescription());
                }
                case "exit", "exit game", "quit", "quit game" -> {
                    System.out.println("The program is shutting down, Thanks for playing!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid answer");
            }
        }
    }
}
