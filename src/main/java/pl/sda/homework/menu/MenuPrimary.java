package pl.sda.homework.menu;

import java.util.Scanner;

import static pl.sda.homework.menu.ManuCollection.menuCollection;
import static pl.sda.homework.menu.MenuBasket.menuBasket;
import static pl.sda.homework.menu.MenuStorage.menuStore;

public class MenuPrimary {

    public static void menuPrimary() {
        Scanner scanner = new Scanner(System.in);


        boolean repeat = true;
        while (repeat) {
            System.out.println("Jestes w menu glównym");
            System.out.println("1. Przejdz do menu kolekcji");
            System.out.println("2. Przejdz do menu magazynu");
            System.out.println("3. Przejdz do menu zamówień/sklepu");

            int chosenOption = 0;
            try {
                chosenOption = scanner.nextInt();
            } catch (Exception a) {
                System.out.println("W menu mozna wybierac tylko liczby od 1 do 3");
                scanner.next();
            }

            switch (chosenOption) {
                case 1:
                    menuCollection();
                    break;
                case 2:
                    menuStore();
                    break;
                case 3:
                    menuBasket();
                    break;
                default:
                    System.out.println("W menu mozna wybierac tylko liczby od 1 do 3");
            }

        }
    }

}

