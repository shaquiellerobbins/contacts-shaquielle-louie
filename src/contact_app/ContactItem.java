package contact_app;

public class ContactItem {
    private String name;
    private int phoneNumber;

    public ContactItem(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static ContactItem createFromString(String itemString) {
        String [] parts = itemString.split(":");
        return new ContactItem(parts[0].trim(), Integer.parseInt(parts[1].trim()));
    }

    @Override
    public String toString() {
        return name + " : " + phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getphoneNumber() {
        return phoneNumber;
    }

    public void setQuantity(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}