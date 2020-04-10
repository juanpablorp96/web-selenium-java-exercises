package utils.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Data {

    public List<String> getExpectedSections(){
        return new ArrayList<>(Arrays.asList("Home Page", "World", "U.S.", "Politics", "N.Y.", "Business",
                "Opinion", "Tech", "Science", "Health", "Sports", "Arts", "Books", "Style", "Food", "Travel",
                "Magazine", "T Magazine", "Real Estate", "Obituaries", "Video", "The Upshot", "More"));
    }

}
