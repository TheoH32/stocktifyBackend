package com.nighthawk.spring_portfolio.mvc.model;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nighthawk.spring_portfolio.mvc.person.PersonJpaRepository;

@RestController
@RequestMapping("/api/network")
public class callApp {
    public static void main(String[] args) {
        int input1 = 28;
        int input2 = -12;
        App network = new App();
        // double a = network.makeAPrediction(98, 14);
        // System.out.println(a);
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

        System.out.println("Average of top 3 values: " + averageOfTop3);
    }

    public double strongerPrediction(int input1, int input2) {
        App network = new App();
        // double a = network.makeAPrediction(98, 14);
        // System.out.println(a);
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