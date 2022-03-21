import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in);
    String playerName;
    String playerNameCapitalized;

    public void greeting(Room currentRoom) {
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
        System.out.println("Please enter the name of your Adventurer!");
        playerName();
        System.out.println("Great job " + playerName + "!");

        System.out.println("""
                \nYou will start the game at a forest clearing.
                From this point you can navigate around in the game by typing:
                'go North', 'go South', 'go West' and 'go East' depending on the direction you wish to go.""");

        System.out.println("""
                \nYou have some additional commands at your disposal:
                Type 'Help' to get help.\s
                Type 'Look' to get a description of the room you are currently in.\s
                Type 'Exit' to exit the game.""");
        System.out.println("""
                \nNow lets play... ADVENTURE GAME""");
        System.out.println("\nYou wake up in " + currentRoom.getName());
        System.out.println("\n" + currentRoom.getDescription());
        System.out.println("\nThere is also a number of items around you:");
        System.out.println("\n" + currentRoom.getItems());

    }

    public void playerName() {
        playerName = input.nextLine();
        playerNameCapitalized = playerName.substring(0, 1).toUpperCase() + playerName.substring(1).toLowerCase();
    }

    public String[] userCommand() {
        String userInput = input.nextLine().toLowerCase(Locale.ROOT);
        String[] userInputElements = userInput.split(" ", 2);

        if (userInputElements.length == 1) {
            return new String[] {userInputElements[0], null};
        }

        return userInputElements;
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

    public void lookAround(Room currentRoom) {
        System.out.println(currentRoom.getDescription());
    }

    public void invalidAnswer() {
        System.out.println("Invalid answer. Try again or type 'help' to get a list of commands.");
    }

    public void printInventory(Player player) {
        if (player.getInventory().isEmpty())
            System.out.println("- Inventory is empty");
        else
            System.out.printf("- Inventory %s\n", player.getInventory());
    }
    public void printItemNotSpecified() {
        System.out.println("You need to specifiy which Item you want!");
    }

    public void printItemNotInRoom(String itemName) {
        System.out.printf("Sorry but there isn´t %s in the room;(\n", itemName);
    }

    public void printAddInventory() {
        System.out.println("Added item to inventory");
    }

    public void printRemoveInventory() {
        System.out.println("Removed item from inventory");
    }



    public void exitMessage() {
        System.out.println("""
                Thanks for playing
                              _                 _                     _____                     \s
                     /\\      | |               | |                   / ____|                    \s
                    /  \\   __| |_   _____ _ __ | |_ _   _ _ __ ___  | |  __  __ _ _ __ ___   ___\s
                   / /\\ \\ / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\ | | |_ |/ _` | '_ ` _ \\ / _ \\
                  / ____ \\ (_| |\\ V /  __/ | | | |_| |_| | | |  __/ | |__| | (_| | | | | | |  __/
                 /_/    \\_\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|  \\_____|\\__,_|_| |_| |_|\\___|
                                                                                                \s
                    """);
    }

}
