package homework10;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void checkPhoneNumber() {
        boolean f = Util.checkPhoneNumber("+38(063)-169-42-77");
        boolean s = Util.checkPhoneNumber("+38(063)-169-42-77");
        assertTrue(f);
        assertTrue(s);
    }

    @Test
    public void checkEmail() {
        boolean f = Util.checkEmail("cheban.sl@mail.ru");
        boolean s = Util.checkEmail("Slavacheban22@gmail.com");
        assertTrue(f);
        assertTrue(s);
    }

    @Test
    public void checkDate() {
        boolean f = Util.checkDate("1.02.12");
        boolean s = Util.checkDate("03.04.1993");
        assertTrue(f);
        assertTrue(s);
    }

    @Test
    public void checkIP() {
        boolean f = Util.checkIP("223.222.0.74");
        boolean s = Util.checkIP("225.0.0.0");
        assertTrue(f);
        assertTrue(s);
    }
}