package com.example.landscaping;

public class LandscapingService {

    // Constants
    private static final double BASE_LABOUR_CHARGE = 1000.00;
    private static final double EXTRA_CHARGE_LARGE_PLOT = 500.00;
    private static final double FESCUE_COST_PER_SQFT = 0.05;
    private static final double BENTGRASS_COST_PER_SQFT = 0.02;
    private static final double CAMPUS_COST_PER_SQFT = 0.01;
    private static final double TREE_COST = 100.00;
    private static final double LARGE_PLOT_THRESHOLD = 5000.00;

    public double calculateTotalCost(double length, double width, String grassType, int numTrees) {
        // Calculate area of the plot
        double area = length * width;

        // Start with base labor cost
        double totalCost = BASE_LABOUR_CHARGE;

        // Check for extra charge if the plot is over 5000 sq ft
        if (area > LARGE_PLOT_THRESHOLD) {
            totalCost += EXTRA_CHARGE_LARGE_PLOT;
        }

        // Determine the cost per square foot based on the grass type
        double grassCostPerSqFt = getGrassCost(grassType);

        // Add cost for grass
        totalCost += area * grassCostPerSqFt;

        // Add cost for trees
        totalCost += numTrees * TREE_COST;

        return totalCost;
    }

    private double getGrassCost(String grassType) {
        switch (grassType.toLowerCase()) {
            case "fescue":
                return FESCUE_COST_PER_SQFT;
            case "bentgrass":
                return BENTGRASS_COST_PER_SQFT;
            case "campus":
                return CAMPUS_COST_PER_SQFT;
            default:
                throw new IllegalArgumentException("Invalid grass type");
        }
    }
}
