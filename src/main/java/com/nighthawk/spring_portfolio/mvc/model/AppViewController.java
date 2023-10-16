package com.nighthawk.spring_portfolio.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nighthawk.spring_portfolio.mvc.model.App; // Importing the App class

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/network")
public class AppViewController {

    // Assuming you have an instance of the App class to make predictions.
    private App network = new App();

    /**
     * Endpoint to receive input data and return predictions.
     * 
     * @param inputData - Data to be processed by the network.
     * @return - Predictions or some result from the network.
     */
    @PostMapping("/predict")
    public Map<String, Object> predictNetwork(@RequestBody Map<String, Integer> inputData) {
        Map<String, Object> response = new HashMap<>();

        // Extracting input data for prediction
        Integer input1 = inputData.get("input1");
        Integer input2 = inputData.get("input2");

        // Making a prediction using the App class
        double prediction = network.makeAPrediction(input1, input2);

        response.put("status", "success");
        response.put("prediction", prediction);

        return response;
    }

    /**
     * Endpoint to receive input data and return a stronger prediction based on
     * multiple runs.
     * 
     * @param inputData - Data to be processed by the network.
     * @return - Average of top 3 predictions.
     */
    @PostMapping("/strongerPredict")
    public Map<String, Object> strongerPredictNetwork(@RequestBody Map<String, Integer> inputData) {
        Map<String, Object> response = new HashMap<>();

        // Extracting input data for prediction
        Integer input1 = inputData.get("input1");
        Integer input2 = inputData.get("input2");

        // Making a stronger prediction using the App class
        double prediction = network.makeAPrediction(input1, input2);

        response.put("status", "success");
        response.put("strongerPrediction", prediction);

        return response;
    }

    // You can add more endpoints as needed for other functionalities related to the
    // network.
}
