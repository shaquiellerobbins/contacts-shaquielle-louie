package contact_app;

import java.util.ArrayList;

public class ContactListMain {

    public static void main(String[] args) {
//        GroceryItem [] groceryList = new GroceryItem[10];
//        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        ContactList contactList = new ContactList();

        ContactItem naranjas = new ContactItem("Oranges", 5);
        ContactItem cervezas = new ContactItem("Dos Equis", 24);
        ContactItem tocino = new ContactItem("Bacon", 10);

        // add the items to the list
        contactList.addContactItem(naranjas);
        contactList.addContactItem(tocino);
        contactList.addContactItem(cervezas);

        contactList.printItems();

        contactList.removeContactItem("Bacon");
        contactList.printItems();

        contactList.setItemQuantity("Oranges", 12);
        ContactItem anItem = contactList.getItemByName("Oranges");
        System.out.println(anItem);

        anItem = contactList.getItemByName("Tangerines");

        ContactListGateway.writeToFile(contactList);

        ContactList list2 = ContactListGateway.readFromFile();
        System.out.println("list2's contents");
        list2.printItems();

        System.out.println(list2.toStringList());

    }
}