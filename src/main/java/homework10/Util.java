package homework10;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
     public static Logger logger = Logger.getLogger(Util.class.getName());

    public static void main(String[] args) {
        List<Map<List<Set<Integer>>, String>> list = new ArrayList<Map<List<Set<Integer>>, String>>();
        Set<Integer> set = new HashSet<Integer>();
        set.add(5);
        set.add(6);

        List<Set<Integer>> setList = new ArrayList<Set<Integer>>();
        setList.add(set);

        Map<List<Set<Integer>>, String> map = new HashMap<List<Set<Integer>>, String>();
        map.put(setList, "Slava");
        map.put(setList, "Cheban");

        list.add(map);
        try {
            Util.wrightListToXML(list);
        } catch (IOException e) {
            logger.info("something not right");
        }
    }

    public static void wrightListToXML(List list) throws IOException{
        XmlMapper xmlMapper = new XmlMapper();
        FileWriter writer = new FileWriter("writeXMLHere.xml");
        xmlMapper.writeValue(writer, list);
    }

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

    public static boolean checkIP (String ip) {
        Pattern pattern = Pattern.compile("[12]?\\d?\\d+\\.[12]?\\d?\\d+\\.[12]?\\d?\\d+\\.[12]?\\d?\\d+");
        Matcher matcher = pattern.matcher(ip);
        return matcher.find();
    }

}
