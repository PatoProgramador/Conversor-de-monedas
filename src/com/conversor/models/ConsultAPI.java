package com.conversor.models;

import com.conversor.models.utils.HttpJsonResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultAPI extends HttpJsonResponse {
    private String url = "https://v6.exchangerate-api.com/v6/" + System.getenv("EXCHANGE-API-KEY");

    public void exchangeCurrencyPair(CurrencyPairConversion currencyPairConversion) {
        String pairBaseCode = currencyPairConversion.getBaseCode();
        String pairTargetCode = currencyPairConversion.getTargetCode();
        Double pairAmount = currencyPairConversion.getAmount();

        URI apiUrl = URI.create(url + "/pair/" + pairBaseCode + "/" + pairTargetCode + "/" + pairAmount);

        try {
            // metodo de clase madre
            JsonObject jsonObject = getJsonResponseFromApi(apiUrl);

            double amountConverted = jsonObject.get("conversion_result").getAsDouble();

            currencyPairConversion.setAmountConverted(amountConverted);
            currencyPairConversion.setCreatedAt(LocalDateTime.now().toString());
        } catch (Exception e) {
            throw new RuntimeException("No fue posible la conversion de moneda.");
        }
    }

    public List<Country> consultCountries() {
        URI apiUrl = URI.create(url + "/codes");
        List<Country> apiCountries = new ArrayList<>();
        try {
            // metodo de clase madre
            JsonObject jsonObject = getJsonResponseFromApi(apiUrl);

            JsonArray jsonArray = jsonObject.getAsJsonArray("supported_codes");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonArray countryItems = jsonArray.get(i).getAsJsonArray();
                String code = countryItems.get(0).getAsString();
                String name = countryItems.get(1).getAsString();
                apiCountries.add(new Country(code, name));
            }
            return apiCountries;
        } catch (Exception e) {
            throw new RuntimeException("No fue posible obtener los paises de la API.");
        }
    }
}
