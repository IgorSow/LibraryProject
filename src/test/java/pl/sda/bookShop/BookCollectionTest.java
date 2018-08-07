package pl.sda.bookShop;

import org.junit.jupiter.api.Test;
import pl.sda.homework.book.Book;
import pl.sda.homework.book.BookCollection;

import static org.junit.jupiter.api.Assertions.*;


class BookCollectionTest {

    private final static String NOT_IMPORTANT_AUTHOR = "some author";
    private final static String NOT_IMPORTANT_TITLE = "some title";
    private final static double NOT_IMPORTANT_RATING = 1.0;

    @Test //option 2
    void afterAddOneBookMyCollectionSizeShouldBeSeven() {
        //given
        BookCollection bookCollection = new BookCollection();
        assertEquals(7, bookCollection.collectionSize());
        //when
        bookCollection.addBook(new Book(NOT_IMPORTANT_AUTHOR, NOT_IMPORTANT_TITLE, NOT_IMPORTANT_RATING));
        //then
        assertEquals(8, bookCollection.collectionSize());
    }

    @Test // option 3
    void removeBookByTitle() {

        //given

        BookCollection bookCollection = new BookCollection();

        assertEquals(7, bookCollection.collectionSize());

        //when

        bookCollection.removeBookByTitle("Kłamca");

        //then
        assertEquals(6, bookCollection.collectionSize());

    }

    @Test //option 4
    void shouldReturnedAllBooksWithoutBooksOfAuthor() {

        //given
        BookCollection bookCollection = new BookCollection();
        System.out.println(bookCollection.findAuthorInCollection("Brent Weeks"));
        assertTrue(bookCollection.findAuthorInCollection("Brent Weeks"));

        //when
        bookCollection.removeAllBooksOfAuthor("Brent Weeks");


        //then
        assertFalse(bookCollection.findAuthorInCollection("Brent Weeks"));
    }

    @Test // option 5
    void shouldReturnSortedCollectionByTitle() {

        //given
        BookCollection bookCollection = new BookCollection();


        //when
        bookCollection.returnBooksSortedByTitle();

        //then list in order by title
        System.out.println(bookCollection.returnBooksSortedByTitle());
    }

    @Test // option 6
    void shouldReturnSortedCollectionByAuthor() {

        //given
        BookCollection bookCollection = new BookCollection();

        //when
        bookCollection.returnBooksSortedByAuthor();

        // then list in order by Author

        System.out.println(bookCollection.returnBooksSortedByAuthor());
    }

    @Test  // option 7
    void shouldReturnSortedCollectionByRating() {

        //given

        BookCollection bookCollection = new BookCollection();
        //when
        bookCollection.returnBooksSortedByRating();

        //then list in order by Title

        System.out.println(bookCollection.returnBooksSortedByRating());
    }

    @Test  // option 8
    void shouldReturnAuthorsCollectionsSortedByTitle() {

        //given
        BookCollection bookCollection = new BookCollection();

        //when
        bookCollection.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookCollection.returnBooksSortedByTitle());

        // then
        System.out.println(bookCollection.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookCollection.returnBooksSortedByTitle()));
    }

    @Test  //option 9
    void shouldReturnAuthorsCollectionsSortedByRating() {
        //given
        BookCollection bookCollection = new BookCollection();

        //when
        bookCollection.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookCollection.returnBooksSortedByRating());

        // then
        System.out.println(bookCollection.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookCollection.returnBooksSortedByRating()));

    }

    @Test //option 10
    void shouldReturnBooksContainsTitle(){
        //given
        BookCollection bookCollection = new BookCollection();

        //then
        bookCollection.returnBooksContainsTitle("Pan");

        //taken

        System.out.println(bookCollection.returnBooksContainsTitle("Pan"));
    }

}