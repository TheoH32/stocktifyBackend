package com.nighthawk.spring_portfolio.mvc.stonkz;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import org.json.JSONArray;


public class stonkz {

    private static final String API_KEY = "ckdh3ghr01qvfhe2h860ckdh3ghr01qvfhe2h86g";

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String symbol = "AAPL"; // Replace with the desired stock symbol
            String apiUrl = String.format("https://finnhub.io/api/v1/stock/profile2?symbol=%s&token=%s", symbol, API_KEY);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonObject = new JSONObject(response);
            JSONObject series = jsonObject.getJSONObject("series");
            JSONObject annual = series.getJSONObject("annual");
            JSONArray currentRatioArray = annual.getJSONArray("currentRatio");

            for (int i = 0; i < currentRatioArray.length(); i++) {
                JSONObject currentRatioObject = currentRatioArray.getJSONObject(i);
                String period = currentRatioObject.getString("period");
                double value = currentRatioObject.getDouble("v");
                System.out.println("Period: " + period + ", Current Ratio: " + value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
