package homework11;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class FruitShopTest {

    @Test
    public void shouldAddFruitsAndCheckCountOfFruits() throws ParseException{
        FruitShop shop = new FruitShop();
        shop.addFruits("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        int expected = 2;
        int actual = 0;
        actual = shop.getSpoiledFruits(new SimpleDateFormat("dd.MM.yyyy")
                .parse("1.04.3000")).size();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSaveFruitsToFileAndCheck() throws IOException {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        shop.save("F:\\Slava\\homework10\\src\\test\\java\\homework11\\storageTest");
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
    }

    @Test
    public void shouldLoadFruitsAndCheckCountOfFruits() throws ParseException {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        int expected = 2;
        int actual = 0;
        actual = shop.getSpoiledFruits(new SimpleDateFormat("dd.MM.yyyy")
                .parse("1.04.3000")).size();
        assertEquals(expected, actual);
    }

    @Test
    public void spoiledAllFruitsAfterLoad() throws ParseException {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        int expected = 2;
        int actual = shop.getSpoiledFruits(new SimpleDateFormat("dd.MM.yyyy")
                .parse("1.04.3000")).size();
        assertEquals(expected, actual);
    }

    @Test
    public void availableAllFruitsAfterLoad() throws ParseException {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        int expected = 2;
        int actual = shop.getAvailableFruits(new SimpleDateFormat("dd.MM.yyyy")
                .parse("1.04.300")).size();
        assertEquals(expected, actual);
    }

    @Test
    public void spoiledBananaAfterLoad() throws ParseException {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        int expected = 1;
        int actual = shop.getSpoiledFruits(new SimpleDateFormat("dd.MM.yyyy")
                .parse("1.04.3000"), Type.BANANA).size();
        assertEquals(expected, actual);
    }

    @Test
    public void availableBananaAfterLoad() throws ParseException {
        FruitShop shop = new FruitShop();
        shop.load("F:\\Slava\\homework10\\src\\test\\java\\homework11\\deliveryTest");
        int expected = 1;
        int actual = shop.getAvailableFruits(new SimpleDateFormat("dd.MM.yyyy")
                .parse("1.04.300"), Type.BANANA).size();
        assertEquals(expected, actual);
    }

}
