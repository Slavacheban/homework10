package homework11;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class FruitShopTest {

    @Test
    public void shouldAddFruitsAndCheckCoundOfFruits() {
        FruitShop shop = new FruitShop();
        shop.addFruits("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        int expected = 2;
        int actual = 0;
        try {
            actual = shop.getSpoiledFruits(new SimpleDateFormat("dd.MM.yyyy")
                    .parse("1.04.3000")).size();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSaveFruitsToFileAndCheck() {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        shop.save("F:\\Slava\\homework10\\src\\test\\java\\homework11\\storageTest");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("F:\\Slava" +
                    "\\homework10\\src\\test\\java\\homework11\\storageTest"));
            StringBuilder sb = new StringBuilder();
            String s = null;
            while ((s = reader.readLine()) != null) {
                sb.append(s);
            }
            String expected = "[{\"fruits\":[{\"type\":\"BANANA\",\"shelfLife\":10,\"date\":\"" +
                    "10/07/2017\",\"price\":100},{\"type\":\"APPLE\",\"shelfLife\":5,\"" +
                    "date\":\"10/07/2017\",\"price\":70}]}]";
            String actual = sb.toString();
            assertEquals(expected, actual);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldLoadFruitsAndCheckCountOfFruits() {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        int expected = 2;
        int actual = 0;
        try {
            actual = shop.getSpoiledFruits(new SimpleDateFormat("dd.MM.yyyy")
                    .parse("1.04.3000")).size();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    public void spoiledAllFruitsAfterLoad() {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        try {
            int expected = 2;
            int actual = shop.getSpoiledFruits(new SimpleDateFormat("dd.MM.yyyy")
                    .parse("1.04.3000")).size();
            assertEquals(expected, actual);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void availableAllFruitsAfterLoad() {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        try {
            int expected = 2;
            int actual = shop.getAvailableFruits(new SimpleDateFormat("dd.MM.yyyy")
                    .parse("1.04.300")).size();
            assertEquals(expected, actual);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void spoiledBananaAfterLoad() {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        try {
            int expected = 1;
            int actual = shop.getSpoiledFruits(new SimpleDateFormat("dd.MM.yyyy")
                    .parse("1.04.3000"), Type.BANANA).size();
            assertEquals(expected, actual);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void availableBananaAfterLoad() {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        try {
            int expected = 1;
            int actual = shop.getAvailableFruits(new SimpleDateFormat("dd.MM.yyyy")
                    .parse("1.04.300"), Type.BANANA).size();
            assertEquals(expected, actual);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
