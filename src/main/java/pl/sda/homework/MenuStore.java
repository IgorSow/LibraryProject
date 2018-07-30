package pl.sda.homework;

import java.util.Scanner;

public class MenuStore {


    public static void menuStore() {
        Scanner scanner = new Scanner(System.in);
        BookStore bookStore = new BookStore();

        boolean repeat = true;
        while (repeat) {
            System.out.println("10. Przyjmij partię książki na magazyn");
            System.out.println("11. Sprzedaj książkę (zdejmij z magazynu)");
            System.out.println("12. Wyświetl stan magazynowy posortowany po ilości książek (rosnąco)");
            System.out.println("13. Wyświetl stan magazynowy książek, których jest mniej niż 10 posortowanych po ilości książek (rosnąco)");
            System.out.println("14. Zakończ program");
            System.out.println();


            int chosenOption = scanner.nextInt();
            scanner.nextLine();
            switch (chosenOption) {

                case 10:
                    System.out.println("Podaj autora: ");
                    String author = scanner.nextLine();

                    System.out.println("Podaj tytul:  ");
                    String title = scanner.nextLine();

                    System.out.println("Podaj ilosc");
                    int amountOfBooks = scanner.nextInt();

                    bookStore.addBookToStorage(author, title, amountOfBooks);
                    return;

                case 11:
                    System.out.println("Podaj autora: ");
                    String author2 = scanner.nextLine();

                    System.out.println("Podaj tytul:  ");
                    String title2 = scanner.nextLine();

                    System.out.println("Podaj ilosc");
                    int amountOfBooks2 = scanner.nextInt();

                    bookStore.sellBook(author2, title2, amountOfBooks2);
                    break;

                case 12:
                    bookStore.returnSortedStorageInGrowing();
                    break;
            }
        }
    }
}