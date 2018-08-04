package pl.sda.homework;

import pl.sda.homework.book.Book;
import pl.sda.homework.book.BookCollection;
import pl.sda.homework.book.BookStorage;


public class ShopManager {

    public BookCollection bookCollection = new BookCollection();
    public BookStorage bookStorage = new BookStorage();

    public ShopManager() {
        Book book7 = new Book("Brent Weeks", "Nie znana", 1.0);
        Book book1 = new Book("Jakub Ćwiek", "Kłamca", 7.5);
        Book book2 = new Book("Jarosław Grzędowicz", "Pan Lodowego Ogrodu TOM 1", 8.3);
        Book book3 = new Book("Andrzej Sapkowski", "Pani Jeziorna", 1.0);
        Book book4 = new Book("Marcin Przybyłek", "Gamedec Zabaweczki", 7.1);
        Book book5 = new Book("Brent Weeks", "Czarny Pryzmat", 9.1);
        Book book6 = new Book("Brent Weeks", "Droga Cienia", 9.8);



        this.bookCollection.addBook(book1);
        this.bookCollection.addBook(book2);
        this.bookCollection.addBook(book3);
        this.bookCollection.addBook(book4);
        this.bookCollection.addBook(book5);
        this.bookCollection.addBook(book6);
        this.bookCollection.addBook(book7);

        this.bookStorage.addBookToStorage(book1.getAuthor(),book1.getTitle(), 7);
        this.bookStorage.addBookToStorage(book2.getAuthor(),book1.getTitle(), 3);
        this.bookStorage.addBookToStorage(book3.getAuthor(),book1.getTitle(), 11);
        this.bookStorage.addBookToStorage(book4.getAuthor(),book1.getTitle(), 22);
        this.bookStorage.addBookToStorage(book5.getAuthor(),book1.getTitle(), 9);
        this.bookStorage.addBookToStorage(book6.getAuthor(),book1.getTitle(), 47);
        this.bookStorage.addBookToStorage(book7.getAuthor(),book1.getTitle(), 2);

    }

    public BookCollection getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(BookCollection bookCollection) {
        this.bookCollection = bookCollection;
    }

    public BookStorage getBookStorage() {
        return bookStorage;
    }

    public void setBookStorage(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

}
