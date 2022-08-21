package contact_app;

import java.lang.String;
public class ContactItem {

    private final String name;
    private final int phoneNumber;

    public ContactItem(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static ContactItem createFromString(String contactString) {
        String[] parts = contactString.split(":");
        return new ContactItem(parts[0].trim(), Integer.parseInt(parts[1].trim()));

    }


    @Override
    public String toString() {
        return name + " : " + phoneNumber;
    }
    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

}