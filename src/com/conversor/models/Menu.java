package com.conversor.models;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Country> initalCountryList = new ArrayList<>(List.of(
            new Country("ARS", "Peso argentino"),
            new Country("BOB", "Boliviano boliviano"),
            new Country("BRL", "Real brasileño"),
            new Country("CLP", "Peso chileno"),
            new Country("COP", "Peso colombiano"),
            new Country("USD", "Dolar estadounidense")
    ));

    private List<Country> apiCountries = new ArrayList<>();
    private String menuItems = """
            1. Hacer conversión de moneda.
            2. Ver el listado actual de monedas.
            3. Agregar una moneda al listado.
            4. Eliminar una moneda del listado.
            5. Ver tu historial de conversión de monedas.
            7. Salir""";

    public List<Country> getInitalCountryList() {
        return initalCountryList;
    }

    public String getMenuItems() {
        return menuItems;
    }

    public void showCountries(List<Country> country) {
        System.out.println("-----Lista de paises-----");
        for (int i = 0; i < country.size(); i++) {
            System.out.println( (i + 1) + "." + country.get(i));
        }
    }

    public void appFinalMessage() {
        System.out.println("¡Muchas gracias por usar el conversor de moneda!");
        System.out.println("Saliendo de la app....");
    }

    public List<Country> setInitalCountryList(Country country) {
        this.initalCountryList.add(country);
        return this.getInitalCountryList();
    }

    public List<Country> getApiCountries() {
        return apiCountries;
    }

    public void setApiCountries(List<Country> apiCountries) {
        this.apiCountries = apiCountries;
    }
}
