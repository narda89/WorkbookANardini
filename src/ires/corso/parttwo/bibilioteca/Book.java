package ires.corso.parttwo.bibilioteca;

public class Book
{
    //Libro (autore, titolo, data pubblicazione, num. pagine, isbn)
    private final String boookIsbn;
    private final String bookTitle;
    private final String bookAuthor;
    private final String bookPubDate;
    private final String bookPages;

    public Book(String boookIsbn, String bookTitle, String bookAuthor, String bookPubDate, String bookPages) {
        this.boookIsbn = boookIsbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPubDate = bookPubDate;
        this.bookPages = bookPages;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}