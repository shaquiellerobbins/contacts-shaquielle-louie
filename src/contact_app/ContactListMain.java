package contact_app;

import java.util.Scanner;

public class ContactListMain {


    private static Scanner scanner = new Scanner(System.in);
    // Creating an instant with a default Number
    private static ContactItem mobilePhone = new ContactItem("000 443 876");

    public static void main(String[] args) {
//        GroceryItem [] groceryList = new GroceryItem[10];
//        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        ContactList contactList = new ContactList();

        ContactItem person1 = new ContactItem("Jane", 2101234567);
        ContactItem person2 = new ContactItem("John", 2101234568);
        ContactItem person3 = new ContactItem("Benjamin", 2101234569);

        // add the items to the list
        contactList.addContactItem(person1);
        contactList.addContactItem(person2);
        contactList.addContactItem(person3);

        contactList.printItems();

        boolean quite = false;
        startPhone();
        printAction();
        while(!quite) {
            System.out.println("\n Enter action: (6 to show available actions)");
            int action = Scanner.nextInt();
            Scanner.nextLine();

            switch (action) {
                case 0 -> {
                    System.out.println("\n Shuting down .. ");
                    quite = true;
                }
                case 1 -> mobilePhone.printContacts();
                case 2 -> addNewContact();
                case 3 -> updateContact();
                case 4 -> removeContact();
                case 5 -> queryContact();
                case 6 -> printAction();
            }



        }

    }
    private static void addNewContact() {
        System.out.println("Enter new Contact Name: ");
        String name = Scanner.nextLine();
        System.out.println("Enter phone Number: ");
        String phone = Scanner.nextLine();
        ContactItem newContact = ContactItem.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New Contact Added: name = "+ name + " , phone" + phone );
        }else {
            System.out.println("Can't add, " + name +" already on file");
        }
    }


    private static void updateContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        ContactItem extContact = mobilePhone.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot found contact");
            return;
        }

        System.out.println("Enter new Conatct Name: ");
        String newName = Scanner.nextLine();
        System.out.println("Enter new Phone Number: ");
        String newNumber = Scanner.nextLine();

        ContactItem newContact = Contacts.createContact(newName, newNumber);
        if(mobilePhone.updateContact(extContact, newContact))
        {
            System.out.println("Successfully updated");
        }else {
            System.out.println("Error Updating Contact");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name : ");
        String name = Scanner.nextLine();
        ContactItem extContact = mobilePhone.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot found contact");
            return;
        }

        if(mobilePhone.removeContact(extContact)) {
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Error Deleting Contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name : ");
        String name = Scanner.nextLine();
        ContactItem extContact = mobilePhone.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot found contact");
            return;
        }

        System.out.println("Name : " + extContact.getName() +
                " Phone Number is: " + extContact.getPhoneNumber());
    }


    private static void startPhone() {
        System.out.println("Starting Phone . . .");
    }

    private static void printAction() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutDown\n" +
                "1 - to print contacts\n"+
                "2 - to add a new contact\n"+
                "3 - to update an existing contact\n"+
                "4 - to remove and existing contact\n"+
                "5 - query for existing contact\n"+
                "6 - to print a list of available actions.");
        System.out.println("Choose Your Action: ");
    }

}


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
}