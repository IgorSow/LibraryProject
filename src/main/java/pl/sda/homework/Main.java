package pl.sda.homework;

import lombok.extern.slf4j.Slf4j;
import pl.sda.homework.menu.MenuPrimary;


@Slf4j

public class Main {
    public static void main(String[] args) {

        log.info("PROGRAM WROTE BY IGOR SOWINSKI");


        MenuPrimary.menuPrimary();
    }



}