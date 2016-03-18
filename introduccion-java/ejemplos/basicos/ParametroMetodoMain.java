
public class ParametroMetodoMain {

  public static void main(String[] args){

    System.out.println("-------------ParametroMetodoMain--------------");
    
     if(args.length > 0){
       System.out.println("Valor pasado como parametro: "+args[0]);
     } else {
	 System.out.println("No ha digitado ningun parametro");
     }

  }

}  
