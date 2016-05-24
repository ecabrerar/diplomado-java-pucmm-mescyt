###Diplomado en Lenguaje JAVA (PUCMM ­ MESCYT)

Por Eudris Cabrera Rodríguez
 
Nota: Tomar como base el proyecto **javase_colecciones_map_set**

1-  **CalculadoraPrespuesto** es un programa que recibe del usuario el monto presupuestado a gastar en un mes, luego toma todos los gastos fijos que tiene el usuario y saca un balance de lo presupuestado versus lo gastado.
Si el balance es menor que cero, el sistema despliega el siguiente mensaje. **“Ha excedido lo presupuestado por RD$xxx.x pesos”**.
Si el balance es mayor de cero el sistema despliega el siguiente mensaje **“Todavía está dentro de lo presupuestado, puedes gastar RD$xxx.x pesos”** .
Si el balance es igual a cero, el sistema despliega el siguiente mensaje **“Gastaste exactamente lo presupuestado”**.

Usando la clase **CalculadoraPrespuesto** ubicada en mencionado proyecto, escribir programa que cumpla con el escenario planteado. El programa termina al escribir un valor negativo.

Sustituir xxx.x por valores reales.

2- Dado la siguiente lista 
```java
List<String> lista = Arrays.asList("Edificio", "Casa", "Escuela", "Apartamento", "Carro", "Tienda","Farmacia","Supermercado","Plaza","Cine","Hotel" ); 
```
Escribir programa que tome de la lista todas las palabras que tengan longitud par y se agreguen a un set.
```java
Set<String> pares = new new HashSet<String>();
```
Luego recorrer el set y desplegar el contenido por la salida estándar.

3- Dado la siguiente lista 
```java
List<Persona> personas = new ArrayList<>();
        
        personas.add(new Persona("Rita", "Perez", Genero.FEMENINO, 15));
        personas.add(new Persona("Maria", "Rosa", Genero.FEMENINO, 25));
        personas.add(new Persona("Luz", "Santos", Genero.FEMENINO, 30));
        personas.add(new Persona("Juan", "Perez", Genero.MASCULINO, 55));
        personas.add(new Persona("Victor", "Martinez", Genero.MASCULINO, 32));
        personas.add(new Persona("Rafael", "Santos", Genero.MASCULINO, 47));
        personas.add(new Persona("Manuel", "Cabral", Genero.MASCULINO, 0));
        personas.add(new Persona("Marta", "Rodriguez", Genero.FEMENINO, 18));      
        personas.add(new Persona("Andres", "Jimenez", Genero.MASCULINO, 52));
        personas.add(new Persona("Hector", "Perez", Genero.MASCULINO, 51));
```
Convertir los elementos de la lista a un Map, donde la llave (key) es la concatenación de la posición del elemento dentro de la lista y el nombre y apellido.

```java
Map<String, Persona> mapPersonas = new HashMap<String,Persona>();
```
4-Dado la siguiente lista 
```java
List<String> lista = Arrays.asList("Edificio", "Casa", "Escuela", "Apartamento", "Edificio", "Tienda","Farmacia","Apartamento","Plaza","Farmacia","Hotel" ); 
```

Escribir programa que retorne un HashMap que contenga la palabra y la cantidad de veces que aparece en la lista.

5- Dado la siguiente lista 
```java
List<String> lista = Arrays.asList("Edificio", "Casa", "Escuela", "Apartamento", "Carro", "Tienda","Farmacia","Supermercado","Plaza","Cine","Hotel" ); 
```

Escribir programa que retorne la palabra de mayor longitud dentro de la lista;

6-Dado la siguiente lista
```java
List<Integer> years = Arrays.asList(1946, 1988, 1970, 1931, 1940, 1920, 1980, 1953, 1960, 1974, 1987);
```
      
Escribir programa que retorne el valor máximo (mayor) dentro de la lista;
