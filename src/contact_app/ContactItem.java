package contact_app;

public class ContactItem {
    private String name;
    private int quantity;

    public ContactItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public static ContactItem createFromString(String itemString) {
        String [] parts = itemString.split(":");
        return new ContactItem(parts[0].trim(), Integer.parseInt(parts[1].trim()));
    }

    @Override
    public String toString() {
        return name + " : " + quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}