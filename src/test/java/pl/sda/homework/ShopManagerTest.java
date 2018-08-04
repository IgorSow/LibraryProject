package pl.sda.homework;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import pl.sda.homework.book.Book;
import pl.sda.homework.book.BookCollection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopManagerTest {


    @Test // option 3
    void quick() {

        //given

        ShopManager shopManager = new ShopManager();


       shopManager.bookCollection.showBookCollection();
//        shopManager.bookStorage.showBookStore();

        //todo Bład konstruktora w bookCollection i bookStorage



    }


}
