import com.conversor.models.ConsultAPI;
import com.conversor.models.Country;
import com.conversor.models.CurrencyPairConversion;
import com.conversor.models.Menu;
import com.conversor.models.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        String options = menu.getMenuItems();
        menu.setInitalCountryList(countries);
        Scanner input = new Scanner(System.in);

        System.out.println("¡Bienvenidx a la aplicación de conversión moneda!");
        int option = 0;
        while (option != 7) {
            Validator validate = new Validator();
            ConsultAPI consulter = new ConsultAPI();
            System.out.println(options);
            System.out.println("Por favor selecciona una opción valida: ");
            option = input.nextInt();
            // hacer conversion
            if (option == 1) {
                CurrencyPairConversion currencyPairConversion = new CurrencyPairConversion();
                menu.showCountries();
                System.out.println("Selecciona la moneda base (Por ej. 1): ");
                // validacion de error
                validate.setBaseIndex(input.nextInt());
                validate.setMaxIndex(6);
                validate.setMinIndex(1);
                int baseIndex = validate.validateInputMintoMax(input);
                // Busqueda y asignacion del codigo del pais base
                Country userCountryBase = countries.get(baseIndex - 1);
                currencyPairConversion.setBaseCode(userCountryBase.getCode());
                // Busqueda y asignacion del codigo del pais target
                System.out.println("Selecciona la moneda a la cual deseas cambiar el monto: ");
                // validacion de error
                validate.setTargetIndex(input.nextInt());
                int targetIndex = validate.validateInputMintoMax(input);
                targetIndex = validate.validateBaseTargetIndexNotEquals(input);
                Country userCountryTarget = countries.get(targetIndex - 1);
                currencyPairConversion.setTargetCode(userCountryTarget.getCode());
                // Monto a transformar
                System.out.printf("Ingresa el monto que deseas convertir de '%s' a '%s': %n", currencyPairConversion.getBaseCode(), currencyPairConversion.getTargetCode());
                double userAmount = input.nextDouble();
                currencyPairConversion.setAmount(userAmount);
                // Operacion con la API
                consulter.exchangeCurrencyPair(currencyPairConversion);
                // Imprimir final
                System.out.println(currencyPairConversion);
                System.out.println("******************************************************************************************");
            }
//            else if (option == 2 ) {
//
//            }
        }

    }
}