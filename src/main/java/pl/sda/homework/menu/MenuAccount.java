package pl.sda.homework.menu;

import lombok.extern.slf4j.Slf4j;
import pl.sda.homework.ShopManager;

import java.util.Scanner;

@Slf4j
public class MenuAccount {

    public static void menuAccount(ShopManager shopManager) {
        Scanner scanner = new Scanner(System.in);


        boolean repeat = true;
        while (repeat) {
            log.info("Jestes w menu konta");
            log.info("1. Podaj wartość konta");
            log.info("2. Cofnij do menu głównego");


            int chosenOption = 0;
            try {
                chosenOption = scanner.nextInt();
            } catch (Exception a) {
                log.error("W menu mozna wybierac tylko liczby od 1 do 2");
                scanner.next();
            }
            switch (chosenOption) {
                case 1:
                    log.info("Stan konta: " + shopManager.getAccountBalance() + "\n");

                    break;
                case 2:
                    repeat = false;
                    break;

            }
        }
    }
}