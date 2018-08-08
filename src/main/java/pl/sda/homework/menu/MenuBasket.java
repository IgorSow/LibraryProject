package pl.sda.homework.menu;

import lombok.extern.slf4j.Slf4j;
import pl.sda.homework.ShopManager;
import pl.sda.homework.book.Book;

import java.util.InputMismatchException;
import java.util.Scanner;

@Slf4j
public class MenuBasket {

    public static void menuOrder(ShopManager shopManager) {
        Scanner scanner = new Scanner(System.in);
//        BookBasket basket = new ArrayList<Book>();
//        List<Book> bookList = new ArrayList<>();

        boolean repeat = true;
        while (repeat) {

        log.info("Jestes w menu zamówień / koszyk");
        log.info("1. Wyswietl dostępne książki w sklepie");
        log.info("2. Podaj ktora ksiazke chcesz dodac do koszyka");
        log.info("3. Wyświetl obcje rabatowe i ile pozostało do konkretnej promocji");
        log.info("4. Zamknij koszyk i złóz zamówienie ");
        log.info("5. Wyświetl zawartość koszyka");
        log.info("6. Powrot do menu głównego");




            int chosenOption =0;
            try {
                chosenOption = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.error("W menu mozna wybierac tylko liczby od 1 do 6");
                scanner.next();
            }
            scanner.nextLine();
            switch (chosenOption) {
                case 1:
                    shopManager.showBookStorage();
                    break;
                case 2:

                    log.info("Przykladowe ksiazki dodane");
                    Book book = new Book("Jakub Ćwiek", "Kłamca");
                    Book book2 = new Book("Jakub Ćwiek", "Kłamca");

                   shopManager.addBookToBasket(book);
                   shopManager.addBookToBasket(book2);
                   break;

                case 3:
                    shopManager.showDiscounts();
                    break;

                case 4:
                    shopManager.closeBasketAndFinalizeOrder();
                    break;
                case 5:
                    shopManager.showBasket();
                    break;

                case 6:
                    repeat = false;
                    break;
            }
        }
    }
}
