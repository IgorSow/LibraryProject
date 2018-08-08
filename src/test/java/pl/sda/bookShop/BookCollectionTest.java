package pl.sda.bookShop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import pl.sda.homework.ShopManager;
import pl.sda.homework.book.Book;
import pl.sda.homework.book.BookCollection;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class BookCollectionTest {

    private final static String NOT_IMPORTANT_AUTHOR = "some author";
    private final static String NOT_IMPORTANT_TITLE = "some title";
    private final static double NOT_IMPORTANT_RATING = 1.0;

    @Test //option 2
    void afterAddOneBookMyCollectionSizeShouldBeSeven() {
        //given
        ShopManager bookCollection = new ShopManager();
        assertEquals(7, bookCollection.collectionSize());
        //when
        bookCollection.addBookToCollection(new Book(NOT_IMPORTANT_AUTHOR, NOT_IMPORTANT_TITLE, NOT_IMPORTANT_RATING));
        //then
        assertEquals(8, bookCollection.collectionSize());
    }

    @Test // option 3
    void removeBookByTitle() {

        //given

        ShopManager bookCollection = new ShopManager();

        assertEquals(7, bookCollection.collectionSize());

        //when

        bookCollection.removeBookByTitle("Kłamca");

        //then
        assertEquals(6, bookCollection.collectionSize());

    }

    @Test //option 4
    void shouldReturnedAllBooksWithoutBooksOfAuthor() {

        //given
        ShopManager bookCollection = new ShopManager();
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
        ShopManager bookCollection = new ShopManager();


        //when
        bookCollection.returnBooksSortedByTitle();

        //then list in order by title
        log.info("\n" + bookCollection.returnBooksSortedByTitle());
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

        ShopManager bookCollection = new ShopManager();
        //when
        bookCollection.returnBooksSortedByRating();

        //then list in order by Title

        System.out.println(bookCollection.returnBooksSortedByRating());
    }

    @Test  // option 8
    void shouldReturnAuthorsCollectionsSortedByTitle() {

        //given
        ShopManager bookCollection = new ShopManager();

        //when
        bookCollection.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookCollection.returnBooksSortedByTitle());

        // then
        log.info("\n " + bookCollection.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookCollection.returnBooksSortedByTitle()));
    }

    @Test  //option 9
    void shouldReturnAuthorsCollectionsSortedByRating() {
        //given
        ShopManager bookCollection = new ShopManager();

        //when
        bookCollection.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookCollection.returnBooksSortedByRating());

        // then
        log.info("\n" + bookCollection.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookCollection.returnBooksSortedByRating()));

    }

    @Test //option 10
    void shouldReturnBooksContainsTitle(){
        //given
        ShopManager bookCollection = new ShopManager();

        //then
        bookCollection.returnBooksContainsTitle("Pan");

        //taken

        System.out.println(bookCollection.returnBooksContainsTitle("Pan"));
    }

}