package pl.sda.bookShop;

import org.junit.jupiter.api.Test;
import pl.sda.homework.ShopManager;
import pl.sda.homework.book.BookStorage;

import static org.junit.jupiter.api.Assertions.*;

class BookStorageTest {

    @Test // option extra
    void shouldReturnReviewOfStorage(){

        ShopManager bookStorage = new ShopManager();
        bookStorage.showBookStorage();
    }

    @Test // option 10 test 1
    void shouldReturnAddBookToStorageIfBookExistInStore(){

        //given
        ShopManager bookStorage = new ShopManager();
        assertEquals(7, bookStorage.bookStorageSize());

        //then
        bookStorage.addBookToStorage("Zenek", "NUdaa", 10);

        //then

        assertEquals(8,bookStorage.bookStorageSize());
        }

    @Test // option 10 test 1
    void shouldReturnAddBookToStorageIfBookNotExistInStore() {

        //given
        ShopManager bookStorage = new ShopManager();
        assertEquals(7, bookStorage.getBookStorageSize());

        //then
        bookStorage.addBookToStorage("Marcin Przybyłek", "Gamedec Zabaweczki", 10);

        //then

        assertEquals(7, bookStorage.getBookStorageSize());
    }

    @Test // option 11
    void shouldReturnBookToSell(){
        //given
        ShopManager bookStorage = new ShopManager();
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