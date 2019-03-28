package homework10;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class UtilXML {
    public static Logger logger = Logger.getLogger(UtilXML.class.getName());

    public static void wrightListToXML(List list) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            FileWriter writer = new FileWriter("writeXMLHere.xml");
            xmlMapper.writeValue(writer, list);
        } catch (IOException e) {
            logger.info("something not right");
        }
    }

}
