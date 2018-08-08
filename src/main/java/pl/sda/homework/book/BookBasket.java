package pl.sda.homework.book;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    public void showBasket() {
        if (basket.isEmpty()){
            log.info("Twój koszyk jest pusty \n");
        }

        basket.forEach(book -> System.out.println(book));
    }

    public void cleanBasket() {
        basket.clear();
    }
}
