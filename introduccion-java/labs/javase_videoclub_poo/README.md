##Aprendiendo a diseñar las clases de un programa a partir de un escenario dado. 

Supongamos que tenemos que desarrollar una aplicación   que gestione los alquileres de 
DVDs en un vídeo­club. 
 
Nuestro escenario sería el siguiente: un cliente puede alquilar una o varias peliculas(DVD) 
por un tiempo especifico,  hay varios tipos de peliculas que el cliente puede alquilar, estas 
son: INFANTILES, NORMALES  Y NOVEDAD. El cliente debe pagar un precio por el alquiler 
de la misma. 
 
Inicialmente, tendríamos  3 clases : DVD, Alquiler y Cliente. 
```java
package org.diplomado.pucmm.mescyt.java.diseno_inicial;

/**
 *
 * @author ecabrerar
 */
public class DVD {

    private final String titulo;
    private final int tipo;

    public DVD(String titulo, int tipo) {
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTipo() {
        return tipo;
    }

}
```

Seguimos con nuestro analisis,  debemos de hacer una clase llamada alquiler la cual tiene 
las siguientes propiedades DVD y tiempo. 

```java
package org.diplomado.pucmm.mescyt.java.diseno_inicial;

/**
 *
 * @author ecabrerar
 */
public class Alquiler {
    private DVD dvd;
    private int tiempo;
 
    public DVD getDvd() {
        return dvd;
    }

    public void setDvd(DVD dvd) {
        this.dvd = dvd;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    } 
    
}

```

Y sobre el cliente nos interesa saber el nombre, la cantidad de peliculas que desea alquilar  y 
el dinero que tiene que pagar las peliculas alquiladas. El video club cobra 70 pesos por 
peliculas normales, 80 pesos por novedad y 60 pesos por peliculas infantiles. Si el cliente pasa de 2 dias con una pelicula normal  y  de 3 dias con una pelicula infantil,  se le cobra 5 
pesos por cada dia que pasa. 
 
También el cliente cuenta con un programa de puntos, si el cliente alquila una pelicula de tipo 
novedad por más de 1 días el cliente acomula puntos que luego podrá usar en el alquiler de 
otra pelicula. 

```java
package org.diplomado.pucmm.mescyt.java.diseno_inicial;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class Cliente {

    private String nombre;
    private String telefono;
    private final List<Alquiler> alquileres;

    public Cliente() {
        alquileres = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void addAquiler(Alquiler alquiler) {
        this.alquileres.add(alquiler);
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public String getFactura() {
        StringBuilder sb = new StringBuilder(100);

        double importe = 0;
        double total = 0;
        int puntos = 0;

        for (Alquiler alq : alquileres) {

            switch (alq.getDvd().getTipo()) {
                case 1:
                    importe += 70;

                    if (alq.getTiempo() > 2) {
                        importe += (alq.getTiempo() - 2) * 5;
                    }

                    break;
                case 2:

                    importe += 60;

                    if (alq.getTiempo() > 3) {
                        importe += (alq.getTiempo() - 3) * 5;
                    }

                    break;
                case 3:
                    importe += alq.getTiempo() * 80;
                    break;

                default:
                    break;
            }

            sb.append("Titulo pelicula :").append(alq.getDvd().getTitulo());
            sb.append("Importe :").append(importe);
            sb.append("\n");

            if (alq.getDvd().getTipo() == 3) {
                if (alq.getTiempo() > 1) {
                    puntos++;
                }
            }

            total += importe;

        }

        sb.append(" Total:").append(total);
        sb.append("Puntos :").append(puntos);

        return sb.toString();
    }

}

```
Hasta aquí nuestro diseño inicial ha concluido, pero tiene un error de diseño y a continuación 
vamos corregir este error. 

###Paso 1­:

a)El tipo de pelicula puede ser representado por un enum para hacer nuestro diseño de clase más flexible.

```java

package org.diplomado.pucmm.mescyt.java.paso1;

/**
 *
 * @author ecabrerar
 */
public enum TipoPelicula {
   NORMAL(1),INFANTIL(2),NOVEDAD(3);
   
   private final int tipo;
   
  private TipoPelicula(int tipo){
       this.tipo = tipo;
   }
  
  public int getTipo(){
      return tipo;
  }
}

```

b) El método de factura()  es excesivamente largo y debemos de diseñar nuestra clase lo más modular posible, por lo que vamos a crear un metodo llamado precio  y la clase cliente sería de la  siguiente manera.
```java
package org.diplomado.pucmm.mescyt.java.paso1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class Cliente {

    private String nombre;
    private String telefono;
    private List<Alquiler> alquileres;

    public Cliente() {
        alquileres = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void addAquiler(Alquiler alquiler) {
        this.alquileres.add(alquiler);
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public String getFactura() {
        StringBuilder sb = new StringBuilder(100);

        double importe = 0;
        double total = 0;
        int puntos = 0;

        for (Alquiler alq : alquileres) {

            importe = getImporte(alq);

            sb.append("Titulo pelicula :").append(alq.getDvd().getTitulo());
            sb.append("Importe :").append(importe);
            sb.append("\n");

            if (TipoPelicula.NOVEDAD.equals(alq.getDvd().getTipo().NOVEDAD)
                    && alq.getTiempo() > 1) {
                puntos++;
            }

            total += importe;

        }

        sb.append(" Total:").append(total);
        sb.append("Puntos :").append(puntos);

        return sb.toString();
    }

    private double getImporte(Alquiler alquiler) {

        double importe = 0;
        switch (alquiler.getDvd().getTipo()) {
            case NORMAL:
                importe += 70;

                if (alquiler.getTiempo() > 2) {
                    importe += (alquiler.getTiempo() - 2) * 5;
                }

                break;
            case INFANTIL:

                importe += 60;

                if (alquiler.getTiempo() > 3) {
                    importe += (alquiler.getTiempo() - 3) * 5;
                }

                break;
            case NOVEDAD:
                importe += alquiler.getTiempo() * 80;
                break;

            default:
                break;
        }
        return importe;
    }

}

```

###Paso 2­:
En realidad, precio no usa datos de Cliente, por lo que resulta más que razonable convertirlo en un método de la clase Alquiler 

```java
package org.diplomado.pucmm.mescyt.java.paso2;

/**
 *
 * @author ecabrerar
 */
public class Alquiler {

    private DVD dvd;
    private int tiempo;

    public DVD getDvd() {
        return dvd;
    }

    public void setDvd(DVD dvd) {
        this.dvd = dvd;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double getImporte() {

        double importe = 0;
        switch (getDvd().getTipo()) {
            case NORMAL:
                importe += 70;

                if (getTiempo() > 2) {
                    importe += (getTiempo() - 2) * 5;
                }

                break;
            case INFANTIL:

                importe += 60;

                if (getTiempo() > 3) {
                    importe += (getTiempo() - 3) * 5;
                }

                break;
            case NOVEDAD:
                importe += getTiempo() * 80;
                break;

            default:
                break;
        }
        return importe;
    }

}

```

Cuando un método de una clase (Cliente) accede continuamente a los miembros de otra clase (Alquiler) pero no a los de su clase  (Cliente), es conveniente mover el método a la clase cuyos datos utiliza. Además, el código resultante será más sencillo.
 
Como hemos cambiado precio() de sitio, tenemos que cambiar las llamadas a precio() que 
había en nuestra clase Cliente: 

```java
public class Cliente {
...

 public String getFactura(){

  ....

  for(Alquiler alq: alquileres){
            
            importe = alq.getImporte();
   ...
 }

 }
}

```

###Paso 3: 
Extraer el cálculo correspondiente al programa de puntos.
```java

package org.diplomado.pucmm.mescyt.java.paso3;

/**
 *
 * @author ecabrerar
 */
public class Alquiler {
    ....
    
    public int getPuntos(){
        
         if(TipoPelicula.NOVEDAD.equals(getDvd().getTipo().NOVEDAD)
                    && getTiempo()>1){
                puntos ++;
            } 
         return puntos;
    }
   .....

 }


public class Cliente {

   ....
    
    public String getFactura(){
        StringBuilder sb = new StringBuilder(100);
        
        double importe = 0;
        double total = 0;
        int puntos = 0;
        
        for(Alquiler alq: alquileres){
            
            .....
             
             puntos = alq.getPuntos();
             
           ......
            
        }
        
       .....
    }
    
}


```

###Paso 4: 
Separar los cálculos de las operaciones de E/S En el método  getFactura(), estamos mezclando cálculos útiles con las  llamadas a  System.out.println() que generar el informe: 
a)Creamos un método independiente para calcular el gasto total realizado por un cliente. 

```java

private double getImporteTotal(){
        
        double total = 0;
      
        for(Alquiler alq: alquileres){
            
            total += alq.getImporte();
         }
         
         return total;
    }

```

b)Creamos otro método independiente para calcular los puntos acumulados por un cliente en el programa de puntos del vídeo­club.

```java
 
private int getPuntos(){
        int puntos = 0;
      
        for(Alquiler alq: alquileres){
            
            puntos += alq.getPuntos();
         }
         
         return puntos;
    }


```

Tras los cambios anteriores en la clase Cliente, la generación de la factura es bastante más sencilla que antes: 

```java

package org.diplomado.pucmm.mescyt.java.paso4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class Cliente {
    private String nombre;
    private String telefono;
    private List<Alquiler> alquileres;
    
    public Cliente(){
        alquileres= new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void addAquiler(Alquiler alquiler){
        this.alquileres.add(alquiler);
    }
    
    public List<Alquiler> getAlquileres(){
        return alquileres;
    }
    
    public String getFactura(){
        
        StringBuilder sb = new StringBuilder(100);       
              
        for(Alquiler alq: alquileres){            
                  
             sb.append("Titulo pelicula :").append(alq.getDvd().getTitulo());
             sb.append("Importe :").append(alq.getImporte());
             sb.append("\n");
        }
        
        sb.append("Total:").append(getImporteTotal()); 
        sb.append("Puntos :").append(getPuntos());
        
        return sb.toString();
    }
    
    
    private double getImporteTotal(){
        
        double total = 0;
      
        for(Alquiler alq: alquileres){
            
            total += alq.getImporte();
         }
         
         return total;
    }
    
    private int getPuntos(){
        int puntos = 0;
      
        for(Alquiler alq: alquileres){
            
            puntos += alq.getPuntos();
         }
         
         return puntos;
    }
}

```

###Paso 5:
Movemos la implementación del método getImporte() de la clase  Alquiler al lugar que parece más natural si los precios van ligados  a la película que se alquila: 

```java
package org.diplomado.pucmm.mescyt.java.paso5;

/**
 *
 * @author ecabrerar
 */
public class DVD {

    private final String titulo;
    private final TipoPelicula tipo;

    public DVD(String titulo, TipoPelicula tipo) {
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public TipoPelicula getTipo() {
        return tipo;
    }

    public double getImporte(int tiempo) {

        double importe = 0;
        
        switch (getTipo()) {
            case NORMAL:
                importe += 70;

                if (tiempo > 2) {
                    importe += (tiempo - 2) * 5;
                }

                break;
            case INFANTIL:

                importe += 60;

                if (tiempo > 3) {
                    importe += (tiempo - 3) * 5;
                }

                break;
            case NOVEDAD:
                importe += tiempo * 80;
                break;

            default:
                break;
        }
        return importe;
    }

}

public class Alquiler {

    .....
    
    public double getImporte(){
       return dvd.getImporte(tiempo);
    }
            

}


```

###Paso 6:
Hacemos lo mismo con el método getPuntos():

```java
public class DVD {

    ...

    public int getPuntos(int tiempo) {
        int puntos = 0;
        if (TipoPelicula.NOVEDAD.equals(getTipo().NOVEDAD)
                && tiempo > 1) {
            puntos++;
        }
        return puntos;
    }

}

public class Alquiler {
   .....

   public int getPuntos(){
        return dvd.getPuntos(tiempo);
    }

}

```
###Paso 7:
Reemplazar lógica condicional con polimorfismo.
Queremos darle más flexibilidad a la forma en la que se fijan los  precios de los alquileres de películas, para que se puedan añadir nuevas categorías (por ejemplo, en la creación de promociones) o  para que se puedan ajustar las tarifas.

NOTA: 
¿Por qué no creamos una jerarquía de tipos de películas? 
 
Porque las películas pueden cambiar de categoría con el tiempo  (dejan de ser una novedad) 
pero siguen manteniendo su identidad. 

Creamos la jerarquía correspondiente a las políticas de precios: 

```java

package org.diplomado.pucmm.mescyt.java.paso7;

/**
 *
 * @author ecabrerar
 */
public abstract class Tarifa {
    public abstract TipoPelicula getTipo();
}

public class TarifaNormal extends Tarifa{

    @Override
    public TipoPelicula getTipo() {
       return TipoPelicula.NORMAL;
    }
    
}

public class TarifaInfantil extends Tarifa {

    @Override
    public TipoPelicula getTipo() {
        return TipoPelicula.INFANTIL;
    }

}

public class TarifaEstreno extends Tarifa{

    @Override
    public TipoPelicula getTipo() {
       return TipoPelicula.NOVEDAD;
    }
    
}


```

A continuación, en la clase DVD, sustituimos el atributo tipo por un  objeto de tipo Tarifa, en 
el cual recaerá luego la responsabilidad de  establecer el precio correcto.

```java

public class DVD {

    private final String titulo;
    private Tarifa tarifa;

    public DVD(String titulo, TipoPelicula tipo) {
        this.titulo = titulo;
        setTipo(tipo);
    }

    public String getTitulo() {
        return titulo;
    }

    public TipoPelicula getTipo() {
        return tarifa.getTipo();
    }
    
    private void setTipo(TipoPelicula tipo){
           switch (tipo) {
            case NORMAL:
              tarifa = new TarifaNormal();               

                break;
            case INFANTIL:
                tarifa = new TarifaInfantil();             

                break;
            case NOVEDAD:
               tarifa = new TarifaEstreno();
                
            default:
                break;
        }
    }

....
 }
```

Finalmente, cambiamos la implementación de getImporte()
```java
package org.diplomado.pucmm.mescyt.java.paso7;

/**
 *
 * @author ecabrerar
 */
public abstract class Tarifa {
    public abstract TipoPelicula getTipo();
     public abstract double getImporte(int tiempo);
}

public class TarifaNormal extends Tarifa {

    @Override
    public TipoPelicula getTipo() {
        return TipoPelicula.NORMAL;
    }

    @Override
    public double getImporte(int tiempo) {
        double importe = 70;

        if (tiempo > 2) {
            importe += (tiempo - 2) * 5;
        }
        return importe;
    }

public class TarifaInfantil extends Tarifa {

    @Override
    public TipoPelicula getTipo() {
        return TipoPelicula.INFANTIL;
    }

    @Override
    public double getImporte(int tiempo) {

        double importe = 60;

        if (tiempo > 3) {
            importe += (tiempo - 3) * 5;
        }

        return importe;
    }

}

public class TarifaEstreno extends Tarifa{

    @Override
    public TipoPelicula getTipo() {
       return TipoPelicula.NOVEDAD;
    }

    @Override
    public double getImporte(int tiempo) {
        return tiempo * 80;
    }
    
}

public class DVD {

   ...
   
    public double getImporte(int tiempo) {
        return tarifa.getImporte(tiempo);
    }
 
  ...
 
}

```

###Paso 8: 
Reemplazar lógica condicional con polimorfismo II. 
Repetimos el mismo proceso de antes para el método getPuntos()
```java

package org.diplomado.pucmm.mescyt.java.paso8;

/**
 *
 * @author ecabrerar
 */
public abstract class Tarifa {

    public abstract TipoPelicula getTipo();

    public abstract double getImporte(int tiempo);

    public int getPuntos(int tiempo) {
        return 0;
    }
}

public class TarifaEstreno extends Tarifa{

    @Override
    public TipoPelicula getTipo() {
       return TipoPelicula.NOVEDAD;
    }

    @Override
    public double getImporte(int tiempo) {
        return tiempo * 80;
    }

    @Override
    public int getPuntos(int tiempo) {
     return   tiempo > 1 ? 1:0;
    
    }
    
}

public class DVD {

...

    public int getPuntos(int tiempo) {
        return tarifa.getPuntos(tiempo);
    }
...
}

```
