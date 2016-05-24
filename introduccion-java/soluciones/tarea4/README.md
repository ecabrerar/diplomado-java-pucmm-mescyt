###Diplomado en Lenguaje JAVA (PUCMM ­ MESCYT)

Por Eudris Cabrera Rodríguez
 
Nota: Crear nuevo proyecto en netbeans, ponerle el nombre de **javase_programacion_basica**. Crear estructura de paquete usando como base **org.diplomado.pucmm.mescyt**. 

1- Se tiene un enum llamado Fruta que contiene un listado de frutas. 
```java
public enum Fruta {
    MANGO, NARANJA, MELON, ZAPOTE, SANDIA
}
```
Escribir un programa que tome el nombre de la fruta  desde la consola y dependiendo la opción digitada desplegar uno de los siguientes mensajes.

**Mensajes:**
* Mango es muy bueno.
* No me gusta la sandía.
* La naranja es muy buena pero prefiero el zapote.
* El melón es mi favorito.

En caso de digital una opción que no se encuentre en el enum, escribir el siguiente mensaje **"Opción digitada no es válida"**.

2 - Dado el siguiente arreglo de enteros  
```java
Integer[] notas = {75,60,50,100,75,90,80,85,70,95,88};
```
Escribir programa que calcule el promedio de los valores contenido en el arreglo. En la salida debe especificar la puntuación total, cantidad de muestras y la puntuación promedio.


3- Escribir un programa que tome varios números por la consola y determinar cuál es el mayor.  La salida debe decir  'x es el mayor de los números digitados''. Sustituir variables x por valores reales.

4-Dado la siguiente lista 
```java
List<String> lista = Arrays.asList("Edificio, Casa, Escuela, Apartamento, Carro, Tienda,Farmacia");
```
Escribir programa que remueva de la lista todas las palabras que tengan longitud impar.

