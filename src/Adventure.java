import java.util.Locale;
import java.util.Scanner;

public class Adventure {
    private Room currentRoom;
    private boolean isRunning = true;
    final String cantGo = "You can't go that direction.";
    final String reachLocation = "You reach ";

    public void go() {
        createRooms();
        greeting();
        navigate();
    }

    public Room createRooms() {
        Room room1 = new Room();
        room1.setName("The Forest Clearing.");
        room1.setDescription("""
                There are trees surrounding you and light shining down into the clearing.
                Small birds are chirping from the trees, occasionally flying around between the branches of nearby trees.
                The trees are Pine trees, and a strong smell of pine resin fills your nostrils.""");
        room1.setShortDescription("""
                You have  in this forest clearing before. Birds are chirping and it smells like pine.""");
        room1.setVisited(true);

        Room room2 = new Room();
        room2.setName("The Swamp.");
        room2.setDescription("""
                Water is reaching your angles and making your toes wet.
                There are strange sounds coming from all around you.""");
        room2.setShortDescription("""
                It is still wet, and not the nicest place to be.""");

        Room room3 = new Room();
        room3.setName("The Burned Down Forest.");
        room3.setDescription("""
                Most of the surrounding trees has burned down,
                leaving only charred stumpy remains. There is a general lack of life,
                and a smell of charred flesh fills the air.""");
        room3.setShortDescription("""
                Everything is still burned to a crisp.""");

        Room room4 = new Room();
        room4.setName("The Eerie Lake.");
        room4.setDescription("""
                The lake covered in a thick mist.
                It looks unsettling, and through the mist two green eyes stares back at you.""");
        room4.setShortDescription("""
                The lake is still covered in mist but the green eyes are nowhere to be seen.""");

        Room room5 = new Room();
        room5.setName("The Dark Cave.");
        room5.setDescription("""
                Inside the cave it is pitch black.
                The walls are moist and cold, and so is the air.
                Critters can be heard skittering around the darkness,
                but a faint beam of light shines down from a crack in the top of the cave,
                to reveal a faint glinting in dark distance.""");
        room5.setShortDescription("""
                The cave is still pitch black. You can still see a faint light and
                hear the sound of critters in the background.""");


        Room room6 = new Room();
        room6.setName("The Crash Site.");
        room6.setDescription("""
                Around you are the remains of a crashed plane. The fuselage is still intact
                but the wings have  ripped off in the crash.
                There is blood on the plane doors, but no human remains anywhere.
                The plane engine is smoking.""");
        room6.setShortDescription("""
                The planes engine has stopped smoking.""");

        Room room7 = new Room();
        room7.setName("The Graveyard.");
        room7.setDescription("""
                The graveyard is small, and looks long abandoned.
                Small cracked tombstones are spread around the yard,
                and in the middle stands a mausoleum with the door pried open.""");
        room7.setShortDescription("""
                The mausoleums door has shut...""");

        Room room8 = new Room();
        room8.setName("The Wooded Cave Entrance.");
        room8.setDescription("""
                The entrance to the cave is surrounded by thick brush and trees.
                It's a large dark hole, that is just big enough to squeeze through.""");
        room8.setShortDescription("""
                It hasn't changed much.""");

        Room room9 = new Room();
        room9.setName("The Haunted House.");
        room9.setDescription("""
                It looks abandoned with boarded up windows and cobwebs all over.""");
        room9.setShortDescription("""
                It is still very much abandoned.""");

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
        System.out.println("""
                Hello!
                Welcome to the:
                              _                 _                     _____                     \s
                     /\\      | |               | |                   / ____|                    \s
                    /  \\   __| |_   _____ _ __ | |_ _   _ _ __ ___  | |  __  __ _ _ __ ___   ___\s
                   / /\\ \\ / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\ | | |_ |/ _` | '_ ` _ \\ / _ \\
                  / ____ \\ (_| |\\ V /  __/ | | | |_| |_| | | |  __/ | |__| | (_| | | | | | |  __/
                 /_/    \\_\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|  \\_____|\\__,_|_| |_| |_|\\___|
                                                                                                \s
                """);

        System.out.println("""
                You will start the game at a forest clearing.
                From this point you can navigate around in the game by typing:
                'go North', 'go South', 'go West' and 'go East' depending on the direction you wish to go.""");

        System.out.println("""
                \nYou have some commands at your disposal:
                Type 'Help' to get help.\s
                Type 'Look' to get a description of the room you are currently in.\s
                Type 'Exit' to exit the game.""");
        System.out.println("\nYou are currently in " + currentRoom.getName());
        System.out.println("\n" + currentRoom.getDescription());

    }

    public String userCommand() {
        Scanner input = new Scanner(System.in);
        return input.nextLine().toLowerCase(Locale.ROOT);
    }

    public void exit() {
        System.out.println("Thanks for playing Adventure Game!");
        isRunning = false;
    }

    public void helpMenu() {
        System.out.println("""
                You can navigate around in the game by typing 'North', 'South', 'West' and 'East'
                depending on the direction you wish to go. \n
                You have some commands at your disposal.
                Type 'Help' to get help.\s
                Type 'Look' to get a description of the room you are currently in.\s
                Type 'Exit' to exit the game.""");
    }

    public void lookAround() {
        System.out.println(currentRoom.getDescription());
    }

    public void invalidAnswer() {
        System.out.println("Invalid answer. Try again or type 'help' to get a list of commands.");
    }

    public void goNorth() {
        if (!currentRoom.getNorth().isVisited()) {
            if (currentRoom.getNorth() != null) {
                currentRoom = currentRoom.getNorth();
                System.out.println("Going north \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
                currentRoom.setVisited(true);
            } else {
                System.out.println(cantGo);
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
        if (!currentRoom.getSouth().isVisited()) {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                System.out.println("Going south \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
                currentRoom.setVisited(true);
            } else {
                System.out.println(cantGo);
            }
        } else if (currentRoom.getSouth().isVisited()) {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                System.out.println("Going South \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getShortDescription());
            } else {
                System.out.println(cantGo);
            }
        }
    }

    public void goEast() {
        if (!currentRoom.getEast().isVisited())
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                System.out.println("Going East \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
                currentRoom.setVisited(true);
            } else {
                System.out.println(cantGo);
            }
        else if (currentRoom.getEast().isVisited()) {
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                System.out.println("Going East \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getShortDescription());
            } else {
                System.out.println(cantGo);
            }
        }
    }

    public void goWest() {
        if (!currentRoom.getWest().isVisited()) {
            if (currentRoom.getWest() != null) {
                currentRoom = currentRoom.getWest();
                System.out.println("Going west \n");
                System.out.println(reachLocation + currentRoom.getName() + "\n");
                System.out.println(currentRoom.getDescription());
            } else {
                System.out.println(cantGo);
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

    public void navigate() {
        while (isRunning) {
            switch (userCommand()) {
                case "north", "n", "go north", "go n" -> goNorth();

                case "south", "s", "go south", "go s" -> goSouth();

                case "east", "e", "go east", "go e" -> goEast();

                case "west", "w", "go west", "go w" -> goWest();

                case "help", "h", "help me" -> helpMenu();

                case "look", "look around", "l" -> lookAround();

                case "exit", "exit game", "quit", "quit game" -> exit();

                default -> invalidAnswer();
            }
        }
    }
}
