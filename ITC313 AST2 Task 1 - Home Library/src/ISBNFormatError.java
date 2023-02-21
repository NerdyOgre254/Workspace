
public class ISBNFormatError 
{
    public final int ISBNLENGTH = 10;
    private boolean validIsbn;
    
    public ISBNFormatError(String isbn)
    {
        validIsbn = false;
        if (isCorrectLength(isbn) && isNumericOnly(isbn))
        {
            setValidIsbn(true);
        }
    }
    
    public void setValidIsbn(boolean valid)
    {
        validIsbn = valid;
    }
    
    public boolean getValidIsbn()
    {
        return validIsbn;
    }
    
    public boolean isCorrectLength(String isbn)
    {
        if (isbn.length() == ISBNLENGTH)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean isNumericOnly(String isbn)
    {
        if (isbn.matches("[0-9]+"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
