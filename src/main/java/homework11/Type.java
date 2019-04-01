package homework11;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Type {
    @JsonProperty(value = "Apple")
    APPLE,
    @JsonProperty(value = "Pear")
    PEAR,
    @JsonProperty(value = "Melon")
    MELON,
    @JsonProperty(value = "Watermelon")
    WATERMELON,
    @JsonProperty(value = "Lemon")
    LEMON,
    @JsonProperty(value = "Banana")
    BANANA,
    @JsonProperty(value = "Pineapple")
    PINEAPPLE,
    @JsonProperty(value = "Coconut")
    COCONUT,
    @JsonProperty(value = "Lime")
    LIME,
    @JsonProperty(value = "Plum")
    PLUM
}
