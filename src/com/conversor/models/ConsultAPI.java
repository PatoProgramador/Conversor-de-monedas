package com.conversor.models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

            String json = response.body();
            System.out.println(json);
        } catch (Exception e) {
            throw new RuntimeException("No fue posible la conversion.");
        }
    }
}
