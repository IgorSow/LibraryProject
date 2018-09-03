package pl.sda.homework;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import pl.sda.homework.book.Book;
import pl.sda.homework.book.BookBasket;
import pl.sda.homework.book.BookCollection;
import pl.sda.homework.book.BookStorage;
import pl.sda.homework.account.Account;
import pl.sda.homework.database.Database;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ShopManager {

    private BookCollection bookCollection;
    private BookStorage bookStorage;
    private BookBasket bookBasket;
    private Account account;
    private Database myDatabase;


    public ShopManager() {
        this.bookCollection = new BookCollection();
        this.bookStorage = new BookStorage();
        this.bookBasket = new BookBasket();
        this.account = new Account();

        try {
            this.myDatabase = new Database("jdbc:mysql://localhost:3306/mystorage", "root", "1234");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Book book7 = new Book("Brent Weeks", "Nie znana", 1.0);
        Book book1 = new Book("Jakub Cwiek", "KLamca", 7.5);
        Book book2 = new Book("JarosLaw Grzedowicz", "Pan Lodowego Ogrodu TOM 1", 8.3);
        Book book3 = new Book("Andrzej Sapkowski", "Pani Jeziorna", 1.0);
        Book book4 = new Book("Marcin Przybyłek", "Gamedec Zabaweczki", 7.1);
        Book book5 = new Book("Brent Weeks", "Czarny Pryzmat", 9.1);
        Book book6 = new Book("Brent Weeks", "Droga Cienia", 9.8);


        bookCollection.addBook(book7);
        bookCollection.addBook(book1);
        bookCollection.addBook(book2);
        bookCollection.addBook(book3);
        bookCollection.addBook(book4);
        bookCollection.addBook(book5);
        bookCollection.addBook(book6);

        try {
            myDatabase.connect();
            myDatabase.addBook(book1);
            myDatabase.addBook(book2);
            myDatabase.addBook(book3);
            myDatabase.addBook(book4);
            myDatabase.addBook(book5);
            myDatabase.addBook(book6);
            myDatabase.addBook(book7);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        bookStorage.addBook(book1, 7);
        bookStorage.addBook(book2, 1);
        bookStorage.addBook(book3, 11);
        bookStorage.addBook(book4, 22);
        bookStorage.addBook(book5, 9);
        bookStorage.addBook(book6, 47);
        bookStorage.addBook(book7, 22);

        try {
            myDatabase.addAmountToStorage(book1, 7);
            myDatabase.addAmountToStorage(book2, 1);
            myDatabase.addAmountToStorage(book3, 11);
            myDatabase.addAmountToStorage(book4, 22);
            myDatabase.addAmountToStorage(book5, 9);
            myDatabase.addAmountToStorage(book6, 47);
            myDatabase.addAmountToStorage(book7, 22);
        } catch (SQLException e) {
            e.printStackTrace();
        }






    }



    public BookCollection getBookCollection() {
        return bookCollection;
    }

    public BookStorage getBookStorage() {
        return bookStorage;
    }

    public BookBasket getBookBasket() {
        return bookBasket;
    }

    public Account getAccount() {
        return account;
    }


    /*
    / import method from Collection
    */
    public void addBookToCollection(Book newBook) {
        bookCollection.addBook(newBook);
        bookStorage.addBook(newBook, 0);
    }

    public void showBookCollection() {
        bookCollection.showBookCollection();
    }

    public void removeBookByTitle(String bookToRemove) {
        bookCollection.removeBookByTitle(bookToRemove);
    }

    public void removeAllBooksOfAuthor(String authorToRemover) {
        bookCollection.removeAllBooksOfAuthor(authorToRemover);
    }

    public List<Book> returnBooksSortedByTitle() {
        return bookCollection.returnBooksSortedByTitle();
    }

    public List<Book> returnBooksSortedByAuthor() {
        return bookCollection.returnBooksSortedByAuthor();
    }

    public List<Book> returnBooksSortedByRating() {
        return bookCollection.returnBooksSortedByRating();
    }

    public List<Book> returnAuthorsCollectionsSortedByOption(String nameOfAuthor, List<Book> orderOfList) {
        return bookCollection.returnAuthorsCollectionsSortedByOption(nameOfAuthor, orderOfList);
    }

    public List<Book> returnBooksContainsTitle(String titleToFind) {

        return bookCollection.returnBooksContainsTitle(titleToFind);
    }


    //method used by test
    public int collectionSize() {
        return bookCollection.collectionSize();
    }

    public boolean findAuthorInCollection(String nameOfAuthor) {
        return bookCollection.findAuthorInCollection(nameOfAuthor);
    }


    //import method from storage

    public void showBookStorage() {
        bookStorage.showBookStore();
    }

    public void addBookToStorage(String author, String title, int amountOfBooks) {
        bookStorage.addBookToStorage(author, title, amountOfBooks);
    }

    public void sellBook(String nameOfAuthor, String title2, int amountOfBooks2) {
        if (bookStorage.sellBook(nameOfAuthor, title2, amountOfBooks2) == true) {
            account.addMoneyToAccount(14.55);
        }
    }

    public void returnSortedStorageInGrowing() {
        bookStorage.returnSortedStorageInGrowing();
    }

    public void removeListOfBooksFromStorage(List<Book> listOfBooksToRemove) {
        bookStorage.removeListOfBooks(listOfBooksToRemove);
    }

    private Book returnBookByOrdialNumber(int numberOfBookToReturn) {
        return bookStorage.returnBookByOrdialNumber(numberOfBookToReturn);
    }


    //method used by test

    public int bookStorageSize() {
        return bookStorage.getBookStorageSize();
    }

    public int getBookStorageSize() {
        return bookStorage.getBookStorageSize();
    }

    public int returnAmountOfBooksInStore(String nameOfAuthor, String title) {
        return bookStorage.returnAmountOfBooksInStore(nameOfAuthor, title);
    }


    // method manage bookBasket

    public void addBookToBasket(Book bookToAdd) {

        int amountOfBooksInStorage = bookStorage.getValueOfBookfromStorage(bookToAdd);

        int amountOfBooksInBasket = Collections.frequency(bookBasket.getBasket(), bookToAdd);


        if (amountOfBooksInStorage >= amountOfBooksInBasket) {
            bookBasket.addBookToBasket(bookToAdd);
        } else
            log.info("Ksiązki juz się skończyły zapraszamy wkrótce \n");
    }

    public void addBookToBasketByChoseNumber(int numberOfBookToReturn) {
        Book bookToAdd = returnBookByOrdialNumber(numberOfBookToReturn);

        int amountOfBooksInStorage = bookStorage.getValueOfBookfromStorage(bookToAdd);

        int amountOfBooksInBasket = Collections.frequency(bookBasket.getBasket(), bookToAdd);


        if (amountOfBooksInStorage >= amountOfBooksInBasket) {
            bookBasket.addBookToBasket(bookToAdd);
        } else
            log.info("Ksiązki juz się skończyły zapraszamy wkrótce \n");
    }

    public void showBasket() {
        bookBasket.showBasket();
    }

    public int getSizeOfBasket() {
        return bookBasket.getSizeOfBasket();
    }

    public void closeBasketAndFinalizeOrder() {

        removeListOfBooksFromStorage(bookBasket.getBasket());
        account.addMoneyToAccount(bookBasket.getValueOfBasket());
        log.info("Dokonałes zakupów na kwotę " + bookBasket.getValueOfBasket() + "\n");
        bookBasket.cleanBasket();

    }

    public void showDiscounts() {
        log.info("Zniżki rabatowe: ");
        log.info("Zniżki rabatowe: przy zakupie 3 książek 10%");
        log.info("Zniżki rabatowe: przy zakupie 5 książek 20%");
        log.info("Zniżki rabatowe: przy zakupie 7 książek 30%");
    }


    /*
    / contain method with account
    */
    public double getAccountBalance() {
        return account.getBalance();
    }


}

