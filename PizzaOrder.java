package com.urenko;

import java.util.ArrayList;

import static com.urenko.Pizza.LARGE;
import static com.urenko.Pizza.MED;

public class PizzaOrder {
    private Pizza pizza1;
    private Pizza pizza2;
    private Pizza pizza3;
    private int numPizzas;

    public PizzaOrder(Pizza pizza1, Pizza pizza2, Pizza pizza3, int numPizzas) {
        this.pizza1 = pizza1;
        this.pizza2 = pizza2;
        this.pizza3 = pizza3;
        this.numPizzas = numPizzas;
    }

    public void setNumPizzas(int numPizzas) {
        this.numPizzas = numPizzas;
    }

    public void setPizza1(Pizza pizza1) {
        this.pizza1 = pizza1;
    }

    public void setPizza2(Pizza pizza2) {
        this.pizza2 = pizza2;
    }

    public void setPizza3(Pizza pizza3) {
        this.pizza3 = pizza3;
    }

    public int getNumPizzas() {
        return this.numPizzas;
    }

    public double calcTotal(String size, int numCheese, int numPepperoni, int numHam, int numPizzas, Pizza pizza) {
        double total = 0.0;
        double tax = .06 ;
        return (Pizza.calcCost(size, numCheese, numPepperoni, numHam) * numPizzas) * (1 + tax);
    }

    public String toString() {
        return("Pizzas Ordered: "+this.numPizzas+"\n"+this.pizza1+"\n"+this.pizza2+"\n"+this.pizza3);
    }

    public static void main(String[] args) {
        String[] sizeArray = {LARGE, MED, LARGE};
        int[] cheeseArray = {1, 2, 3};
        int[] pepArray = {1, 0, 4};
        int[] hamArray = {1, 2, 5};
        ArrayList<PizzaOrder> orders = new ArrayList<PizzaOrder>();
        int numPizzas = 3;
        Pizza pizza1 = new Pizza(sizeArray[0], cheeseArray[0], pepArray[0], hamArray[0]);
        Pizza pizza2 = new Pizza(sizeArray[1], cheeseArray[1], pepArray[1], hamArray[1]);
        Pizza pizza3 = new Pizza(sizeArray[2], cheeseArray[2], pepArray[2], hamArray[2]);
        PizzaOrder order = new PizzaOrder(pizza1, pizza2, pizza3, numPizzas);
        double total = 0;
        for (int i = 0; i < numPizzas; i++) {
            String s = sizeArray[i];
            int c = cheeseArray[i];
            int p = pepArray[i];
            int h = hamArray[i];
            Pizza pizza = new Pizza(s, c, p, h);
            total = order.calcTotal(s, c, p, h, numPizzas, pizza);
        }

        order.setNumPizzas(numPizzas);
        order.setPizza1(pizza1);
        order.setPizza2(pizza2);
        order.setPizza3(pizza3);
        /* System.out.println(pizza1);
        System.out.println(pizza2);
        System.out.println(pizza3); */

        System.out.println("Pizza Order Summary:");
        System.out.println("=================");
        System.out.println(order);
        System.out.println("The order total is $" + total);
    }
}