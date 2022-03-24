public class Map {

    Room startRoom = createRooms();

    public Room getStartRoom() {
        return startRoom;
    }

    public Room createRooms() {
        Room room1 = new Room();
        Item axe = new Item("Axe", "A big old lumberjack axe");
        Item pouch = new Item("Pouch", "An old small leather pouch");
        Item matches = new Item("Matches", "A box of matches");
        room1.addItem(axe);
        room1.addItem(pouch);
        room1.addItem(matches);

        room1.setName("The Forest Clearing.");
        room1.setDescription("""
                There are trees surrounding you and light shining down into the clearing.
                Small birds are chirping from the trees, occasionally flying around between the branches of nearby trees.
                The trees are Pine trees, and a strong smell of pine resin fills your nostrils.""");
        room1.setShortDescription("""
                You have been in this forest clearing before. Birds are chirping and it smells like pine.""");
        room1.setVisited(true);

        Room room2 = new Room();
        Item potato = new Item("Potato", "A delicious potato");
        room2.addItem(potato);

        room2.setName("The Swamp.");
        room2.setDescription("""
                Water is reaching your angles and making your toes wet.
                There are strange sounds coming from all around you.""");
        room2.setShortDescription("""
                It is still wet, and not the nicest place to be.""");

        Room room3 = new Room();
        Item bow = new Item("Bow", "A beautifully crafted wooden bow");
        Item arrows = new Item("Arrows", "A bundle of arrows");
        room3.addItem(bow);
        room3.addItem(arrows);

        room3.setName("The Burned Down Forest.");
        room3.setDescription("""
                Most of the surrounding trees has burned down,
                leaving only charred stumpy remains. There is a general lack of life,
                and a smell of charred flesh fills the air.""");
        room3.setShortDescription("""
                Everything is still burned to a crisp.""");

        Room room4 = new Room();
        Item glasses = new Item("Glasses", "An old pair of reading glasses");
        room4.setName("The Eerie Lake.");
        room4.setDescription("""
                The lake covered in a thick mist.
                It looks unsettling, and through the mist two green eyes stares back at you.""");
        room4.setShortDescription("""
                The lake is still covered in mist but the green eyes are nowhere to be seen.""");

        Room room5 = new Room();
        Item lamp = new Item("Lamp", "A shiny old brass lamp");
        room5.addItem(lamp);

        room5.setName("The Dark Cave.");
        room5.setDescription("""
                Inside the cave it is pitch black.
                The walls are moist and cold, and so is the air.
                Critters can be heard skittering around the darkness,
                but a faint beam of light shines down from a crack in the top of the cave,
                to reveal a faint glinting in dark distance.""");
        room5.setShortDescription("""
                The cave is still pitch black. You can still see a faint light and
                hear the sound of critters in the background.""");

        Room room6 = new Room();
        Item skull = new Item("Skull", "A human skull. It has a large crack at the base");
        room6.addItem(skull);

        room6.setName("The Crash Site.");
        room6.setDescription("""
                Around you are the remains of a crashed plane. The fuselage is still intact
                but the wings have  ripped off in the crash.
                There is blood on the plane doors, but no human remains anywhere.
                The plane engine is smoking.""");
        room6.setShortDescription("""
                The planes engine has stopped smoking.""");

        Room room7 = new Room();
        Item treasureChest = new Item("Treasure Chest", "A giant wooden treasure chest filled with shimmering golden coins");
        room7.addItem(treasureChest);

        room7.setName("The Graveyard.");
        room7.setDescription("""
                The graveyard is small, and looks long abandoned.
                Small cracked tombstones are spread around the yard,
                and in the middle stands a mausoleum with the door pried open.""");
        room7.setShortDescription("""
                The mausoleums door has shut...""");

        Room room8 = new Room();
        Item torch = new Item("Torch", "A torch with a wooden handle dripping with wax");
        room8.addItem(torch);

        room8.setName("The Wooded Cave Entrance.");
        room8.setDescription("""
                The entrance to the cave is surrounded by thick brush and trees.
                It's a large dark hole, that is just big enough to squeeze through.""");
        room8.setShortDescription("""
                It hasn't changed much.""");

        Room room9 = new Room();
        Item sword = new Item("Sword", "An old viking sword. Still in remarkably good condition");
        room9.addItem(sword);

        room9.setName("The Haunted House.");
        room9.setDescription("""
                It looks abandoned with boarded up windows and cobwebs all over.""");
        room9.setShortDescription("""
                It is still very much abandoned.""");

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
}
