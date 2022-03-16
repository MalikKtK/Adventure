import java.util.Locale;
import java.util.Scanner;

public class Adventure {

    private boolean isRunning = true;
    Map map = new Map();
    UserInterface ui = new UserInterface();
    Player player = new Player();

    public void go() {
        map.createRooms();
        Room currentRoom = map.getStartRoom();
        ui.greeting(currentRoom);
        player.setCurrentRoom(currentRoom);
        navigate();
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

    public void navigate() {
        while (isRunning) {

            switch (userCommand()) {
                case "north", "n", "go north", "go n" -> player.goNorth();

                case "south", "s", "go south", "go s" -> player.goSouth();

                case "east", "e", "go east", "go e" -> player.goEast();

                case "west", "w", "go west", "go w" -> player.goWest();

                case "help", "h", "help me" -> helpMenu();

                case "look", "look around", "l" -> ui.lookAround(player.getCurrentRoom());

                case "exit", "exit game", "quit", "quit game" -> exit();

                default -> ui.invalidAnswer();
            }
        }
    }
}
