package homework11;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@JsonAutoDetect
@Getter
@Setter
@AllArgsConstructor
public class Fruit {
    @JsonProperty(value="type")
    private Type name;
    @JsonProperty(value="shelfLife")
    private int expirationDate;
    @JsonProperty(value="date")
    private Date dateDelivery;
    @JsonProperty(value="price")
    private int price;

    public Fruit() {
    }
}
