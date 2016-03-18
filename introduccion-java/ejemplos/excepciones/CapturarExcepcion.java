

import java.util.InputMismatchException;

public class CapturarExcepcion {
    public static void main(String[] args) {
       
       double subtotal = 0.0;
      //capturar una excepcion del tipo InputMismatchException, que valida que los datos introducidos sean del tipo que se espera

       try{
           
           //capturar valores desde la consola
           
       }catch(InputMismatchException ex){
        System.out.println(ex.getMessage()); 
       }


    }
}
