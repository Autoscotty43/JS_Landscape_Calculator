package com.example.landscaping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandscapingController {

    @GetMapping("/calculate")
    public String calculateCost(
            @RequestParam("houseNumber") int houseNumber,
            @RequestParam("length") double length,
            @RequestParam("width") double width,
            @RequestParam("grassType") String grassType,
            @RequestParam("numTrees") int numTrees) {

        // Create service to calculate cost
        LandscapingService service = new LandscapingService();
        double totalCost = service.calculateTotalCost(length, width, grassType, numTrees);

        return String.format("Total cost for house %d is: $%.2f", houseNumber, totalCost);
    }
}
