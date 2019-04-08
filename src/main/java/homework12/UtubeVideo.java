package homework12;

import com.google.api.client.util.Lists;
import lombok.Getter;

import java.util.List;

@Getter
public class UtubeVideo {
    private List<Comment> comments = Lists.newArrayList();
}
