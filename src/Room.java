import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private boolean Visited = false;
    private String shortDescription;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
    private final ArrayList<Item> items = new ArrayList<>();

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getNorth() {
        return north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getSouth() {
        return south;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getWest() {
        return west;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisited() {
        return Visited;
    }

    public void setVisited(boolean BeenVisited) {
        this.Visited = BeenVisited;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public void removeItem(Item item) {
        items.remove(item);
    }




}



