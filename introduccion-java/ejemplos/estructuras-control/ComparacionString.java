
public class ComparacionString {
   
    public static void main(String[] args) {
     
     /**
      * Comparacion de expresiones usando String
      */
     
     String nombre = null;
     String apellido = null;
     String nombre1 = null;
     
     //Comparar usando el metodo equal
     if(nombre.equals("Richard")){
         //do something
     }
     
     //igual que usar el metodo equal pero no distingue entre minuscula y mayuscula
     if(nombre.equalsIgnoreCase("Richard")){
         
     }
     
     //Validar que la variable no tenga un valor asignado
     if(nombre.equals("")){
         
     }
     //Usar la expresion negacion
     if(!apellido.equals("Reinoso")){
         
     }
     //comparacion usando otra variable y la negacion del resultado de la comparacion
     if(!nombre.equalsIgnoreCase(nombre1)){
         
     }
     //comparacion con un valor null
     if(nombre == null){
         
     }
     
     //que la variable nombre sea diferente de null
     if(nombre != null){
         
     }
     
     //comparacion de dos variables
     if(nombre == nombre1){
         
     }
    
        
    }
   
}
