

public class ExpresionWhileDoWhile {
    public static void main(String[] args) {
        /**
        * Evaluacion de la expresion While y Do While
        */


        /**
         * While:
         * La sintaxis del bucle while
         * while (booleanExpression)
         * {
         * declaraciones
         * }
         */

        int i = 1;
        int months = 36;

        while (i < months) {
            //do something here
            i++;
        }

        /**
         * Do While
         * do{
         *  //declaraciones
         *  }while(booleanExpression)
         */


        do {
            //do something here
            i++;
        } while (i < months);
        
        //TODO: Hacer alguna operacion que permita evaluar alguno de los casos anteriores      
    }
}
