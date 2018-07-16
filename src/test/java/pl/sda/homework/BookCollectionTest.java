package pl.sda.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




class BookCollectionTest {

    private final static String NOT_IMPORTANT_AUTHOR = "some author";
    private final static String NOT_IMPORTANT_TITLE = "some title";
    private final static double NOT_IMPORTANT_RATING = 1.0;

    @Test
    void afterAddOneBookMyCollectionSizeShouldBeSeven(){
        //given
        BookStore bookStore = new BookStore();
        assertEquals(6, bookStore.collectionSize());
        //when
        bookStore.addBook(new Book(NOT_IMPORTANT_AUTHOR,NOT_IMPORTANT_TITLE,NOT_IMPORTANT_RATING));
        //then
        assertEquals(7, bookStore.collectionSize());
    }

    @Test
    void removeBookByTitle () {

        //given

        BookStore bookStore = new BookStore();

        assertEquals(6, bookStore.collectionSize());

        //when

        bookStore.removeBookByTitle("Kłamca");

        //then
        assertEquals(5, bookStore.collectionSize());

    }
    @Test
    void removeAuthor () {

        //given
        BookStore bookStore = new BookStore();
        System.out.println(bookStore.findAuthorInCollection("Brent Weeks"));

        assertTrue(bookStore.findAuthorInCollection("Brent Weeks"));

        //when
        bookStore.removeAllBooksOfAuthor("Brent Weeks");

        //then
        assertFalse(bookStore.findAuthorInCollection("Brent Weeks"));
    }





}