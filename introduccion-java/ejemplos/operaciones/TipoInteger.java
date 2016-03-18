
/**
 * La clase Integer es una clase de ayuda para la clase int y que nos permite trabajar con los demas tipos de datos 
 * primitivos en java
 */
public class TipoInteger {
    public static void main(String[] args) {
        
        /**
        * crear objetos de la clase Integer
        * La clase int es importante para la conversion de tipos de datos del tipo entero a otros tipos de datos
        */
        int quantity = 10;
        Integer quantityIntegerObject = new Integer(quantity); //Convertir un int a Integer
        
        String quantityString = Integer.toString(quantity);  //convertir un int a String
        
        quantity = Integer.parseInt(quantityString); //convertir un String a un int
        
    }
}
