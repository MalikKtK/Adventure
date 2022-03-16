public class Adventure {

    private boolean isRunning = true;
    Map map = new Map();
    UserInterface ui = new UserInterface();
    Player player = new Player();

    public void run() {
        map.createRooms();
        Room currentRoom = map.getStartRoom();
        ui.greeting(currentRoom);
        player.setCurrentRoom(currentRoom);
        while (isRunning)
            userAction();
    }

    public void exit() {
        ui.exitMessage();
        isRunning = false;
    }

    public void userAction() {
        switch (player.userCommand()) {
            case "north", "n", "go north", "go n" -> player.goNorth();

            case "south", "s", "go south", "go s" -> player.goSouth();

            case "east", "e", "go east", "go e" -> player.goEast();

            case "west", "w", "go west", "go w" -> player.goWest();

            case "help", "h", "help me" -> ui.helpMenu();

            case "look", "look around", "l" -> ui.lookAround(player.getCurrentRoom());

            case "exit", "exit game", "quit", "quit game" -> exit();

            default -> ui.invalidAnswer();
        }
    }
}

