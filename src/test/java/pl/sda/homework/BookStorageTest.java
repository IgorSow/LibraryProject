package pl.sda.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookStorageTest {

    @Test
    void returnReviewOfStorage(){
        BookStore bookStore = new BookStore();


        bookStore.reviewOfStorage();
    }

    @Test
    void returnAddBookToStorage(){
        BookStore bookStore = new BookStore();
        bookStore.reviewOfStorage();

        System.out.println(" //////////////");
        bookStore.addBookToStorage("Zenek", "NUdaa", 10);
        bookStore.reviewOfStorage();
    }

    @Test
    void shouldReturnedAndSortedStorage(){
        BookStore bookStore = new BookStore();
        bookStore.returnSortedStorage();

    }



}