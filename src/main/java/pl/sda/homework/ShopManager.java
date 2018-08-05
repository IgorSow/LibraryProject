package pl.sda.homework;

import pl.sda.homework.book.Book;
import pl.sda.homework.book.BookCollection;
import pl.sda.homework.book.BookStorage;

public class ShopManager {

    private BookCollection bookCollection;
    private BookStorage bookStorage;

    public ShopManager() {
        this.bookCollection = new BookCollection();
        this.bookStorage = new BookStorage();

//TODO Chce tutaj stworzyc obiekt bookCollection i bookStorage tutaj nimi zarzadzac (
// w sensie tutaj dodawac ksiazki do kolekcji i do magazynu, ale z tak duzywac metod do nich
        // czyli usunac w konstruktorach domyslnych dodawanie ksiazek w kolecji i magazynie


        Book book7 = new Book("Brent Weeks", "Nie znana", 1.0);
        Book book1 = new Book("Jakub Ćwiek", "Kłamca", 7.5);
        Book book2 = new Book("Jarosław Grzędowicz", "Pan Lodowego Ogrodu TOM 1", 8.3);
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
