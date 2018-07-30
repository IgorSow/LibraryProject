package pl.sda.homework.menu;

import java.util.Scanner;

public class MenuAddOrder {

    public static void menuAddOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jestes w menu zamówień");
        System.out.println("1. Powrot do menu głównego");

        boolean repeat = true;
        while (repeat) {
            int chosenOption = scanner.nextInt();


            switch (chosenOption) {
                case 1:
                    repeat = false;
                    break;
            }
        }
    }
}
