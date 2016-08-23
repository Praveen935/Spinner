package spinner.sample.spinnerexample;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by praveen on 23/8/16.
 */

public class ItemList {

    @SerializedName("item")
    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    public static ItemList parseDate(String data){
        Gson gson = new Gson();
        return gson.fromJson(data, ItemList.class);
    }
}
