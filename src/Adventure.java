import java.util.Scanner;

public class Adventure {
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;
    private Room currentRoom;

    public static void main(String[] args) {
        Adventure adventure = new Adventure();
        adventure.createRooms();
        adventure.greeting();
    }

    public Room createRooms() {
        room1 = new Room("Forest clearing", "You are in a pine forest. You are standing in a clearing with trees surrounding you and light shining down into the clearing");
        room2 = new Room("Swamp", "You are in a swampy marsh. Water is raching your angles and making your toes wet, eww");
        room3 = new Room("Burnt down forest", "You reached a part of the forest that has been burned down and it looks charred");
        room4 = new Room("Eerie lake", "You reach an eerie lake covered in mist. It looks scary");
        room5 = new Room("Cave", "You reach a dark and dingy cave. The walls are moist and cold");
        room6 = new Room("Crashed plane", "You reach the site of a crashed plane. There is blood on the plane doors, but no human remains anywhere");
        room7 = new Room("Graveyard", "You reach a small graveyard. In the middle stands a mausoleum with the door pried open");
        room8 = new Room("Wooded cave entrance", "You reach a wooded area with a massive cave. The cave entrance is a black hole dark as the night");
        room9 = new Room("Haunted house", "You reach a small 2 story house. It looks abandoned with boarded up windows.");

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

//     todo help commendo
//     todo exit commando
//     todo look commando
//     todo bevægelses metode

    public void greeting() {
        currentRoom = createRooms();
        System.out.println("Hello! Welcome to the Adventure game.");
        System.out.println("You will start the game at a certain location. \n" +
                "From this point you can navigate around in the game by typing 'North', 'South', 'West' and 'East' \n" +
                "depending on the direction you wish to go.");
        System.out.println("You have some commands at your disposal. \n" +
                "Type 'Help' to get help. \n" +
                "Type 'Look' to get a description of the room you are currently in. \n" +
                "Type 'Exit' to exit the game."
        );
        System.out.println("You are currently in a " + currentRoom.getName());
        System.out.println(currentRoom.getDescription());

        System.out.println("TEST!!!");

    }

    public void userCommand() {
        Scanner input = new Scanner(System.in);
        String userCommand = input.nextLine();


    }
}
