package contact_app;

// a gateway is a Martin Fowler term for a class whose job
// is to transmit data to/from a data source, like a db

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.lang.String;

public class ContactListGateway {

    public static void writeToFile(ContactList contactList) {
        // 1. make a path object
        Path filePath = getFilePath();
        if(filePath == null) {
            System.out.println("Filepath could not be created. Cannot save.");
            return;
        }

        // 2. make a temporary list of strings that are the grocery items and write those to the file
        List<String> contactString = Collections.singletonList(contactList.toStringList());

        // 3. use Files.write to send the data to the file
        writeContactStringsToFilePath(filePath, contactString);
    }


    private static void writeContactStringsToFilePath(Path filePath, List<String> contactString) {
        try {
            Files.write(filePath, contactString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ContactList readFromFile() {
        ContactList list = new ContactList();

        // 1. make a path object
        Path filePath = getFilePath();
        if(filePath == null) {
            System.out.println("Filepath could not be created. Cannot load.");
            return list;
        }

        // 2. read item strings from file
        List<String> contactStrings = readItemStringsFromFilePath(filePath);

        // 3. make items from the items strings and put them in the groceryList
        for(String itemString : contactStrings) {
            ContactItem item = ContactItem.createFromString(itemString);
            list.addContact(item);
        }
        return list;
    }

    private static List<String> readItemStringsFromFilePath(Path filePath) {
        try {
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // does everything for the data file and its contain directory
    // and returns the Path object we need to work with the data file
    private static Path getFilePath() {
        try {
            Path folder = Paths.get("contact_list");
            Path file = Paths.get("contact_list", "contact.txt");
            if(Files.exists(folder)) {
                System.out.println("Hey the folder already exists!");
            } else {
                Files.createDirectories(folder);
            }
            if(Files.exists(file)) {
                System.out.println("Hey the file already exists!");
            } else {
                Files.createFile(file);
            }
            return file;
        } catch(IOException e) {
            // log an error message so at least we know something went wrong
            System.err.println(e.getMessage());
        }
        return null;
    }

}