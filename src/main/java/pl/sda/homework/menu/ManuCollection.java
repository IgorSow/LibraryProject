package pl.sda.homework.menu;

import pl.sda.homework.book.Book;

import pl.sda.homework.book.BookCollection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManuCollection {

    public static void menuCollection() {
        Scanner scanner = new Scanner(System.in);
        BookCollection bookCollection = new BookCollection();

        boolean repeat = true;
        while (repeat) {
            System.out.println("Wybierz opcje");
            System.out.println("1. Wyświetl kolekcje książek (bez jakiegokolwiek sortowania)");
            System.out.println("2. Dodaj książkę do kolekcji");
            System.out.println("3. Usuń książkę z kolekcji");
            System.out.println("4. Usuń wszystkie książki autora z kolekcji");
            System.out.println("5. Wyświetl kolekcje książek posortowaną po tytule");
            System.out.println("6. Wyświetl kolekcje książek posortowaną po autorze");
            System.out.println("7. Wyświetl kolekcje książek posortowaną od najlepsze do najgorszej");
            System.out.println("8. Wyświet wszystkie kolekcje książek podanego autora posortowane po tytule");
            System.out.println("9. Wyświet wszystkie kolekcje książek podanego autora posortowane po ocenie");
            System.out.println("10. Wyświetl wszystkie kolekcji książek - z filtrem po tytule");
            System.out.println("11. Powrót do menu głównego");
            System.out.println();

            int chosenOption =0;
            try {
                chosenOption = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("W menu mozna wybierac tylko liczby od 1 do 10");
                scanner.next();
            }
            scanner.nextLine();

            switch (chosenOption) {

                case 1:
                    bookCollection.showBookCollection();
                    break;

                case 2:
                    System.out.println("Wprowadź nową książkę w formacie: Autor, Tytuł, ocena");
                    // TODO zadanie dodatkowe sprawić by można było dodać książkę bez oceny

                    String[] chopedBook = scanner.nextLine().split(",");
                    Book newBook;

                    if (chopedBook[2] == null) {
                        newBook = new Book(chopedBook[0], chopedBook[1]);
                    } else {
                        newBook = new Book(chopedBook[0], chopedBook[1], Double.parseDouble(chopedBook[2]));
                    }
                    bookCollection.addBook(newBook);
                    break;

                case 3:

                    System.out.println("Podaj nazwe ksiazki aby usunac z kolekcji");
                    bookCollection.showBookCollection();
                    String bookToRemove = scanner.nextLine();
                    bookCollection.removeBookByTitle(bookToRemove);
                    break;

                case 4:
                    bookCollection.showBookCollection();
                    System.out.println("Podaj Imie i nazwisko autora, ktorego chcesz usunac : ");
                    String authorToRemover = scanner.nextLine();
                    bookCollection.removeAllBooksOfAuthor(authorToRemover);
                    bookCollection.showBookCollection();
                    break;

                case 5:
                    System.out.println("Kolekcje książek posortowaną po tytule");
                    bookCollection.returnBooksSortedByTitle();
                    break;

                case 6:
                    System.out.println("Kolekcje książek posortowaną po autorze");
                    bookCollection.returnBooksSortedByAuthor();
                    break;

                case 7:
                    System.out.println("Wyświetl kolekcje książek posortowaną od najlepsze do najgorszej");
                    bookCollection.returnBooksSortedByRating();
                    break;

                case 8:
                    bookCollection.showBookCollection();
                    System.out.println("Podaj autora, ktorego ksiazki chcesz wyswietlic: ");
                    String authorToReviewByTitle = scanner.nextLine();
                    System.out.println("Kolekcje książek podanego autora posortowane po tytule");
                    System.out.println(bookCollection.returnAuthorsCollectionsSortedByOption
                            (authorToReviewByTitle, bookCollection.returnBooksSortedByTitle()));
                    break;

                case 9:

                    System.out.println("Podaj autora, ktorego ksiazki chcesz wyswietlic: ");
                    String authorToReviewByRating = scanner.nextLine();
                    System.out.println("Kolekcje książek podanego autora posortowane od najlepszej do najgorszej");
                    System.out.println(bookCollection.returnAuthorsCollectionsSortedByOption
                            (authorToReviewByRating, bookCollection.returnBooksSortedByRating()));
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
