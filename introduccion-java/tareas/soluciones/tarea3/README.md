###Diplomado en Lenguaje JAVA (PUCMM ­ MESCYT)

Tarea 3: Tipos de datos enumerados y Colecciones

Por Eudris Cabrera Rodríguez
 
####Objetivo:
Practicar los conceptos de tipos de datos enumerados y las colecciones en Java.
 
Nota: Solucción en el proyecto **javase_enum_coleciones**.

1- Se tiene un enum llamado Fruta que contiene un listado de frutas. 
```java
public enum Fruta {
    MANGO, NARANJA, MELON, ZAPOTE, FRESA, SANDIA
}
```
En la clase PruebaEnum se desea saber si te gusta una fruta en específico.
```java
public class PruebaEnum {
    Fruta fruta;

    public PruebaEnum(Fruta fruta) {
        this.fruta = fruta;
    }
    
    public void decirSiTeGusta(){
        
    }
    
    public static void main(String[] args) {
        
        PruebaEnum frutaMango = new PruebaEnum(Fruta.MANGO);
        frutaMango.decirSiTeGusta();
        
        PruebaEnum frutaNaranja = new PruebaEnum(Fruta.NARANJA);
        frutaNaranja.decirSiTeGusta();
        
    }
}
```
En el método decirSiTeGusta(), agregar lógica para que cumpla con la siguiente salida.


**Salida:**
Mango es muy bueno.
No me gusta la sandía.
La naranja es muy buena pero prefiero el zapote.
El melón es mi favorito.

Agregar en el método **main(String[] args)** las demás opciones que completan la salida.

2- Se desea crear un enum llamado **"Entrada"** que contemple los precios de las entradas a un evento en un sala famosa de entretenimiento.
Los precios son los siguientes **1,000 Balcón**, **1,500 Platea**, **$2,500 VIP** y **RD$3,000  Front Stage Platinum**.

Crear una nueva clase llamada **"PruebaEntrada"** y recorriendo todos los valores del enum entrada permite saber el listado de precios.
Tomar en consideración el método "values".

**Salida**:
El precio de la entrada en "BALCON" es RD$1,000.
El precio de la entrada en "PlATEA" es RD$1,500.
El precio de la entrada en "VIP" es RD$2,500.
El precio de la entrada en "FRONT_STAGE_PLATINUM" es RD$3,000.

Tomar en consideración las reglas para nombrar las constantes.

3 - Dado el siguiente arreglo de enteros  
```java
Integer[] enteros = {10,20,50,100,75,35}; 
```
Escribir programa que ordene y despliegue el arreglo anterior en orden descendente.

4- Dado un listado de personas crear metodos en la clase **CriterioBusqueda** que permita lista todos los elementos de la lista, filtrar entre las edades 25 y 50 años, y los mayores de 50 personas.

