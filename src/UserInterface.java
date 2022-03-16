public class UserInterface {

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

}
