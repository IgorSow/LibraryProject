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

    public void addBookToBasket(Book book) {
        this.basket.add(book);
    }

    public double getValueOfBasket() {
        double ret = 0;

        if (basket.size() >= 7) {
            for (int i = 0; i < basket.size(); i++) {
                ret += basket.get(i).getPrice();
                log.info("Twoja zniszka na ksiazki to 30 %");
                return ret * 0.7;
            }
        } else if (basket.size() >= 5)
            for (int i = 0; i < basket.size(); i++) {
                ret += basket.get(i).getPrice();
                log.info("Twoja zniszka na ksiazki to 20 %");
                return ret * 0.8;
            }
        else if (basket.size() >= 3)

            for (int i = 0; i < basket.size(); i++) {
                ret += basket.get(i).getPrice();
                log.info("Twoja zniszka na ksiazki to 20 %");
                return ret * 0.9;

            }
        for (int i = 0; i < basket.size(); i++) {
            ret += basket.get(i).getPrice();

        }return ret;
    }

        public int getSizeOfBasket() {
            return basket.size();
        }

        public void showBasket () {
            if (basket.isEmpty()) {
                log.info("Twój koszyk jest pusty \n");
            }

            basket.forEach(book -> System.out.println(book));
        }

        public void cleanBasket () {
            basket.clear();
        }
    }
