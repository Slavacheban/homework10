package homework11;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class ListFruits {
    @JsonDeserialize(as = ArrayList.class, contentAs = Fruit.class)
    @JsonProperty(value = "fruits")
    private List<Fruit> list;
}
