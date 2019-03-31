package homework11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FruitShop {
    private List<ListFruits> fruits;

    public FruitShop() {
        fruits = new ArrayList<>();
    }

    public void addFruits(String pathToJsonFile) throws IOException {
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        ListFruits list = mapper.readValue(file, ListFruits.class);
        fruits.add(list);
    }

    public void save(String pathToJsonFile) throws IOException {
        FileWriter writer = new FileWriter(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, fruits);

    }

    public void load(String pathToJsonFile) throws IOException {
        fruits.clear();
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        ListFruits list = mapper.readValue(file, ListFruits.class);
        fruits.add(list);
    }

    public List<Fruit> getSpoiledFruits(Date date) {
        List<Fruit> fruitList = new ArrayList<>();
        for (ListFruits listFruits : fruits) {
            fruitList.addAll(listFruits.getList());
        }
        List<Fruit> sort = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date dateSp = df.parse(fruit.getDateDelivery());
                if (dateSp.getTime() < date.getTime()) {
                    sort.add(fruit);
                }
            } catch (ParseException e) {
                e.printStackTrace();
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
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date dateSp = df.parse(fruit.getDateDelivery());
                if (dateSp.getTime() > date.getTime()) {
                    sort.add(fruit);
                }
            } catch (ParseException e) {
                e.printStackTrace();
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
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date dateSp = df.parse(fruit.getDateDelivery());
                if (dateSp.getTime() < date.getTime() && fruit.getName() == type) {
                    sort.add(fruit);
                }
            } catch (ParseException e) {
                e.printStackTrace();
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
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date dateSp = df.parse(fruit.getDateDelivery());
                if (dateSp.getTime() > date.getTime() && fruit.getName() == type) {
                    sort.add(fruit);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return sort;
    }

}
