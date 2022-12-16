package fullapp.stockprojecttwo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MyTableRow {

    private SimpleStringProperty name;
    private SimpleIntegerProperty value;
    private SimpleBooleanProperty tag;

    public MyTableRow(String name, int value, boolean tag) {
        this.name = new SimpleStringProperty();
        this.value = new SimpleIntegerProperty();
        this.tag = new SimpleBooleanProperty();
        this.name.set(name);
        this.value.set(value);
        this.tag.set(tag);
    }

    public String getName() {
        return name.get();
    }

    public int getValue() {
        return value.get();
    }

    public boolean getTag() {
        return tag.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setValue(int value) {
        this.value.set(value);
    }

    public void setTag(boolean tag) {
        this.tag.set(tag);
    }
}