package com.conversor.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class ConsultAPI {
    private String url = "https://v6.exchangerate-api.com/v6/" + System.getenv("EXCHANGE-API-KEY");

    public void exchangeCurrencyPair(CurrencyPairConversion currencyPairConversion) {
        String pairBaseCode = currencyPairConversion.getBaseCode();
        String pairTargetCode = currencyPairConversion.getTargetCode();
        Double pairAmount = currencyPairConversion.getAmount();
        URI apiUrl = URI.create(url + "/pair/" + pairBaseCode + "/" + pairTargetCode + "/" + pairAmount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(apiUrl)
                .build();
        try {
            HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            double amountConverted = jsonObject.get("conversion_result").getAsDouble();

            currencyPairConversion.setAmountConverted(amountConverted);
            currencyPairConversion.setCreatedAt(LocalDateTime.now().toString());
        } catch (Exception e) {
            throw new RuntimeException("No fue posible la conversion.");
        }
    }
}
