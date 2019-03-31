package homework11;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
public class ListFruits {
    @JsonDeserialize(as = ArrayList.class, contentAs = Fruit.class)
    @JsonProperty(value = "fruits")
    private List<Fruit> list;

    public ListFruits(List<Fruit> list) {
        this.list = list;
    }

    public ListFruits() {
    }

    public List<Fruit> getList() {
        return list;
    }

    public ListFruits setList(List<Fruit> list) {
        this.list = list;
        return this;
    }

}

