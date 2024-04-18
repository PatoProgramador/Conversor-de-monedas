package com.conversor.models;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Country> initalCountryList = new ArrayList<>(6);

    public List<Country> getInitalCountryList() {
        return initalCountryList;
    }

    public void setInitalCountryList(List<Country> countryList) {
        this.initalCountryList = countryList;
    }
}
