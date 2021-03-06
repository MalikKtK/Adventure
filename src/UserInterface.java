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
        System.out.println("\nThere is also items around you:");
        System.out.println("\n" + currentRoom.getItems());
        if(!currentRoom.getEnemies().isEmpty())
            System.out.println("\nThere is also enemies around you!");
            System.out.println(currentRoom.getEnemies());

    }

    public String playerName() {
        playerName = input.nextLine();
        playerNameCapitalized = playerName.substring(0, 1).toUpperCase() + playerName.substring(1).toLowerCase();
        return playerNameCapitalized;
    }

    public String userCommand() {
        String userInput = input.nextLine().toLowerCase(Locale.ROOT);
        return userInput;
    }

    public void helpMenu() {
        System.out.println("""
                You can navigate around in the game by typing 'North', 'South', 'West' and 'East'
                depending on the direction you wish to go. \n
                You have some commands at your disposal.
                Type 'Help' to get help.\s
                Type 'Look' to get a description of the room you are currently in.\s
                Type 'Exit' to exit the game.\s
                Type 'Take' to take an item. \s
                Type 'Drop' to drop an item. \s
                Type 'Inventory' to show your inventory. \s
                Type 'Health' to show your current health. \s
                Type 'Eat' to eat a food item from your inventory. \s
                Type 'Equip' to equip a weapon from your inventory. \s
                Type 'Attack' to attack with your weapon. \s
                """);
    }

    public void lookAround(Room currentRoom) {
        System.out.println(currentRoom.getDescription());
        System.out.println("\nThere are also items around you:");
        System.out.println(currentRoom.getItems());
        if(!currentRoom.getEnemies().isEmpty())
        System.out.println("There is also enemies in the room");
        System.out.println(currentRoom.getEnemies());
        //TODO add room enemy
    }

    public void invalidAnswer() {
        System.out.println("Invalid answer. Try again or type 'help' to get a list of commands.");
    }

    public void printInventory(Player player) {
        if (player.getInventory().isEmpty())
            System.out.println("- Inventory is empty");
        else
            System.out.printf("Inventory: %s\n", player.getInventory());
    }

    public void printItemErrorMessage(String itemName) {
        System.out.println("Sorry but there is not an item named " + itemName + " in the room");
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
