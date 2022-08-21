package contact_app;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class ContactList {

    private final ArrayList<ContactItem> contactItems;

    public ContactList() {
        contactItems = new ArrayList<>();
    }


    // Adding a new contact
    public boolean addContact(ContactItem contact) {

        // Before adding a contact we are checking that its exist or not

        if(findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
        }

        //If Not exist then add our contact
        contactItems.add(contact);
        return true;
    }

    //Update Contact using set method
    public boolean updateContact(ContactItem oldContact , ContactItem newContact) {
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0) {
            System.out.println(oldContact.getName() + " , was not found");
            return false;
        }

        this.contactItems.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    // Remove Contact
    public boolean removeContact(ContactItem contact) {
        int foundPosition = findContact(contact);
        if(foundPosition < 0) {
            System.out.println(contactItems + " , was not found");
            return false;
        }
        this.contactItems.remove(foundPosition);
        System.out.println(contactItems.get(foundPosition) + " was deleted");
        return true;
    }


    // Find Contact Position
    private int findContact(ContactItem contact) {
        return this.contactItems.indexOf(contact);
    }

    // Find Contact Names
    private int findContact(String contactName) {
        for(int i =0; i < contactItems.size(); i++) {
            // Creating another temporary object to hold the name and compare
            ContactItem contacts = this.contactItems.get(i);
            if(contacts.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(ContactItem contact) {
        if(findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public ContactItem queryContact(String name) {
        int position = findContact(name);
        if(position >=0) {
            return this.contactItems.get(position);
        }
        return null;
    }



    public void printContacts() {
        System.out.println("Contact list");
        for(int i = 0; i < this.contactItems.size(); i++) {
            System.out.println((i+1) + " ." +
                    this.contactItems.get(i).getName() +
                    " -> " + this.contactItems.get(i).getPhoneNumber());
        }
    }



    public String toStringList() {
        List<String> contactList = new ArrayList<>();
        for(ContactItem contact : this.contactItems) {
            contactList.add(contact.toString());
        }
        return contactList.toString();
    }

}