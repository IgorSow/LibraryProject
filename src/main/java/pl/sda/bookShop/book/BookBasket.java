package pl.sda.bookShop.book;

import java.util.List;

public class BookBasket {
    private List<Book> basket;

    public BookBasket() {

    }

    public List<Book> getBasket() {
        return basket;
    }

    public void addBookToBasket(Book book){
        basket.add(book);
    }

}
