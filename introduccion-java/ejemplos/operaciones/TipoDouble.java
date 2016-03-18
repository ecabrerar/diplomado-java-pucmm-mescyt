
public class TipoDouble {
    public static void main(String[] args) {
        /**
        * crear objetos de la clase Double
        * La clase Double es importante para la conversion de tipos de datos del tipo double a otros tipos de datos
        */
        double price = 10.0;
        Double priceDoubleObject = new Double(price); //Convertir un double a un Double
        
        
        String priceString = Double.toString(price); //convertir un double a String
        price = Double.parseDouble(priceString); //convertir String a double      
        
    }
}
