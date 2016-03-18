package com.eudriscabrera.java.fundamentos;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ecabrerar
 */
public class GuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int guessedNumber = 10;
        int attends = 3;
        int counter = 0;

        System.out.println("Input a number: ");

        while (counter <= attends) {

            int inputNumber = sc.nextInt();

            if (guessedNumber == inputNumber) {
                System.out.println("You win !!.");
                System.out.println("GuessedNumber :" + guessedNumber);
                break;
            } else {
                counter++;
            }

            if (counter == attends) {
                System.out.println("You Lost !!.");
                System.out.println(attends + " failed attends !!.");
                break;
            }

        }

    }
}
