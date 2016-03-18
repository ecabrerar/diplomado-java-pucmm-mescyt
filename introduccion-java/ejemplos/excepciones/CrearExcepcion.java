

public class CrearExcepcion extends Exception {
    
    
    public CrearExcepcion(Throwable throwable) {
        super(throwable);
    }
   
   //Cuando creamos una excepcion heredamos todos los metodos de la clase padre
    public CrearExcepcion(String string, Throwable throwable) {
        super(string, throwable);
    }

    public CrearExcepcion(String string) {
        super(string);
    }

    public CrearExcepcion() {
        super();
    }


    /**
     * @param args
     */
    public static void main(String[] args)  {  
        //CrearExcepcion testCrearExcepcion = new CrearExcepcion();
        
        
        try{
            
            System.out.print("Falta poner algun codigo que genere excepscion");
            
            //do something here
        }catch(CrearExcepcion ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
