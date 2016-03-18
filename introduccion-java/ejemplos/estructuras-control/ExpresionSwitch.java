

public class ExpresionSwitch {
    public static void main(String[] args) {
        /**
         * Declaracion de la expresion switch
         * switch(integerExpresion){
         *  case label1:
         *   //do something
         *   break;
         *   case label2:
         *   //do something
         *   break;
         *   default: (optional)
         *    //do something
         *    break;
         * }
         */


        int productId =  0;
        String productDescription = "";

        switch (productId) {
        case 1:
            productDescription = "Hammer";
            break;
        case 2:
            productDescription = "Box of nails";
            break;
        default:
            productDescription = "Product not found";
            break;
        }
        
        
        
        //TODO: Hacer alguna operacion que permita evaluar alguno de los casos anteriores      


    }
}
