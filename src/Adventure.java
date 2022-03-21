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
        System.out.println("\nWhat do you want to do?");
        switch (player.userCommand()) {
            case "north", "n", "go north", "go n" -> player.goNorth();

            case "south", "s", "go south", "go s" -> player.goSouth();

            case "east", "e", "go east", "go e" -> player.goEast();

            case "west", "w", "go west", "go w" -> player.goWest();

            case "t", "take" -> takeItem(player, item);

            case "d", "drop" -> dropItem(player, item);

            case "help", "h", "help me" -> ui.helpMenu();

            case "look", "look around", "l" -> ui.lookAround(player.getCurrentRoom());

            case "exit", "exit game", "quit", "quit game" -> exit();


            case "i", "inventory" -> ui.printInventory(player);

            default -> ui.invalidAnswer();
        }
    }
    public void takeItem(Player player, String itemName) {
        Room currentRoom = player.getCurrentRoom();

        if (itemName == null) {
            ui.printItemNotSpecified();
            return;
        }

        for (Item item : currentRoom.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName) || item.getDescription().equalsIgnoreCase(itemName)) {
                player.takeItem(item);
                ui.printAddInventory();
                return;
            }
        }

        ui.printItemNotInRoom(itemName);
    }

    public void dropItem(Player player, String itemName) {
        if (itemName == null) {
            ui.printItemNotSpecified();
            return;
        }

        for (Item item : player.getInventory()) {
            if (item.getName().equalsIgnoreCase(itemName) || item.getDescription().equalsIgnoreCase(itemName)) {
                player.dropItem(item);
                ui.printRemoveInventory();
                return;
            }
        }

        ui.printItemNotInRoom(itemName);
    }
}

