package pl.sda.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookStorageTest {

    @Test // option extra
    void returnReviewOfStorage(){
        BookStore bookStore = new BookStore();
        bookStore.showBookStore();
    }

    @Test // option 10 test 1
    void returnAddBookToStorageIfBookExistInStore(){

        //given
        BookStore bookStore = new BookStore();
        assertEquals(7, bookStore.bookStorageSize());

        //then
        bookStore.addBookToStorage("Zenek", "NUdaa", 10);

        //then

        assertEquals(8,bookStore.bookStorageSize());
        }


    @Test // option 10 test 1
    void returnAddBookToStorageIfBookNotExistInStore() {

        //given
        BookStore bookStore = new BookStore();
        assertEquals(7, bookStore.bookStorageSize());

        //then
        bookStore.addBookToStorage("Marcin Przybyłek", "Gamedec Zabaweczki", 10);

        //then

        assertEquals(7, bookStore.bookStorageSize());
    }

    @Test // option 11
    void schouldReturnBookToSell(){
        //given
        BookStore bookStore = new BookStore();
        assertEquals(22, bookStore.returnAmountOfBooksInStore("Marcin Przybyłek", "Gamedec Zabaweczki"));

        //then
        bookStore.sellBook("Marcin Przybyłek", "Gamedec Zabaweczki",1);

        //then
        assertEquals(21, bookStore.returnAmountOfBooksInStore("Marcin Przybyłek", "Gamedec Zabaweczki"));


    }

    @Test
    void shouldReturnedAndSortedInGrowing(){
        BookStore bookStore = new BookStore();

//        bookStore.showBookCollection();
        System.out.println("//////////////////");


        bookStore.returnSortedStorageInGrowing();

    }



}