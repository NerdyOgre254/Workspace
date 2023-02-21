import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Library implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -1868910588788477414L;
    public ArrayList<Book> currentBooks;
    
    //constructor, initialises the books
    public Library()
    {
        //go through serialised file and add books to array
        currentBooks = new ArrayList<Book>();
    }
    
    //add book to ArrayList
    private void addBook(Book newBook)
    {
        currentBooks.add(newBook);
    }
    
    //get Scanner input to add books
    public void addBookUI(Scanner keepScan)
    {
        //flags and attributes to add
        
        String title;
        int year = 0;
        String author;
        String isbn;
        boolean validIsbn = false;
        boolean validYear = false;
        
        //grab the book title, with loop for error fixing
        System.out.println("Enter book title: ");
        title = keepScan.nextLine();
        while (title.length() == 0)
        {
            System.out.println("ERROR: empty title not permitted. Enter title: ");
            title = keepScan.nextLine();
        }
        
        //grab the author, 
        System.out.println("Enter book author: ");
        author = keepScan.nextLine();
        while (author.length() == 0)
        {
            System.out.println("ERROR: empty author not permitted. Enter author: ");
            author = keepScan.nextLine();
        }
        
        //grab the year. Includes system for handling input of non-numeric strings and invalid year ranges
        System.out.println("Enter year of publication: ");
        while (!validYear)
        {
            try
            {
                year = Integer.valueOf(keepScan.nextLine());
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("ERROR: Not a number");
            }
            if (year < 1000 || year > 9999)
            {
                System.out.println("ERROR: year must be a 4 digit number");
            }
            else
            {
                validYear = true;
            }
        }
        
        //grab the ISBN. includes the ISBN formatting requirements
        System.out.println("Enter ISBN: ");
        isbn = keepScan.nextLine();
        ISBNFormatError isbnCheck = new ISBNFormatError(isbn);
        validIsbn = isbnCheck.getValidIsbn();
        while (validIsbn == false)
        {
            System.out.println("ERROR: ISBN must be ten-digit numerics only. Enter a valid ISBN");
            isbn = keepScan.nextLine();
            isbnCheck = new ISBNFormatError(isbn);
            validIsbn = isbnCheck.getValidIsbn();
        }
        
        
        addBook(new Book(title, author, year, isbn));
        System.out.println("Book added successfully");
       
    }
    
    //remove book from ArrayList
    private void removeBook(Book newBook)
    {
        currentBooks.remove(newBook);
    }
    
    //get scanner input to remove books
    public void removeBookUI(Scanner keepScan)
    {        
        System.out.println("Search a book for deletion by");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Year of Publication");
        System.out.println("4. ISBN");
        String menuChoice = keepScan.nextLine();
        showAllBooks();
        ArrayList<Book> deletionList = new ArrayList<Book>();
        switch(menuChoice)
        {
            case "1":
                System.out.println("Enter a title: ");                
                deletionList = this.findBookFromTitle(keepScan.nextLine());
                if (deletionList.size() > 0)
                {
                    System.out.println(deletionList.get(0).toString());
                    System.out.println("Delete this book? <Y/N>");
                    String selection = keepScan.next();
                    if (selection.equals("Y"))
                    {
                        removeBook(deletionList.get(0));
                    }
                }
                break;
                
            case "2":
                System.out.println("Enter an author: ");
                deletionList = this.findBookFromAuthor(keepScan.nextLine());
                if (deletionList.size() > 0)
                {
                    System.out.println(deletionList.get(0).toString());
                    System.out.println("Delete this book? <Y/N>");
                    String selection = keepScan.next();
                    if (selection.equals("Y"))
                    {
                        removeBook(deletionList.get(0));
                    }
                }
                
            case "3":
                System.out.println("Enter a year of publication: ");
                deletionList = this.findBookFromYear(keepScan.nextInt());
                if (deletionList.size() > 0)
                {
                    System.out.println(deletionList.get(0).toString());
                    System.out.println("Delete this book? <Y/N>");
                    String selection = keepScan.next();
                    if (selection.equals("Y"))
                    {
                        removeBook(deletionList.get(0));
                    }
                }
                
            case "4":
                System.out.println("Enter an ISBN: ");
                deletionList = this.findBookFromISBN(keepScan.nextLine());
                if (deletionList.size() > 0)
                {
                    System.out.println(deletionList.get(0).toString());
                    System.out.println("Delete this book? <Y/N>");
                    String selection = keepScan.next();
                    if (selection.equals("Y"))
                    {
                        removeBook(deletionList.get(0));
                    }
                }
                
            default:
                System.out.println("Choose a correct option");
        }       
    }
    
    //Find books by title/author/year/ISBN, puts them into another arrayList and grabs the first one
    public ArrayList<Book> findBookFromTitle(String reqTitle)
    {
        ArrayList<Book> matchList = new ArrayList<Book>();
        for (int i = 0; i < currentBooks.size(); i++)
        {
            if (currentBooks.get(i).getTitle().equals(reqTitle))
            {
                matchList.add(currentBooks.get(i));
            }
        }
        if (matchList.isEmpty())
        {
            System.out.println("No title matches found");
        }
        return matchList;
    }
    
    public ArrayList<Book> findBookFromAuthor(String reqAuthor)
    {
        ArrayList<Book> matchList = new ArrayList<Book>();
        for (int i = 0; i < currentBooks.size(); i++)
        {
            if (currentBooks.get(i).getAuthor().equals(reqAuthor))
            {
                matchList.add(currentBooks.get(i));
            }
        }
        if (matchList.isEmpty())
        {
            System.out.println("No author matches found");
        }
        return matchList;
    }
    
    public ArrayList<Book> findBookFromYear(int reqYear)
    {
        ArrayList<Book> matchList = new ArrayList<Book>();
        for (int i = 0; i < currentBooks.size(); i++)
        {
            if (currentBooks.get(i).getYear() == reqYear)
            {
                matchList.add(currentBooks.get(i));
            }
        }
        if (matchList.isEmpty())
        {
            System.out.println("No year matches found");
        }
        return matchList;
    }
    
    public ArrayList<Book> findBookFromISBN(String reqISBN)
    {
        ArrayList<Book> matchList = new ArrayList<Book>();
        for (int i = 0; i < currentBooks.size(); i++)
        {
            if (currentBooks.get(i).getIsbn().equals(reqISBN))
            {
                matchList.add(currentBooks.get(i));
            }
        }
        if (matchList.isEmpty())
        {
            System.out.println("No ISBN matches found");
        }
        return matchList;
        
    }
    
    //get user input for whichever search term needed 
    public void findBookUI(Scanner keepScan)
    {
        System.out.println("Search for a book by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Year of publication");
        System.out.println("4. ISBN");
        String response = keepScan.nextLine();
        String searchValue;
        switch (response)
        {
        case "1":
            System.out.println("Enter a title to search: ");
            searchValue = keepScan.nextLine();
            while (searchValue.length() == 0)
            {
                System.out.println("ERROR: cannot search empty title");
                searchValue = keepScan.nextLine();
            }
            
            
            
            break;
        case "2":
            System.out.println("Enter an author to search: ");
            searchValue = keepScan.nextLine();
            while (searchValue.length() == 0)
            {
                System.out.println("ERROR: cannot search empty author");
                searchValue = keepScan.nextLine();
            }
            
            break;
        case "3":
            System.out.println("Enter a year to search: ");
            searchValue = keepScan.nextLine();
            int yearSearch = Integer.valueOf(searchValue);
            while (yearSearch < 1000 && yearSearch > 9999)
            {
                System.out.println("ERROR: invalid year range, acceptable range 1000-9999");
                searchValue = keepScan.nextLine();
                yearSearch = Integer.valueOf(searchValue);                
            }
            
            break;
        case "4":
            System.out.println("Enter an ISBN to search: ");
            searchValue = keepScan.nextLine();
            ISBNFormatError isbnCheck = new ISBNFormatError(searchValue);
            boolean validIsbn = isbnCheck.getValidIsbn();
            while(!validIsbn)
            {
                System.out.println("ERROR: ISBN search term must be ten-digit numerics only");
                searchValue = keepScan.nextLine();
                isbnCheck = new ISBNFormatError(searchValue);
                validIsbn = isbnCheck.getValidIsbn();
            }
            
            break;
        default:
            
            break;
        }
        
    }
    
    //println for all books in arraylist
    public void showAllBooks()
    {
        //sort the books
        Collections.sort(currentBooks);
        
        for (int i = 0; i < currentBooks.size(); i++)
        {
            System.out.println(currentBooks.get(i).toString());
            
        }
    }
}
