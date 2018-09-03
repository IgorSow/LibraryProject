package pl.sda.homework;

import lombok.extern.slf4j.Slf4j;
import pl.sda.homework.book.Book;
import pl.sda.homework.database.Database;
import pl.sda.homework.menu.MenuPrimary;

import java.sql.SQLException;


@Slf4j

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        log.info("PROGRAM WROTE BY IGOR SOWINSKI");

        MenuPrimary.menuPrimary();
//        String USERNAME = "root";
//        String PASSWORD = "1234";
//        String HOST = "jdbc:mysql://localhost:3306/mystorage";
//        Database myDatabase = new Database(HOST,USERNAME,PASSWORD);

//        myDatabase.connect();
//        Book book1 = new Book("Igor","jjj",10.5);
//
//        myDatabase.addBook(book1);
////        myDatabase.showBooks();

    }


}