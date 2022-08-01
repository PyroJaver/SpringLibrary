package library.creator;

import library.models.Book;

public class BookCreator {
    public static final String TITLE = "TestTitle";
    public static final String AUTHOR = "TestAuthor";
    public static final int YEAR = 1700;

    public static Book createTestBook(){
        Book testBook = new Book();
        testBook.setTitle(TITLE);
        testBook.setAuthor(AUTHOR);
        testBook.setYear(YEAR);

        return testBook;
    }
}
