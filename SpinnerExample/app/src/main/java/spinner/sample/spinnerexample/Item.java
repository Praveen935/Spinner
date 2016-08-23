package spinner.sample.spinnerexample;

import java.io.Serializable;

/**
 * Created by praveen on 17/8/16.
 */

public class Item implements Serializable {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (getId() != item.getId()) return false;
        return getName().equals(item.getName());

    }
}
