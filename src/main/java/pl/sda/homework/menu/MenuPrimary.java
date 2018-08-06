package pl.sda.homework.menu;

import lombok.extern.slf4j.Slf4j;
import pl.sda.homework.ShopManager;

import java.util.Scanner;

import static pl.sda.homework.menu.ManuCollection.menuCollection;
import static pl.sda.homework.menu.MenuOrder.MenuOrder;
import static pl.sda.homework.menu.MenuStorage.menuStore;

@Slf4j
public class MenuPrimary {

    public static void menuPrimary() {
        Scanner scanner = new Scanner(System.in);
        ShopManager shopManager = new ShopManager();

        boolean repeat = true;
        while (repeat) {
            log.info("Jestes w menu glównym");
            log.info("1. Przejdz do menu kolekcji");
            log.info("2. Przejdz do menu magazynu");
            log.info("3. Przejdz do menu zamówień/sklepu");

            int chosenOption = 0;
            try {
                chosenOption = scanner.nextInt();
            } catch (Exception a) {
                log.error("W menu mozna wybierac tylko liczby od 1 do 3");
                scanner.next();
            }

            switch (chosenOption) {
                case 1:
                    menuCollection(shopManager);
                    break;
                case 2:
                    menuStore(shopManager);
                    break;
                case 3:
                    MenuOrder(shopManager);
                    break;
                default:
                    System.out.println("W menu mozna wybierac tylko liczby od 1 do 3");
            }

        }
    }

}

