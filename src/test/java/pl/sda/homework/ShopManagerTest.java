package pl.sda.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShopManagerTest {


    @Test // option 3
    void shouldCheckExistingBookCollectionAndBookStored() {

        //given

        ShopManager shopManager = new ShopManager();

        //then

        assertNotNull(shopManager.getBookStorage());
        assertNotNull(shopManager.getBookCollection());



    }


}
