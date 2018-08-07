package pl.sda.homework.book;

import java.util.ArrayList;
import java.util.List;

public class BookBasket {
    private List<Book> basket = new ArrayList<>();

    public BookBasket() {

    }

    public List<Book> getBasket() {
        return basket;
    }

    public void addBookToBasket(Book book){
        this.basket.add(book);
    }
    public double getValueOfBasket(){
        double ret =0;

        for (int i =0; i < basket.size(); i++) {
           ret += basket.get(i).getPrice();
        }


        return ret;
    }

    public int getSizeOfBasket(){
       return basket.size();
    }

}
