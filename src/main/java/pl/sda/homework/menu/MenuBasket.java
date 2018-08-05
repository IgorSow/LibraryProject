package pl.sda.homework.menu;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class MenuBasket {

    public static void menuBasket() {
        Scanner scanner = new Scanner(System.in);

        log.info("Jestes w menu zamówień");
        log.info("1. Powrot do menu głównego");

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
