package pl.sda.homework;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

import static pl.sda.homework.menu.MenuPrimary.menuPrimary;


@Slf4j
public class Main {
    public static void main(String[] args) {

        log.info("PROGRAM WROTE BY IGOR SOWINSKI");
        Scanner scanner = new Scanner(System.in);

        menuPrimary();
    }
}