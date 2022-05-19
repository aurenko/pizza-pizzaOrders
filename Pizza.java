package com.urenko;

/*
Program: Pizza and Pizza Order
Author: Drew Urenko
Date: 5/11/22
*/

public class Pizza {
    // Encapsulated attributes for each Pizza object
    private String size;
    private int numCheese;
    private int numPepperoni;
    private int numHam;

    // Defined constants for the Pizza class
    public static final String SMALL = "small";
    public static final String MED = "medium";
    public static final String LARGE = "large";

    public static final double plain_smallCost = 10.0;
    public static final double plain_medCost = 12.0;
    public static final double plain_largeCost = 14.0;
    public static final double costPerTopping = 2.0;

    // Constructor with inputs for all instance variables
    public Pizza(String size, int numCheese, int numPepperoni, int numHam) {
        this.size = size;
        this.numCheese = numCheese;
        this.numPepperoni = numPepperoni;
        this.numHam = numHam;
    }

    // set methods often insure that only valid inputs are used
    public void setSize(String size) {
        this.size = size;
    }

    public void setNumCheese(int numCheese) {
        if (numCheese >= 0) {
            this.numCheese = numCheese;
        }
        else {
            System.out.println("Number of cheese is negative. Number of cheese will be set to 0.");
            numCheese = 0;
            this.numCheese = numCheese;
        }
    }

    public void setNumPepperoni(int numPepperoni) {
        if (numPepperoni >= 0) {
            this.numPepperoni = numPepperoni;
        }
        else {
            System.out.println("Number of pepperoni is negative. Number of pepperoni will be set to 0.");
            numPepperoni = 0;
            this.numPepperoni = numPepperoni;
        }
    }

    public void setNumHam(int numHam) {
        if (numHam >= 0) {
            this.numHam = numHam;
        }
        else {
            System.out.println("Number of ham is negative. Number of ham will be set to 0.");
            numHam = 0;
            this.numHam = numHam;
        }
    }

    // get methods return the value of object attributes
    public String getSize(String size) {
        return this.size;
    }

    public int getNumCheese(int numCheese) {
        return this.numCheese;
    }

    public int getNumPepperoni(int numPepperoni) {
        return this.numPepperoni;
    }

    public int getNumHam(int numHam) {
        return this.numHam;
    }

    // toString returns a meaningful description of a Pizza object
    public String toString() {
        return("Size: "+this.size+"\n"+"# of Cheese: "+this.numCheese+"\n"+"# of Pepperoni: "+this.numPepperoni+"\n"+"# of Ham: "+this.numHam+"\n=================");
    }

    public static double calcCost(String size, int numCheese, int numPepperoni, int numHam) {
        int numToppings = numCheese + numPepperoni + numHam;
        double startingCost = 0.00;
        if (size == "small") {
            startingCost = 10.00;
        }

        else if (size == "medium") {
            startingCost = 12.00;
        }

        else if (size == "large") {
            startingCost = 14.00;
        }
        double cost = startingCost + (2.00 * numToppings);
        return cost;
    }

    public String getDescription(String size, int numCheese, int numPepperoni, int numHam) {
        setSize(size);
        setNumCheese(numCheese);
        setNumPepperoni(numPepperoni);
        setNumHam(numHam);
        if (numCheese < 0) {
            numCheese = 0;
        }
        if (numPepperoni < 0) {
            numPepperoni = 0;
        }
        if (numHam < 0) {
            numHam = 0;
        }
        return("This pizza has "+numCheese+" cheese, "+numPepperoni+" pepperoni, and "+numHam+" ham. It costs $"+calcCost(size, numCheese, numPepperoni, numHam));
    }

    public static void main(String[] args) {
        Pizza pizza1 = new Pizza(MED, 1, 0, 0);
        System.out.println(pizza1.getDescription(MED, 1, 0, 0));
        Pizza pizza2 = new Pizza(LARGE, 2, 3, 4);
        System.out.println(pizza2.getDescription(LARGE, 2, 3, 4));
        System.out.println("=================");
    }
}