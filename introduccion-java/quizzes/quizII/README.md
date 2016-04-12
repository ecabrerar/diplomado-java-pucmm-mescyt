# Diplomado en Lenguaje JAVA (PUCMM-MESCYT)
## QUIZ II

* Analice el siguiente pedazo de código List<Telefono> telefonos = new ArrayList<Telefono>(); telefonos.add(tel1); telefonos.add(tel2); telefonos.remove(tel1); y explique el comportamiento que tendría el programa. 
> Respuesta : Inicialmente se agregan dos elementos a la lista y luego se remueve el primer elemento. El tamaño final de la lista es de 1 elemento.

* Cuál es la ventaja de ​ArrayList ​sobre un ​array​ (Arreglo) común ? 
> Respuesta : La ventaja de ​ArrayList ​sobre un ​array​ común es que es expandible, es decir que crece a medida que se le añaden elementos (mientras que el tamaño de un array es fijo desde su creación). 


* Dado la siguiente lista List<Telefono> telefonos = new ArrayList<Telefono>();, escriba la sentencia que nos permite saber el tamaño de dicha lista. 
> Respuesta : telefonos.size();

* Escriba un enum que al ejecutar el siguiente código for (Marca marca : Marca.values()) { System.out.println(marca);}. Muestre como salida : TOSHIBA, HP, DELL, SONY 

> Respuesta :

public enum Marca {
  TOSHIBA,HP, DELL, SONY
}


* Dado el siguiente pedazo de código Collection<String> col = new ArrayList<>(); col.add("Java"); col.add("C++"); . Escribir sentencias para desplegar por pantalla todos los elementos de la lista usando un ciclo mejorado(foreach, for mejorado) 

> Respuesta :

for(String elem: col){
  System.out.println(elem);
}

* Es todo aquello que se puede recorrer (o ​“iterar”​) y de lo que se puede saber el tamaño. 

> Respuesta : Colección
