import com.conversor.models.ConsultAPI;
import com.conversor.models.Country;
import com.conversor.models.CurrencyPairConversion;
import com.conversor.models.Menu;
import com.conversor.models.utils.Validator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        AppHandler app = new AppHandler();
        String options = app.getMenuItems();
        Scanner userInput = app.getInput();

        try {
            System.out.println("¡Bienvenidx a la aplicación de conversión moneda!");
            while (app.getOption() != 7) {
                System.out.println(options);
                System.out.println("Por favor selecciona una opción valida: ");
                app.setOption(userInput.nextInt());
                switch (app.getOption()) {
                    case 1:
                        app.firstOption();
                        break;
                    case 2:
                        app.secondOption();
                        break;
//                    case 3:
//                        if (apiCalls == 0) {
//                            apiCountries = consulter.getApiCountries();
//                            apiCalls++;
//                        }
//                        System.out.println("-----Lista de paises validos-----");
//                        for (int i = 0; i < apiCountries.size(); i++) {
//                            System.out.println((i + 1) + ". " + apiCountries.get(i));
//                        }
//                        System.out.println("Selecciona el número del país que deseas añadir (Por ej. 1): ");
//                        int userIn = input.nextInt();
//                        Country apiCountry = apiCountries.get(userIn - 1);
//                        break;
                    case 7:
                        app.appFinalMessage();
                        break;
                    default:
                        System.out.println("Opcion invalida, intenta ingresando alguna del menu :D");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);;
        }
    }
}