public class Item {

    private String name;
    private String description;

   Item(String name, String description) {
       this.name = name;
       this.description = description;
   }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//   Items lamp = new Items("Lamp", "A shiny old brass lamp");
//   Items pouch = new Items("Pouch", "An old small leather pouch");
//   Items bow = new Items("Bow", "A beautifully crafted wooden bow");
//   Items arrows = new Items("Arrows", "A bundle of arrows");
//   Items treasureChest = new Items("Treasure Chest", "A giant wooden treasure chest filled with shimmering golden coins");
//   Items torch = new Items("Torch", "A torch with a wooden handle dripping with wax");
//   Items sword = new Items("Sword", "An old viking sword. Still in remarkably good condition");
//   Items matches = new Items("Matches", "A box of matches");
//   Items potato = new Items("Potato", "A delicious potato");
//   Items skull = new Items("Skull", "A human skull. It has a large crack at the base");
//
//    private String frog = "A live and rather large frog. It stares at you, almost hypnotizing you";
//    private String key = "An old iron key";

    // TODO der skal være en arraylist i hvert rum til ITEMS i rummet.
    // TODO der skal være en arraylist for player til hans items.
    // TODO der skal være en drop items og pick up items metode
    //      de skal .remove/add fra arraylist
    // TODO add items til 'look' metode og beskrivelse af rummet.


    @Override
    public String toString() {
        return description;
    }
}
