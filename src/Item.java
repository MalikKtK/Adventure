public class Item {

    private String name;
    private String description;

   Item(String name, String description) {
       this.name = name;
       this.description = description;
   }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
