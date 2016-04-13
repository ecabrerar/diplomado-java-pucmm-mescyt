/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eudriscabrera.java.fundamentos;

/**
 *
 * @author ecabrerar
 */
public class PriceDB {

    public static double getPrice(CoffeeType type) {

        switch (type) {
            case EXPRESSO:
                return 2;
            case CAPPUCCINO:
                return 5;
            case MOCHA:
                return 5.5;
            case REGULAR:
                return 1;
            default:
                return 0;

        }
    }
}
