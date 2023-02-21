import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.File;
public class LibraryMain {

    public static void main(String[] args) 
    {
        /*
         * INITIALISING BLOCK
         */
        Library testLib;
        //check to see if library.obj exists, if it does, read from it
        File tempLib = new File("Library.obj");
        if (tempLib.exists())
        {
            testLib = readFromSerial();
        }
        else//create a new one if no
        {
            testLib = new Library();
        }
        Scanner newScan = new Scanner(System.in);   //main scanner, passed through to UI
        
        while (true)
        {
            showMainMenu();
            String selection = newScan.nextLine();
            switch(selection)
            {
            case "1":   //add
                testLib.addBookUI(newScan);
                break;
            case "2":   //remove
                testLib.removeBookUI(newScan);
                break;
            case "3":   //search
                testLib.findBookUI(newScan);
                break;
            case "4":   //display
                testLib.showAllBooks();
                break;
            case "5":   //exit
                exitWithSave(testLib, newScan);
                break;
            default:    //bad input
                System.out.println("INCORRECT INPUT");
                break;
            }
            
        }
    }
    
    //function to show main menu
    public static void showMainMenu()
    {
        System.out.println("## Welcome to the Home Library System ##\n");
        System.out.println("Please select one of the following options:");
        System.out.println("1. Add a new book");
        System.out.println("2. Delete a book");
        System.out.println("3. Search for a book");
        System.out.println("4. Display all books");
        System.out.println("5. Exit");
    }
    
    //function for grabbing a Library object from "Library.obj" if it exists
    public static Library readFromSerial()
    {
        Library lib = new Library();
        try
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Library.obj"));
            lib = (Library)(input.readObject());
            input.close();
        }
        catch (ClassNotFoundException cnf)
        {
            cnf.printStackTrace();
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
        
        return lib;
        
    }
    
    //function for exiting program and serialising Library
    public static void exitWithSave(Library outlib, Scanner keepScan)
    {
        //close the system.in scanner here
        keepScan.close();
        //serialise to file with overwrite
        try
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Library.obj", false));
            output.writeObject(outlib);
            output.close();
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
        System.exit(1);
    }
}
