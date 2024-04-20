import com.conversor.models.ConsultAPI;
import com.conversor.models.Country;
import com.conversor.models.CurrencyPairConversion;
import com.conversor.models.Menu;
import com.conversor.models.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppHandler extends Menu {
    private final Scanner userInput = new Scanner(System.in);
    CurrencyPairConversion currencyPairConversion = new CurrencyPairConversion();
    private Validator validate = new Validator();
    ConsultAPI consulter = new ConsultAPI();
    private List<Country> apiCountries = new ArrayList<>();
    private int option = 0;
    private int apiCalls = 0;

    public void firstOption() {
        while (this.getOption() == 1) {
            System.out.println("******************************************************************************************");
            // lista actual de paises y scanner
            List<Country> countries = this.getInitalCountryList();
            Scanner input = this.getInput();
            this.showCountries();
            // opciones iniciales para el validador: Los paises se lista de 1 al maximo de la lista/ inicialmente hasta 6
            validate.setMaxIndex(countries.size());
            validate.setMinIndex(1);
            System.out.println("Selecciona la moneda base (Por ej. 1): ");
            // validacion de error: El validator recibe el input para setearse
            validate.setBaseIndex(input.nextInt());
            int baseIndex = validate.validateInputMintoMax(input);
            // Busqueda y asignacion del codigo del pais base
            Country userCountryBase = countries.get(baseIndex - 1);
            currencyPairConversion.setBaseCode(userCountryBase.getCode());
            // Busqueda y asignacion del codigo del pais target
            System.out.println("Selecciona la moneda a la cual deseas cambiar el monto: ");
            // validacion de error en el segundo caso
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
            System.out.println("******************************************************************************************");
            System.out.println(currencyPairConversion);
            System.out.println("******************************************************************************************");
            // continuidad de la opción
            System.out.println("¿Deseas realizar otra conversión de moneda? 'S' para continuar o 'N' para regresar al menu inicial: ");
            validate.setDecision(input.next());
            // se setea la opcion entre 1 y 0 dependiendo la validacion
            setOption(validate.validateUserDecision(input, 1));
        }
    }

    public void secondOption() {
        while (this.option == 2) {
            System.out.println("******************************************************************************************");
            this.showCountries();
            System.out.println("******************************************************************************************");
            System.out.println("Ingresa cualquier número o letra para regresar al menú...");
            userInput.next();
            setOption(0);
        }
    }

    public void thirdOption() {

    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public Scanner getInput() {
        return userInput;
    }

    public int getApiCalls() {
        return apiCalls;
    }

    public void setApiCalls(int apiCalls) {
        this.apiCalls = apiCalls;
    }

    public List<Country> getApiCountries() {
        return apiCountries;
    }

    public void setApiCountries(List<Country> apiCountries) {
        this.apiCountries = apiCountries;
    }
}
