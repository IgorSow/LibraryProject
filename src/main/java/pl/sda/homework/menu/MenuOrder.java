package pl.sda.homework.menu;

import lombok.extern.slf4j.Slf4j;
import pl.sda.homework.ShopManager;
import pl.sda.homework.book.Book;

import java.util.InputMismatchException;
import java.util.Scanner;

@Slf4j
public class MenuOrder {

    public static void MenuOrder(ShopManager shopManager) {
        Scanner scanner = new Scanner(System.in);
//        BookBasket basket = new ArrayList<Book>();
//        List<Book> bookList = new ArrayList<>();


        log.info("Jestes w menu zamówień / koszyk");
        log.info("1. Wyswietl dostępne książki");
        log.info("2. Podaj ktora ksiazke chcesz dodac do koszyka");
        log.info("3. Wyświetl obcje rabatowe i ile pozostało do konkretnej promocji");
        log.info("4. Zamknij koszyk i złóz zamówienie ");
        log.info("5. Powrot do menu głównego");


        boolean repeat = true;
        while (repeat) {

            int chosenOption =0;
            try {
                chosenOption = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.error("W menu mozna wybierac tylko liczby od 1 do 5");
                scanner.next();
            }
            scanner.nextLine();
            switch (chosenOption) {
                case 1:
                    shopManager.showBookStorage();

                case 2:
                    Book book = new Book("Jakub Ćwiek", "Kłamca");
                    Book book2 = new Book("Jakub Ćwiek", "Kłamca");

                   shopManager.addBookToBasket(book);
                   shopManager.addBookToBasket(book2);

                case 3:
                    shopManager.showDiscounts();

                case 4:
                    shopManager.closeBasketAndFinalizeOrder();

                case 5:
                    repeat = false;
                    break;
            }
        }
    }
}
