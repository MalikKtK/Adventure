public class Adventure {
    String item;

    private boolean isRunning = true;
    private final Map map = new Map();
    private final UserInterface ui = new UserInterface();
    private final Player player = new Player();

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
        String[] inputElements = ui.userCommand();
        String command = inputElements[0];
        String item = inputElements[1];


        System.out.println("\nWhat do you want to do?");
        switch (command) {
            case "north", "n", "go north", "go n" -> player.goNorth();

            case "south", "s", "go south", "go s" -> player.goSouth();

            case "east", "e", "go east", "go e" -> player.goEast();

            case "west", "w", "go west", "go w" -> player.goWest();

            case "t", "take" -> player.takeItem(player, item);

            case "d", "drop" -> player.dropItem(player, item);

            case "help", "h", "help me" -> ui.helpMenu();

            case "look", "look around", "l" -> ui.lookAround(player.getCurrentRoom());

            case "exit", "exit game", "quit", "quit game" -> exit();


            case "i", "inventory" -> ui.printInventory(player);

            default -> ui.invalidAnswer();
        }
    }
}

