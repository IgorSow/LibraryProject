package pl.sda.homework;

import org.junit.jupiter.api.Test;
import pl.sda.homework.bookStorage.BookStorage;

import static org.junit.jupiter.api.Assertions.*;

class BookStorageTest {

    @Test // option extra
    void returnReviewOfStorage(){

        BookStorage bookStorage = new BookStorage();
        bookStorage.showBookStore();
    }

    @Test // option 10 test 1
    void returnAddBookToStorageIfBookExistInStore(){

        //given
        BookStorage bookStorage = new BookStorage();
        assertEquals(7, bookStorage.bookStorageSize());

        //then
        bookStorage.addBookToStorage("Zenek", "NUdaa", 10);

        //then

        assertEquals(8,bookStorage.bookStorageSize());
        }

    @Test // option 10 test 1
    void returnAddBookToStorageIfBookNotExistInStore() {

        //given
        BookStorage bookStorage = new BookStorage();
        assertEquals(7, bookStorage.bookStorageSize());

        //then
        bookStorage.addBookToStorage("Marcin Przybyłek", "Gamedec Zabaweczki", 10);

        //then

        assertEquals(7, bookStorage.bookStorageSize());
    }

    @Test // option 11
    void schouldReturnBookToSell(){
        //given
        BookStorage bookStorage = new BookStorage();
        assertEquals(22, bookStorage.returnAmountOfBooksInStore("Marcin Przybyłek", "Gamedec Zabaweczki"));

        //then
        bookStorage.sellBook("Marcin Przybyłek", "Gamedec Zabaweczki",1);

        //then
        assertEquals(21, bookStorage.returnAmountOfBooksInStore("Marcin Przybyłek", "Gamedec Zabaweczki"));


    }

    @Test //option 12
    void shouldReturnedAndSortedInGrowing(){
        BookStorage bookStorage = new BookStorage();

//        bookStore.showBookCollection();
        System.out.println("//////////////////");


        bookStorage.returnSortedStorageInGrowing();

    }



}