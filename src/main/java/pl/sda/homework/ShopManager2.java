package pl.sda.homework;

import pl.sda.homework.book.Book;
import pl.sda.homework.book.BookCollection;
import pl.sda.homework.book.BookStorage;

public class ShopManager2 {

    private BookCollection bookCollection;
    private BookStorage bookStorage;

    public ShopManager2() {
        this.bookCollection = new BookCollection();
        this.bookStorage = new BookStorage();

        Book book7 = new Book("Brent Weeks", "Nie znana", 1.0);
        Book book1 = new Book("Jakub Ćwiek", "Kłamca", 7.5);
        Book book2 = new Book("Jarosław Grzędowicz", "Pan Lodowego Ogrodu TOM 1", 8.3);
        Book book3 = new Book("Andrzej Sapkowski", "Pani Jeziorna", 1.0);
        Book book4 = new Book("Marcin Przybyłek", "Gamedec Zabaweczki", 7.1);
        Book book5 = new Book("Brent Weeks", "Czarny Pryzmat", 9.1);
        Book book6 = new Book("Brent Weeks", "Droga Cienia", 9.8);

        this.addBook(book7);
        this.addBook(book1);
        this.addBook(book2);
        this.addBook(book3);
        this.addBook(book4);
        this.addBook(book5);
        this.addBook(book6);
    }

    // TODO: 2018-08-05 added Method to do two things
    public void addBook(Book book){
        bookCollection.addBook(book);
        bookStorage.addBookToStorage(book.getAuthor(),book.getTitle(),7);
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
