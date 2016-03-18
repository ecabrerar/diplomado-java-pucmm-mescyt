

public class OperadoresLogicos {
    public static void main(String[] args) {
        /**
         * Uso de Operadores logicos
         */
        
        int subtotal  = 0;
        int timeInService = 0;
        boolean isValid = false;
        int counter = 0;
        int years = 0;
        
        //Evaluacion del operador && (AND)
        if(subtotal >= 250 && subtotal < 500){
            
        }
        
        //Evaluacion del operador || (OR)
        if(timeInService <=4 || timeInService >=12){
            
        }
        
        //Otra forma del operador  AND & 
        if(isValid == true & counter++ < years){
            
        }
        
        //Otra forma del operador  OR | 
        if(isValid == true | counter++ < years){
            
        }
        
        //combinando operador AND y OR
        if((subtotal >= 250 && subtotal < 500) || isValid ==true){
            
        }
        
        //negacion del resultado de la expresion
        if(!(counter++ >= years)){
            
        } 
        
        //TODO: Hacer alguna operacion que permita evaluar alguno de los casos anteriores      
        
        
    }
}
