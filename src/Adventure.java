public class Adventure {

    private boolean isRunning = true;
    private final Map map = new Map();
    private final UserInterface ui = new UserInterface();
    private final Player player = new Player(ui); // Her giver vi vores ui objekt vi lige har lavet ovenover med til player, så han kender det.

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
        switch (ui.userCommand()) {
            case "north", "n", "go north", "go n" -> player.goNorth();

            case "south", "s", "go south", "go s" -> player.goSouth();

            case "east", "e", "go east", "go e" -> player.goEast();

            case "west", "w", "go west", "go w" -> player.goWest();

            case "t", "take", "take item" -> player.takeItem(player, player.takeItemAnswer());

            case "d", "drop", "drop item" -> player.dropItem(player, player.dropItemAnswer());

            case "help", "h", "help me" -> ui.helpMenu();

            case "look", "look around", "l" -> ui.lookAround(player.getCurrentRoom());

            case "exit", "exit game", "quit", "quit game" -> exit();

            case "i", "inventory", "show inventory" -> ui.printInventory(player);

            case "hp", "health", "show health", "status health" -> player.playerHealth();

            case "eat" -> player.eat(player.eatFoodAnswer());

            case "equip" -> player.equipWeapon(player.equipWeaponAnswer());

            case "attack" -> player.attack(player.target());

            default -> ui.invalidAnswer();
        }
    }
}

