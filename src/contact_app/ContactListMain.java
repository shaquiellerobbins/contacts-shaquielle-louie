package contact_app;

import java.util.Scanner;
import java.lang.String;

public class ContactListMain {

    private static final Scanner scanner = new Scanner(System.in);
    // Creating an instant with a default Number
    private static final ContactList contactApp = new ContactList();

    public static void main(String[] args) {

        boolean quit = false;
        startApp();
        printAction();
        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1 -> contactApp.printContacts();
                case 2 -> addNewContact();
                case 3 -> queryContact();
                case 4 -> removeContact();
                case 5 -> updateContact();
                case 6 -> printAction();
                case 7 -> {
                    System.out.println("\n Shutting down .. ");
                    quit = true;
                }
            }
        }


            ContactListGateway.writeToFile(contactApp);

            ContactList list = ContactListGateway.readFromFile();
            System.out.println("list contents");
            list.printContacts();

            System.out.println(contactApp.toStringList());


        }


    private static void addNewContact() {
        System.out.println("Enter new Contact Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone Number: ");
        String phone = scanner.nextLine();
        ContactItem newContact = new ContactItem(name, Integer.parseInt(phone));
        if(contactApp.addContact(newContact)) {
            System.out.println("New Contact Added: name : "+ name + " , phone : " + phone );
        }else {
            System.out.println("Can't add, " + name +" already on file");
        }
    }


    private static void updateContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        ContactItem extContact = contactApp.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot find contact");
            return;
        }

        System.out.println("Enter new Contact Name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new Phone Number: ");
        int newNumber = Integer.parseInt(scanner.nextLine());

        ContactItem newContact = new ContactItem(newName, newNumber);
        if(contactApp.updateContact(extContact, newContact))
        {
            System.out.println("Successfully updated");
        }else {
            System.out.println("Error Updating Contact");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        ContactItem extContact = contactApp.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot find contact");
            return;
        }

        if(contactApp.removeContact(extContact)) {
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Error Deleting Contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        ContactItem extContact = contactApp.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot find contact");
            return;
        }

        System.out.println("Name : " + extContact.getName() +
                " Phone Number is: " + extContact.getPhoneNumber());
    }


    private static void startApp() {
        System.out.println("Starting App . . .");
    }


    private static void printAction() {
        System.out.println("Available actions:");
        System.out.println("""
                1 - View contacts
                2 - Add a new contact
                3 - Search a contact by name
                4 - Delete an existing contact
                5 - Update existing contact
                6 - List of available actions
                7 - Quit
                """);
        System.out.println("Choose Your Action: ");
    }



}