package pl.sda.homework;

import org.junit.jupiter.api.Test;
import pl.sda.homework.book.Book;

import static org.junit.jupiter.api.Assertions.*;


class BookCollectionTest {

    private final static String NOT_IMPORTANT_AUTHOR = "some author";
    private final static String NOT_IMPORTANT_TITLE = "some title";
    private final static double NOT_IMPORTANT_RATING = 1.0;

    @Test //option 2
    void afterAddOneBookMyCollectionSizeShouldBeSeven() {
        //given
        BookStore bookStore = new BookStore();
        assertEquals(7, bookStore.collectionSize());
        //when
        bookStore.addBook(new Book(NOT_IMPORTANT_AUTHOR, NOT_IMPORTANT_TITLE, NOT_IMPORTANT_RATING));
        //then
        assertEquals(8, bookStore.collectionSize());
    }

    @Test // option 3
    void removeBookByTitle() {

        //given

        BookStore bookStore = new BookStore();

        assertEquals(7, bookStore.collectionSize());

        //when

        bookStore.removeBookByTitle("Kłamca");

        //then
        assertEquals(6, bookStore.collectionSize());

    }

    @Test //option 4
    void shouldReturnedAllBooksWithoutBooksOfAuthor() {

        //given
        BookStore bookStore = new BookStore();
        System.out.println(bookStore.findAuthorInCollection("Brent Weeks"));
        assertTrue(bookStore.findAuthorInCollection("Brent Weeks"));

        //when
        bookStore.removeAllBooksOfAuthor("Brent Weeks");


        //then
        assertFalse(bookStore.findAuthorInCollection("Brent Weeks"));
    }

    @Test // option 5
    void shouldReturnSortedCollectionByTitle() {

        //given
        BookStore bookStore = new BookStore();


        //when
        bookStore.returnBooksSortedByTitle();

        //then list in order by title
        System.out.println(bookStore.returnBooksSortedByTitle());
    }

    @Test // option 6
    void shouldReturnSortedCollectionByAuthor() {

        //given
        BookStore bookStore = new BookStore();

        //when
        bookStore.returnBooksSortedByAuthor();

        // then list in order by Author

        System.out.println(bookStore.returnBooksSortedByAuthor());
    }

    @Test  // option 7
    void shouldReturnSortedCollectionByRating() {

        //given
        BookStore bookStore = new BookStore();

        //when
        bookStore.returnBooksSortedByRating();

        //then list in order by Title

        System.out.println(bookStore.returnBooksSortedByRating());
    }

    @Test  // option 8
    void shouldReturnAuthorsCollectionsSortedByTitle() {

        //given
        BookStore bookStore = new BookStore();

        //when
        bookStore.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookStore.returnBooksSortedByTitle());

        // then
        System.out.println(bookStore.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookStore.returnBooksSortedByTitle()));
    }

    @Test  //option 9
    void houldReturnAuthorsCollectionsSortedByRating() {
        //given
        BookStore bookStore = new BookStore();

        //when
        bookStore.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookStore.returnBooksSortedByRating());

        // then
        System.out.println(bookStore.returnAuthorsCollectionsSortedByOption
                ("Brent Weeks", bookStore.returnBooksSortedByRating()));

    }

}