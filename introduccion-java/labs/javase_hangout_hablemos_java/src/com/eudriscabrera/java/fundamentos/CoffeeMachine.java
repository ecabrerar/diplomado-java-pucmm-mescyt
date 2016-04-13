/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eudriscabrera.java.fundamentos;

import java.util.Scanner;

/**
 *
 * @author ecabrerar
 */
public class CoffeeMachine {

    private double price;
    private CoffeeType type;

    public CoffeeMachine() {
        super();
    }

    public CoffeeMachine(CoffeeType type, double price) {
        this.price = price;
        this.type = type;
    }

    public void gimmeACoffee() {
        if (CoffeeType.CAPPUCCINO.equals(type) && price == PriceDB.getPrice(type)) {
            System.out.println("A Cappuccino cup !");
        } else if (CoffeeType.EXPRESSO.equals(type) && price == PriceDB.getPrice(type)) {
            System.out.println("A Expresso cup !");
        }
    }

    public void menu() {
        System.out.println("=====Coffee Machine=====");
        System.out.println("\n");
        System.out.println("Menu:");

        int cont = 1;
        for (CoffeeType t : CoffeeType.values()) {
            System.out.println(String.format(" %d %s : %.2f", cont, t, PriceDB.getPrice(t)));
            cont++;
        }

        System.out.println("\n");

        Scanner sc = new Scanner(System.in);

        String option = "y";
        while (option.equalsIgnoreCase("y")) {

            System.out.println("Coffee Cup:");
            String tp = sc.next();

            System.out.println("Price:");
            double priceSc = sc.nextDouble();

            if (CoffeeType.isMember(tp)) {
                CoffeeType selected = CoffeeType.valueOf(tp.toUpperCase());
                
                if (priceSc == PriceDB.getPrice(selected)) {
                    System.out.println(String.format("Hell yeah, gimme a %s !", selected));
                }else {
                    System.out.println("Enter a valid price!");
                }
            } else {
                System.out.println(String.format("wrong option %s!!",tp));
            }

            System.out.println("Continue ? (y/n)");

            option = sc.next();
            System.out.println();

        }
    }

    public static void main(String[] args) {
        //Ejemplo 1
        /**
         * CoffeMachine cm = new CoffeMachine(CoffeeType.EXPRESSO, 2);
         * cm.gimmeACoffee();*
         */

        //Ejemplo 2
        CoffeeMachine cm = new CoffeeMachine();
        cm.menu();
    }

}
