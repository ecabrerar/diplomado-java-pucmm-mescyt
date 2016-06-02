###Diplomado en Lenguaje JAVA (PUCMM ­ MESCYT)

Por Eudris Cabrera Rodríguez
 

Nota: Crear proyecto desde cero en NetBeans y seguir las estructuras de paquetes que hemos utilizado anteriormente.. 

1- Se desea tener un listado ordenado de los nombres y los tiempos de cada corredor que participa en un maratón. Del corredor se desea saber el nombre, edad y el tiempo que tomó para finalizar la carrera.

Escribir un programa que pida por consola los nombres y edades de los corredores y el tiempo que tomó  a cada uno de ellos para terminar una carrera. El programa debe mostrar los nombres de los corredores en el orden en que terminaron.

El programa deja de pedir datos por la consola si se digita un valor negativo.

Consejo:
Almacenar temporalmente el listado de corredores en una lista y usar **Collections.sort** y **Comparator**.

2- Escenario:  
 
Se desea llevar el registro de jugadores y equipos que puede tener una liga deportiva.
La liga puede tener uno o más equipos, pero un  equipo solo puede pertenecer a una liga. 

Un equipo puede puede tener uno o más jugadores y un jugador puede pertenecer a uno o más equipos, para determinar el equipo en el cual se encuentra activo un jugador debemos tomar en cuenta la fecha de ingreso y la fecha de salida.
 
Se desea modelar el escenario anterior en un diseño de clases. 
Además debemos incluir funcionalidades para imprimir el listado de liga, equipos y jugadores.

3- **Combustible App**  es una herramienta que nos permite visualizar los precios de los
combustibles.

Dado el proyecto **java_combustible_app** se desea realizar lo siguiente:
Que el usuario digite algunas de las siguientes palabras, gasolina, gasoil, glp, gnv, kerosene y
esta le muestre el precio de dicho combustible.

Actualmente muestra un listado de todos los combustibles, se desea que solo muestre el deseado.
 
**Ejemplo:**
Datos de Entrada y salida:
 
Bienvenido a Combustible App
 
Escriba el tipo combustible:   glp
Descripción:   Gas Licuado de Petróleo (GLP)

Precio:   83.20
 
Continuar ? (y/n): y

Si el usuario digita una opción inválido debe mostrar mensaje diciendo que es una opción inválida. 

Además  si el usuario digita el tipo de combustible en mayúscula o minúscula debe presentar  en pantalla la opción seleccionada.
 
**Consejo:**
Ya se tiene la forma de capturar el parámetro digitado, usted debe crear la lógica en nuestra
fuente de datos **CombustibleDB** que pasado como parámetro el texto digitado, permita filtrar
por el mismo.
