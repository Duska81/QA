package models;

import java.util.List;

public class Row {
    private List<String> data;

    public Row(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
