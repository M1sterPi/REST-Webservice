package com.example.restservice;
import java.util.List;

public class Address {
    private List<String> colorKeys;
    private List<Integer> values;

    public List<String> getColorKeys() {
        return colorKeys;
    }

    public void setColorKeys(List<String> colorKeys) {
        this.colorKeys = colorKeys;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}