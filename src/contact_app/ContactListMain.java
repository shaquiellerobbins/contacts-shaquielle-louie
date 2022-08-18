package contact_app;

import java.util.Scanner;

public class ContactListMain {


    private static Scanner scanner = new Scanner(System.in);

    // Creating an instant with a default Name/Number
    private static ContactItem contacts = new ContactItem("John", 123456);

    //MAIN
    public static void main(String[] args) {


        ContactList contacts = new ContactList();

        ContactItem jane = new ContactItem("Jane", 2101234567);
        ContactItem john = new ContactItem("John", 2101234568);
        ContactItem benjamin = new ContactItem("Benjamin", 2101234569);

        // add the items to the list
        contacts.addContactItem(jane);
        contacts.addContactItem(john);
        contacts.addContactItem(benjamin);

        //loop through objects and print all?



        //Using Switch to print menu and loop through choices
        boolean interest = true;
        //contacts.printItems();

        while(interest) {
            System.out.println("\n (Main Menu) Enter action: ");

            int action = scanner.nextInt();
            scanner.nextLine();
            //1. View contacts.
            //2. Add a new contact.
            //3. Search a contact by name.
            //4. Delete an existing contact.
            //5. Exit.
            //Enter an option (1, 2, 3, 4 or 5):
            switch (action) {
                case 1:
                    for (String contact : contacts.toStringList()) {
                        System.out.println("Here is a contact: " + contact);
                        // contacts.printItems();
                    }

                    //contacts.printItems();
                    break;

                case 2:
                    //contacts.addContactItem();
                    break;

                case 3:
                   // contactList.searchContact();
                    break;
                case 4:
                    contacts.removeContactItem("");
                    break;
                case 5:
                    System.out.println("\n Shuting down .. ");
                    interest = false;
                    break;

            }

    }


}//main ends




//        contactList.removeContactItem("Bacon");
//        contactList.printItems();
//
//        contactList.setItemQuantity("Oranges", 12);
//        ContactItem anItem = contactList.getItemByName("Oranges");
//        System.out.println(anItem);
//
//        anItem = contactList.getItemByName("Tangerines");
//
//        ContactListGateway.writeToFile(contactList);
//
//        ContactList list2 = ContactListGateway.readFromFile();
//        System.out.println("list2's contents");
//        list2.printItems();
//
//        System.out.println(list2.toStringList());

    }
