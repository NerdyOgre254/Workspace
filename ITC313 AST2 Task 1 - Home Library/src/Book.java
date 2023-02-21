import java.io.Serializable;

public class Book implements Serializable, Comparable<Book>
{
    /**
     * 
     */
    private static final long serialVersionUID = -7634913921468716688L;
    private String title;
    private String author;
    private int year;
    private String isbn;
    
    public Book(String title, String author, int year, String isbn)
    {
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setIsbn(isbn);
    }
    
    //getters and setters
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }
    
    public void setAuthor(String newAuthor)
    {
        author = newAuthor;
    }
    
    public void setYear(int newYear)
    {
        year = newYear;
    }
    
    public void setIsbn(String newIsbn)
    {
        isbn = newIsbn;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public String getIsbn()
    {
        return isbn;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: " + getTitle() + "\n");
        sb.append("Author: " + getAuthor() + "\n");
        sb.append("Year: " + getYear() + "\n");
        sb.append("ISBN: " + getIsbn() + "\n");
        return sb.toString();
    }

    //comparison: by title -> year -> author
    public int compareTo(Book b)
    {
        //get our int that we will use as the return
        int returnValue;
        
        //compare this book's title to the other's title
        returnValue = this.title.compareTo(b.getTitle());
        if (returnValue == 0)
        {
            //test by year
            if (this.year > b.getYear())
            {
                returnValue = 1;
            }
            else if (this.year < b.getYear())
            {
                returnValue = -1;
            }
            else    //if this book's year 
            {
                returnValue = this.author.compareTo(b.getAuthor());
            }
        }
        
        return returnValue;
    }
}
