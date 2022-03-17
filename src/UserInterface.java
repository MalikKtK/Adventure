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

    }

    public String playerName() {
        playerName = input.nextLine();
        playerNameCapitalized = playerName.substring(0,1).toUpperCase() + playerName.substring(1).toLowerCase();
        return playerNameCapitalized;
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
