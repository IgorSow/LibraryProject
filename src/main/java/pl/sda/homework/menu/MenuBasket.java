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
            log.info("2. Podaj autora i tytuł ksiązki, która chcesz kupic");
            log.info("3. Podaj numer pozadkowy ksiazki, który chcesz dodac do koszyka");
            log.info("4. Wyświetl obcje rabatowe i ile pozostało do konkretnej promocji");
            log.info("5. Zamknij koszyk i złóz zamówienie ");
            log.info("6. Wyświetl zawartość koszyka");
            log.info("7. Powrot do menu głównego");


            int chosenOption = 0;
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
                    log.info("Podaj autora");
                    String[] bookToAddToBasket = scanner.nextLine().split(",");
                    Book book = new Book(bookToAddToBasket[0], bookToAddToBasket[1]);
                    shopManager.addBookToBasket(book);

                    break;
                case 3:
                    log.info("Podaj numer pożadkowy ksiązki do kupna");
                    shopManager.addBookToBasketByChoseNumber(scanner.nextInt());

                case 4:
                    shopManager.showDiscounts();
                    break;
                case 5:
                    shopManager.closeBasketAndFinalizeOrder();
                    break;
                case 6:
                    shopManager.showBasket();
                    break;

                case 7:
                    repeat = false;
                    break;
                default:
                    log.error("W menu mozna wybierac tylko liczby od 1 do 6");
            }
        }
    }
}
