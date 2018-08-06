package pl.sda.homework.menu;


import lombok.extern.slf4j.Slf4j;
import pl.sda.homework.ShopManager;


import java.util.InputMismatchException;
import java.util.Scanner;
@Slf4j
public class MenuStorage {


    public static void menuStore(ShopManager shopManager) {
        Scanner scanner = new Scanner(System.in);


        boolean repeat = true;
        while (repeat) {

            log.info("1. Przyjmij partię książki na magazyn");
            log.info("2. Sprzedaj książkę (zdejmij z magazynu)");
            log.info("3. Wyświetl stan magazynowy posortowany po ilości książek (rosnąco)");
            log.info("4. Wyświetl stan magazynowy książek, których jest mniej niż 10 posortowanych po ilości książek (rosnąco)");
            log.info("5. Przejdz do menu głównego");
            System.out.println();

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
                        log.info("Podaj autora: ");
                        String author = scanner.nextLine();

                        log.info("Podaj tytul:  ");
                        String title = scanner.nextLine();

                        log.info("Podaj ilosc");
                        int amountOfBooks = scanner.nextInt();

                        shopManager.addBookToStorage(author, title, amountOfBooks);
                        return;

                    case 2:
                        log.info("Podaj autora: ");
                        String author2 = scanner.nextLine();

                        log.info("Podaj tytul:  ");
                        String title2 = scanner.nextLine();

                        log.info("Podaj ilosc");
                        int amountOfBooks2 = scanner.nextInt();

                        shopManager.sellBook(author2, title2, amountOfBooks2);
                        break;

                    case 3:
                        log.info("Posortowany magazyn ");
                        shopManager.returnSortedStorageInGrowing();
                        break;

                    case 4:
                        log.info("W PRZYGOTOWANIU");

                    case 5:
                        repeat = false;
                        break;
                    default:
                        log.info("W menu mozna wybierac tylko liczby od 1 do 5");
                }


        }
    }
}