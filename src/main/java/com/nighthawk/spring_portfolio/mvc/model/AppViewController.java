package com.nighthawk.spring_portfolio.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500") // Adjust this as per your frontend's URL
@RequestMapping(path = "/api/network")
public class AppViewController {

    @Autowired
    private App network;

    @GetMapping
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<>("Network API is up and running!", HttpStatus.OK);
    }

    @PostMapping("/predict")
    public ResponseEntity<Map<String, Object>> predictNetwork(@RequestBody Map<String, Integer> inputData) {
        Map<String, Object> response = new HashMap<>();

        // Extracting input data for prediction
        Integer input1 = inputData.get("input1");
        Integer input2 = inputData.get("input2");

        // Making a prediction using the App class
        double prediction = network.makeAPrediction(input1, input2);

        response.put("status", "success");
        response.put("prediction", prediction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/strongerPredict")
    public ResponseEntity<Map<String, Object>> strongerPredictNetwork(@RequestBody Map<String, Integer> inputData) {
        Map<String, Object> response = new HashMap<>();

        // Extracting input data for prediction
        Integer input1 = inputData.get("input1");
        Integer input2 = inputData.get("input2");

        // Making a stronger prediction using the App class
        double prediction = network.strongerPrediction(input1, input2);

        response.put("status", "success");
        response.put("strongerPrediction", prediction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // You can add more endpoints as needed for other functionalities related to the
    // network.
}
