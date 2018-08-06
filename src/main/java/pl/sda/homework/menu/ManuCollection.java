package pl.sda.homework.menu;

import lombok.extern.slf4j.Slf4j;
import pl.sda.homework.Main;
import pl.sda.homework.ShopManager;
import pl.sda.homework.book.Book;
import pl.sda.homework.book.BookCollection;

import java.util.InputMismatchException;
import java.util.Scanner;

@Slf4j
public class ManuCollection {

    public static void menuCollection(ShopManager shopManager ) {
        Scanner scanner = new Scanner(System.in);


        boolean repeat = true;
        while (repeat) {
            log.info("Wybierz opcje");
            log.info("1. Wyświetl kolekcje książek (bez jakiegokolwiek sortowania)");
            log.info("2. Dodaj książkę do kolekcji");
            log.info("3. Usuń książkę z kolekcji");
            log.info("4. Usuń wszystkie książki autora z kolekcji");
            log.info("5. Wyświetl kolekcje książek posortowaną po tytule");
            log.info("6. Wyświetl kolekcje książek posortowaną po autorze");
            log.info("7. Wyświetl kolekcje książek posortowaną od najlepsze do najgorszej");
            log.info("8. Wyświet wszystkie kolekcje książek podanego autora posortowane po tytule");
            log.info("9. Wyświet wszystkie kolekcje książek podanego autora posortowane po ocenie");
            log.info("10. Wyświetl wszystkie kolekcji książek - z filtrem po tytule");
            log.info("11. Powrót do menu głównego");
            log.info("");

            int chosenOption =0;
            try {
                chosenOption = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.info("W menu mozna wybierac tylko liczby od 1 do 10");
                scanner.next();
            }
            scanner.nextLine();

            switch (chosenOption) {

                case 1:
                    shopManager.getBookCollection().showBookCollection();
                    break;

                case 2:
                    log.info("Wprowadź nową książkę w formacie: Autor, Tytuł, ocena");
                    // TODO zadanie dodatkowe sprawić by można było dodać książkę bez oceny

                    String[] chopedBook = scanner.nextLine().split(",");
                    Book newBook;

                    if (chopedBook[2] == null) {
                        newBook = new Book(chopedBook[0], chopedBook[1]);
                    } else {
                        newBook = new Book(chopedBook[0], chopedBook[1], Double.parseDouble(chopedBook[2]));
                    }
                    shopManager.addBookToCollection(newBook);
                    break;

                case 3:

                    log.info("Podaj nazwe ksiazki aby usunac z kolekcji");
                    shopManager.showBookCollection();
                    String bookToRemove = scanner.nextLine();
                    shopManager.removeBookByTitle(bookToRemove);
                    break;

                case 4:
                    shopManager.showBookCollection();
                    log.info("Podaj Imie i nazwisko autora, ktorego chcesz usunac : ");
                    String authorToRemover = scanner.nextLine();
                    shopManager.removeAllBooksOfAuthor(authorToRemover);
                    shopManager.showBookCollection();
                    break;

                case 5:
                    log.info("Kolekcje książek posortowaną po tytule");
                    shopManager.returnBooksSortedByTitle();
                    break;

                case 6:
                    log.info("Kolekcje książek posortowaną po autorze");
                    shopManager.returnBooksSortedByAuthor();
                    break;

                case 7:
                    log.info("Wyświetl kolekcje książek posortowaną od najlepsze do najgorszej");
                    shopManager.returnBooksSortedByRating();
                    break;

                case 8:
                    shopManager.showBookCollection();
                    log.info("Podaj autora, ktorego ksiazki chcesz wyswietlic: ");
                    String authorToReviewByTitle = scanner.nextLine();
                    log.info("Kolekcje książek podanego autora posortowane po tytule");
                    System.out.println(shopManager.returnAuthorsCollectionsSortedByOption
                            (authorToReviewByTitle, shopManager.returnBooksSortedByTitle()));
                    break;

                case 9:

                    System.out.println("Podaj autora, ktorego ksiazki chcesz wyswietlic: ");
                    String authorToReviewByRating = scanner.nextLine();
                    System.out.println("Kolekcje książek podanego autora posortowane od najlepszej do najgorszej");
                    System.out.println(shopManager.returnAuthorsCollectionsSortedByOption
                            (authorToReviewByRating, shopManager.returnBooksSortedByRating()));
                    break;

                case 10:
                    System.out.println("Opcja w przygotowaniu");

                case 11:
                    repeat = false;
                    break;
                default:
                    System.out.println("W menu mozna wybierac tylko liczby od 1 do 10");
            }
        }

    }
}
