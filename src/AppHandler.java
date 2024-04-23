import com.conversor.models.*;
import com.conversor.models.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppHandler extends Menu {
    private final Scanner userInput = new Scanner(System.in);
    private final Validator validate = new Validator();
    private UserHistory userHistory = new UserHistory();
    private final ConsultAPI consulter = new ConsultAPI();
    private int option = 0;
    private int apiCalls = 0;
    private String continueMessage = "";

    public void firstOption() {
        while (this.getOption() == 1) {
            CurrencyPairConversion currencyPairConversion = new CurrencyPairConversion();
            System.out.println("******************************************************************************************");
            // lista actual de paises y scanner
            List<Country> countries = this.getInitalCountryList();
            Scanner input = this.getInput();
            this.showCountries(countries);
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
            // historial
            userHistory.setUserHistoryList(currencyPairConversion);
            // Imprimir final
            System.out.println("******************************************************************************************");
            System.out.println(currencyPairConversion);
            // continuidad de la opción
            setContinueMessage("¿Deseas realizar otra conversión de moneda?");
            continueOptionWithTwoOptions(this.getContinueMessage(), this.getOption());
        }
    }

    public void secondOption() {
        while (this.getOption() == 2) {
            System.out.println("******************************************************************************************");
            List<Country> countries = this.getInitalCountryList();
            this.showCountries(countries);
            continueOptionToMenu();
        }
    }

    public void thirdOption() {
        while (this.getOption() == 3) {
            System.out.println("******************************************************************************************");
            int count = this.getApiCalls();
            Scanner userInput = this.getInput();
            List<Country> localCountries = this.getInitalCountryList();
            // evitar llamadas innecesarias a la API
            if (count == 0) {
                List<Country> apiValidCountries = consulter.consultCountries();
                this.setApiCountries(apiValidCountries);
                count++;
                this.setApiCalls(count);
            }
            List<Country> apiContries = this.getApiCountries();
            this.showCountries(apiContries);
            System.out.println("Selecciona el número del país que desees añadir (Por ej. 15): ");
            // validacion de error
            int userIndex = userInput.nextInt();
            Country userCountry = apiContries.get(userIndex - 1);
            userCountry = validate.validateAddItemtoList(userCountry, localCountries, apiContries, userInput);
            // adicion a la lista
            System.out.println("Se ha añadido tu país a la lista...");
            this.setInitalCountryList(userCountry);
            this.showCountries(localCountries);
            // continuidad de la opción
            setContinueMessage("¿Deseas añadir otro país?");
            continueOptionWithTwoOptions(this.getContinueMessage(), this.getOption());
        }
    }

    public void fourthOption() {
        while (this.getOption() == 4) {
            System.out.println("******************************************************************************************");
            List<Country> countries = this.getInitalCountryList();
            boolean validateOperation = validate.validateArraySize(countries);
            if (validateOperation) {
                // opciones iniciales para el validador
                validate.setMaxIndex(countries.size());
                validate.setMinIndex(1);
                Scanner userInput = this.getInput();
                this.showCountries(countries);
                System.out.println("Selecciona el pais que deseas quitar de la lista (por ej. 5): ");
                // validaciones
                validate.setBaseIndex(userInput.nextInt());
                int index = validate.validateInputMintoMax(userInput);
                index = index - 1;
                String countryCode = countries.get(index).getCode();
                countries = this.removeCountryFormList(index);
                System.out.printf("Se ha eliminado %s de la lista...\n", countryCode);
                String continueMessage = "¿Deseas remover otro país de la lista?";
                continueOptionWithTwoOptions(continueMessage, this.getOption());
            } else {
                continueOptionToMenu();
            }
        }
    }

    public void fiveOption() {
        while (this.getOption() == 5) {
            System.out.println("******************************************************************************************");
            List<CurrencyPairConversion> userList = this.userHistory.getUserConversionList();
            this.showUserHistory(userList);
            continueOptionToMenu();
        }
    }

    private void continueOptionWithTwoOptions(String message, int currentOption) {
        System.out.println("******************************************************************************************");
        System.out.printf("%s 'S' para continuar o 'N' para regresar al menu inicial: ", message);
        validate.setDecision(userInput.next());
        setOption(validate.validateUserDecision(userInput, currentOption));
    }

    private void continueOptionToMenu() {
        System.out.println("******************************************************************************************");
        System.out.println("Ingresa cualquier número o letra para regresar al menú...");
        userInput.next();
        setOption(0);
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

    public String getContinueMessage() {
        return continueMessage;
    }

    public void setContinueMessage(String continueMessage) {
        this.continueMessage = continueMessage;
    }
}
