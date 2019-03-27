package homework10;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void checkPhoneNumber() {
        boolean expected = true;
        boolean actualF = Util.checkPhoneNumber("+38(063)-579-42-77");
        boolean actualS = Util.checkPhoneNumber("063-579-42-77");
        assertEquals(expected, actualF);
        assertEquals(expected, actualS);
    }

    @Test
    public void checkEmail() {
        boolean expected = true;
        boolean actualF = Util.checkEmail("cheban.sl@mail.ru");
        boolean actualS = Util.checkEmail("slavacheban22@gmail.com");
        assertEquals(expected, actualF);
        assertEquals(expected, actualS);
    }

    @Test
    public void checkDate() {
        boolean expected = true;
        boolean actualF = Util.checkDate("1.12.89");
        boolean actualS = Util.checkDate("04.04.1993");
        assertEquals(expected, actualF);
        assertEquals(expected, actualS);
    }

    @Test
    public void checkIP() {
        boolean expected = true;
        boolean actualF = Util.checkIP("225.225.89.224");
        boolean actualS = Util.checkIP("0.0.199.235");
        assertEquals(expected, actualF);
        assertEquals(expected, actualS);
    }

}