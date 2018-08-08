package pl.sda.bookShop;


import org.junit.jupiter.api.Test;
import pl.sda.homework.ShopManager;
import pl.sda.homework.book.Book;

import static org.junit.jupiter.api.Assertions.*;

public class BookBasketTest {

    @Test
    void shouldReturnOneBookInBasket() {
        //given
        ShopManager bookBasket = new ShopManager();

        //when
        Book book = new Book("Brent Weeks", "Nie znana", 1.0);
        bookBasket.addBookToBasket(book);

        //then
        assertEquals(1, bookBasket.getSizeOfBasket());

    }

    @Test
    void shouldReturnOneBookInBasketUsingOrdialNumber() {
        //given
        ShopManager bookBasket = new ShopManager();

        //when

        bookBasket.addBookToBasketByChoseNumber(2);

        //then
        assertEquals(1, bookBasket.getSizeOfBasket());
    }

    @Test
    void shouldCloseBasketAndAddMoneyToAccount() {
        //given
        ShopManager acctual = new ShopManager();
        ShopManager afterShoping = new ShopManager();

        double acctualAccount = acctual.getAccountBalance();



        afterShoping.addBookToBasketByChoseNumber(2);

        //then
        afterShoping.closeBasketAndFinalizeOrder();
        double afterShopingAccount = afterShoping.getAccountBalance();

        //then

         assertNotEquals(afterShoping,acctual);
         assertNotEquals(acctualAccount,afterShopingAccount);

    }

}
