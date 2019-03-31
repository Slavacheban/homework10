package homework11;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FruitShop {
    private final static Logger LOGGER = Logger.getLogger(FruitShop.class.getName());
    private List<ListFruits> fruits;
    private static final String REGEX_DATE = "dd/MM/yyyy";

    public FruitShop() {
        fruits = new ArrayList<>();
    }

    public void addFruits(String pathToJsonFile) {
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        ListFruits list = null;
        try {
            list = mapper.readValue(file, ListFruits.class);
        } catch (IOException e) {
            LOGGER.error("Not readValue in addFruits()");
        }
        fruits.add(list);
    }

    public void save(String pathToJsonFile) {
        try (FileWriter writer = new FileWriter(pathToJsonFile)){
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(writer, fruits);
        } catch (IOException e) {
            LOGGER.error("Not created FileWriter or not write in save()");
        }
    }

    public void load(String pathToJsonFile) {
        fruits.clear();
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        ListFruits list = null;
        try {
            list = mapper.readValue(file, ListFruits.class);
        } catch (IOException e) {
            LOGGER.error("Not readValue in load()");
        }
        fruits.add(list);
    }

    public List<Fruit> getSpoiledFruits(Date date) {
        List<Fruit> fruitList = new ArrayList<>();
        for (ListFruits listFruits : fruits) {
            fruitList.addAll(listFruits.getList());
        }
        List<Fruit> sort = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            SimpleDateFormat df = new SimpleDateFormat(REGEX_DATE);
            try {
                Date dateSp = df.parse(fruit.getDateDelivery());
                if (dateSp.getTime() < date.getTime()) {
                    sort.add(fruit);
                }
            } catch (ParseException e) {
                LOGGER.error("Date is invalid in getSpoiledFruit()");
            }
        }
        return sort;
    }

    public List<Fruit> getAvailableFruits(Date date) {
        List<Fruit> fruitList = new ArrayList<>();
        for (ListFruits listFruits : fruits) {
            fruitList.addAll(listFruits.getList());
        }
        List<Fruit> sort = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            SimpleDateFormat df = new SimpleDateFormat(REGEX_DATE);
            try {
                Date dateSp = df.parse(fruit.getDateDelivery());
                if (dateSp.getTime() > date.getTime()) {
                    sort.add(fruit);
                }
            } catch (ParseException e) {
                LOGGER.error("Date is invalid in getAvailableFruits");
            }
        }
        return sort;
    }

    public List<Fruit> getSpoiledFruits(Date date, Type type) {
        List<Fruit> fruitList = new ArrayList<>();
        for (ListFruits listFruits : fruits) {
            fruitList.addAll(listFruits.getList());
        }
        List<Fruit> sort = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            SimpleDateFormat df = new SimpleDateFormat(REGEX_DATE);
            try {
                Date dateSp = df.parse(fruit.getDateDelivery());
                if (dateSp.getTime() < date.getTime() && fruit.getName() == type) {
                    sort.add(fruit);
                }
            } catch (ParseException e) {
                LOGGER.error("Date is invalid in getSpoiledFruit()");
            }
        }
        return sort;
    }

    public List<Fruit> getAvailableFruits(Date date, Type type) {
        List<Fruit> fruitList = new ArrayList<>();
        for (ListFruits listFruits : fruits) {
            fruitList.addAll(listFruits.getList());
        }
        List<Fruit> sort = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            SimpleDateFormat df = new SimpleDateFormat(REGEX_DATE);
            try {
                Date dateSp = df.parse(fruit.getDateDelivery());
                if (dateSp.getTime() > date.getTime() && fruit.getName() == type) {
                    sort.add(fruit);
                }
            } catch (ParseException e) {
                LOGGER.error("Date is invalid in getAvailableFruits");
            }
        }
        return sort;
    }

}
