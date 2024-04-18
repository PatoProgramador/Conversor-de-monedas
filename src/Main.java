import com.conversor.models.Country;
import com.conversor.models.Menu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>(List.of(
                new Country("ARS", "Peso argentino"),
                new Country("BOB", "Boliviano boliviano"),
                new Country("BRL", "Real brasileño"),
                new Country("CLP", "Peso chileno"),
                new Country("COP", "Peso colombiano"),
                new Country("USD", "Dolar estadounidense")
        ));

        Menu menu = new Menu();
        menu.setInitalCountryList(countries);

        System.out.println(menu.getInitalCountryList());
    }
}