package homework11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

    public void save(String pathToJsonFile) throws IOException{
        FileWriter writer = new FileWriter(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, fruits);

    }

    public void load(String pathToJsonFile) throws IOException{
        fruits.clear();
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        ListFruits list = mapper.readValue(file, ListFruits.class);
        fruits.add(list);
    }

    public List<Fruit> getSpoiledFruits(Date date) {
        return null;
    }

    public List<Fruit> getAvailableFruits(Date date) {
        return null;
    }

}
