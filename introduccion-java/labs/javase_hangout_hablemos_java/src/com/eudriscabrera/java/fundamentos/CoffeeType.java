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
public enum CoffeeType {

    EXPRESSO, CAPPUCCINO, MOCHA, REGULAR;

    public static boolean isMember(String name) {
        boolean isMember = false;

        for (CoffeeType type : CoffeeType.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                isMember = true;
            }
        }
        return isMember;
    }
}
