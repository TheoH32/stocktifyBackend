package com.nighthawk.spring_portfolio.mvc.model;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nighthawk.spring_portfolio.mvc.person.PersonJpaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/network")

public class AppApiController {

    @GetMapping(path = "/get")

    public double strongerPrediction(int input1, int input2) {
        App network = new App();
        int i = 0;
        List<Double> list = new ArrayList<Double>();
        for (i = 0; i <= 10; i++) {
            list.add(network.makeAPrediction(input1, input2));
        }

        List<Double> top3 = list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        double averageOfTop3 = top3.stream().mapToDouble(Double::doubleValue).average()
                .orElseThrow(NoSuchElementException::new);

        return averageOfTop3;
    }
}