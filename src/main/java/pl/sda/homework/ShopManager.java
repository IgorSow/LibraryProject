package pl.sda.homework;

import pl.sda.homework.account.Account;
import pl.sda.homework.book.Book;
import pl.sda.homework.book.BookCollection;
import pl.sda.homework.book.BookStorage;

import java.util.List;

public class ShopManager {

    private BookCollection bookCollection;
    private BookStorage bookStorage;
    private Account account;

    public  ShopManager() {
        this.bookCollection = new BookCollection();
        this.bookStorage = new BookStorage();
        this.account = new Account();

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

        bookStorage.addBook(book1, 7);
        bookStorage.addBook(book2,1);
        bookStorage.addBook(book3, 11);
        bookStorage.addBook(book4, 22);
        bookStorage.addBook(book5, 9);
        bookStorage.addBook(book6, 47);
        bookStorage.addBook(book7, 22);
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



// import method from Collection

    public void addBookToCollection(Book newBook) {
        bookCollection.addBook(newBook);
        bookStorage.addBook(newBook,0);
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
       return bookCollection.returnAuthorsCollectionsSortedByOption(nameOfAuthor,orderOfList);
    }


    //import method from storage

    public void showBookStorage(){
        bookStorage.showBookStore();
    }
    public void addBookToStorage(String author, String title, int amountOfBooks) {
        bookStorage.addBookToStorage(author,title,amountOfBooks);
    }

    public void sellBook(String nameOfAuthor, String title2, int amountOfBooks2) {
        if (bookStorage.sellBook(nameOfAuthor,title2,amountOfBooks2) == true){
            account.addMoneyToAccount(14.55);
        }
    }

    public void returnSortedStorageInGrowing() {
        bookStorage.returnSortedStorageInGrowing();
    }


}
