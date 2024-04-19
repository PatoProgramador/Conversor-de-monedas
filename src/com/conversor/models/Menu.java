package com.conversor.models;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Country> initalCountryList = new ArrayList<>(6);

    private String menuItems = """
            1. Hacer conversión de moneda.
            2. Cambiar una moneda de la lista de disponibles.
            7. Salir""";

    public List<Country> getInitalCountryList() {
        return initalCountryList;
    }

    public String getMenuItems() {
        return menuItems;
    }

    public void showCountries() {
        System.out.println("Lista de paises disponibles: ");

        for (int i = 0; i < initalCountryList.size(); i++) {
            System.out.println( (i + 1) + "." + initalCountryList.get(i));
        }
    }

    public void setInitalCountryList(List<Country> countryList) {
        this.initalCountryList = countryList;
    }
}
