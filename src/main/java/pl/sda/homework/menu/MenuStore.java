package pl.sda.homework.menu;

import pl.sda.homework.BookStore;

import java.util.Scanner;

public class MenuStore {


    public static void menuStore() {
        Scanner scanner = new Scanner(System.in);
        BookStore bookStore = new BookStore();

        boolean repeat = true;
        while (repeat) {
            System.out.println("1. Przyjmij partię książki na magazyn");
            System.out.println("2. Sprzedaj książkę (zdejmij z magazynu)");
            System.out.println("3. Wyświetl stan magazynowy posortowany po ilości książek (rosnąco)");
            System.out.println("4. Wyświetl stan magazynowy książek, których jest mniej niż 10 posortowanych po ilości książek (rosnąco)");
            System.out.println("5. Przejdz do menu głównego");
            System.out.println();


            int chosenOption = scanner.nextInt();
            scanner.nextLine();
            switch (chosenOption) {

                case 1:
                    System.out.println("Podaj autora: ");
                    String author = scanner.nextLine();

                    System.out.println("Podaj tytul:  ");
                    String title = scanner.nextLine();

                    System.out.println("Podaj ilosc");
                    int amountOfBooks = scanner.nextInt();

                    bookStore.addBookToStorage(author, title, amountOfBooks);
                    return;

                case 2:
                    System.out.println("Podaj autora: ");
                    String author2 = scanner.nextLine();

                    System.out.println("Podaj tytul:  ");
                    String title2 = scanner.nextLine();

                    System.out.println("Podaj ilosc");
                    int amountOfBooks2 = scanner.nextInt();

                    bookStore.sellBook(author2, title2, amountOfBooks2);
                    break;

                case 3:
                    bookStore.returnSortedStorageInGrowing();
                    break;

                case 5:
                    repeat = false;
                    break;
            }
        }
    }
}