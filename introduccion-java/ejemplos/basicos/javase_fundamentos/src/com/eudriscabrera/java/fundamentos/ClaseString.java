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
public class ClaseString {
    public static void main(String[] args) {
        String strInstance1 = new String("I am object instance of a String class");
        String strInstance2 = "Live your passion!";
       
        
        char x = strInstance1.charAt(2);
        char y = strInstance2.charAt(1);
        char z = strInstance2.charAt(0);
       
        System.out.println("The 3rd char of strInstance1 = " + x);
        System.out.println("The 2nd char of strInstance2 = " + y);
        System.out.println("The 1st char of strInstance2 = " + z);
        
        
        // Invoke an instance method equalsIgnoreCase(..) method
        boolean b = strInstance1.equalsIgnoreCase(strInstance2);
        String strInstance3 = b? "Yes":"No";
        System.out.println("Do strInstance1 and strInstance2 have same string ignoring case?  " + strInstance3);
       
        // Invoke a static-method, valueOf (int i), of the String class
        int i = 23;
        String strInstance4 = String.valueOf(i);
        System.out.println("value of strInstance4 = " + strInstance4);
       
        // You already have used parseInt() static method of the Integer class in
        // previous exercises.
        String strInstance5 = new String("34"); // Create an object instance of String class
        int ii = Integer.parseInt(strInstance5);
        System.out.println("value of ii = " + ii);
        
        
        // The following code will generate a compile error since you are trying to
        // invoke a instance method through a class.   Fix this compile error.
        //char f = strInstance5.charAt(2);
       // System.out.println("f");
        
        
        // endsWith() method
        String str = "Hello";   
        System.out.println( str.endsWith( "slo" ) );

        // forDIgit() method
        System.out.println( Character.forDigit(13, 16) );

        // floor() method
        System.out.println( Math.floor(3.14));

        // isDigit() method
        System.out.println( "0=" + Character.isDigit('0'));
        System.out.println( "A=" +Character.isDigit('A'));

    
    }
}
