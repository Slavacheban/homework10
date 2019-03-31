package homework10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static boolean checkPhoneNumber(String number) {
        Pattern pattern = Pattern.compile("(\\+38)?(\\(0\\d{2}\\)|0\\d{2})\\-?" +
                "\\d{3}\\-?\\d{2}\\-?\\d{2}");
        Matcher matcher = pattern.matcher(number);
        return matcher.find();
    }

    public static boolean checkEmail(String mail) {
        Pattern pattern = Pattern.compile("\\w+\\.?\\w*\\@(mail.ru|gmail.com|yandex.ru)");
        Matcher matcher = pattern.matcher(mail);
        return matcher.find();
    }

    public static boolean checkDate(String date) {
        Pattern pattern = Pattern.compile("[0123]?\\d\\.[01]?\\d\\.([1-9]{2}|[12]\\d{3})");
        Matcher matcher = pattern.matcher(date);
        return matcher.find();
    }

    public static boolean checkIP(String ip) {
        Pattern pattern = Pattern.compile("[12]?\\d?\\d+\\.[12]?\\d?\\d+\\.[12]?\\d?\\d+\\.[12]?\\d?\\d+");
        Matcher matcher = pattern.matcher(ip);
        return matcher.find();
    }
}
