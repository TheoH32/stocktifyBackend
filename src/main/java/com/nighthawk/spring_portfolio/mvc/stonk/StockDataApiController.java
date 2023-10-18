package com.nighthawk.spring_portfolio.mvc.stonk;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(path = "/api")


public class StockDataApiController {

    @GetMapping("/stockdata")
    public ResponseEntity<String> getStockData() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://twelve-data1.p.rapidapi.com/stocks?exchange=NASDAQ&format=json"))
                    .header("X-RapidAPI-Key", "53ed50b3c5mshb1ebce663573fbap1a08a4jsneab1f395e0a6")
                    .header("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching stock data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
        
    }
}

