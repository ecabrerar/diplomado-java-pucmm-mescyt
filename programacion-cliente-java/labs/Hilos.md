**Hilos**

**Concurrencia:** 

Dos tareas se dice que son concurrentes si transcurre durante el  mismo intervalo de tiempo.

**Programación concurrente:**

 Se entiende por programación concurrente el conjunto de técnicas y notaciones que sirven para expresar el paralelismo  potencial en los programas, así como resolver problemas de
 comunicación y sincronización.

Cuando se trabaja en entornos distribuidos o con máquinas con  múltiples procesadores, se suele hablar de programación  distribuida o paralela, respectivamente.

**Proceso:**  es un programa en ejecución con un estado asociado.

Las distintas aplicaciones que se pueden ejecutar en un  sistema operativo multitarea son procesos independientes .

 Cada proceso ocupa un espacio de memoria independiente (para no interferir con la ejecución de otros procesos).

Una aplicación puede implementarse como un conjunto de  procesos que colaboren entre sí para lograr sus objetivos, para lo que se pueden emplear distintos mecanismos de
 comunicación entre procesos.

**¿Por qué usar hilos y procesos?**

El no determinismo introducido por el entrelazado de las  operaciones de las distintas hilos o procesos de una aplicación  concurrente provoca la aparición de errores difíciles de detectar y
 más aún de corregir: la vida del programador resultaría mucho más sencilla si no hiciese falta la concurrencia.

Sin embargo, existen razones por las cuales es aconsejable utilizar  procesos e hilos:

**a) De cara al usuario:** Hilos y procesos permiten la creación de interfaces que
 respondan mejor a las órdenes del usuario.

**b) Aprovechamiento de los recursos del sistema:**  cualquier operación que pueda bloquear nuestra aplicación durante un período de tiempo apreciable es recomendable que se
 realice de forma independiente.

**Paralelismo real:**  Su aprovechamiento requiere el uso de hilos y procesos...

Un sistema multiprocesador dispone de varias CPUs.
Un cluster de ordenadores está compuesto por un conjunto de ordenadores conectados entre sí, a los que se accede como si se tratase de un único ordenador.

**c)Modularización: Paralelismo implícito**

A veces, los motivos que nos llevan a utilizar hilos o procesos
 no tienen una justificación física, sino que un programa puede
 diseñarse con más comodidad si lo descomponemos en un
 conjunto de tareas independientes.

**Ejecución de procesos:**

La máquina virtual Java nos aísla de los detalles particulares de la  máquina en la que se ejecutan nuestras aplicaciones. No obstante, La clase System nos permite acceder a recursos del sistema
 de forma portable (aunque de una forma muy rudimentaria):

*  Usar los dispositivos de E/S estándar 
   System.in & System.out

*  Acceder a algunas variables de entorno
  System.getProperties()

La clase **Runtime** nos permite ejecutar comandos del  sistema operativo y "controlar" la máquina virtual Java (ver cuánta memoria queda libre o forzar la ejecución del  recolector de basura, por ejemplo).

¡OJO! Para mantener la portabilidad de nuestras aplicaciones,  es aconsejable evitar, en la medida que sea posible, el uso de características específicas de un sistema operativo concreto.

La ejecución de procesos es responsabilidad del sistema operativo, del cual nos aísla la máquina virtual Java, si bien podemos usar la clase **Runtime**:

* Sólo existe una instancia de la clase Runtime, que se obtiene con:
  **Runtime rt = Runtime.getRuntime();**

* El objeto obtenido con la llamada a **Runtime.getRuntime()** nos permite ejecutar procesos con
 **rt.exec("miprograma");**

**Ejemplo (NO PORTABLE)**

```java

public class Procesos {

public static void main(String[] args)
   throws java.io.IOException  {

    Runtime rt = Runtime.getRuntime();

     rt.exec("cmd /c start iexplore http://elvex.ugr.es/");


}

}

```

Podemos evitar el uso del shell (cmd.exe) si especificamos la ruta completa del programa que deseamos ejecutar, p.ej.
c:/Archivos de Programa/Internet Explorer/iexplore.exe

Si estuviésemos usando UNIX, deberíamos haber escrito algo como:

**rt.exec("/usr/mozilla/mozilla-bin http://elvex.ugr.es/");**


En Windows, también podemos omitir el nombre del programa y  poner directamente la ruta del recurso al que queremos acceder (el shell del S.O. se encarga de buscar cuál es el programa adecuado):

```java

rt.exec("cmd /c start http://elvex.ugr.es/");

rt.exec("cmd /c start mailto:fberzal@decsai.ugr.es");

rt.exec("cmd /c apuntes.doc");

```

**Creación y ejecución de hilos en Java:**

La forma más sencilla de crear un hilo en Java es diseñar una  subclase de java.lang.Thread.
En la subclase redefinimos el método run(), que viene a ser  algo así como el main() de un hilo.

Para comenzar la ejecución paralela de la nueva Hilo, usaremos  su método start().

```java
public class HiloContador extends Thread {

 private int contador = 10;

 private static int Hilos = 0;

 // Constructor

 public HiloContador()  {

   super("Hilo " + ++Hilos);

 }

 // Salida estándar

 public String toString()  {

   return getName() + ": " + contador;

 }

 // Ejecución de la Hilo

 public void run() {

   while (contador>0) {

         System.out.println(this);

         contador--;

   }

 }

 //Programa principal

 public static void main(String[] args)  {

   int    i;

   Thread Hilo;

   for (i = 0; i < 5; i++)
       Hilo = new HiloContador();
       Hilo.start();

   }

 }

}
```

Como Java sólo soporta herencia simple y puede que el objeto que representa nuestra Hilo sea mejor implementarlo como  subclase de otra clase de nuestro sistema, Java nos permite crear
 una Hilo a partir de cualquier objeto que implemente la interfaz  Runnable, que define únicamente un método run():

```java

public class Contador implements Runnable {

 private String id;

 private int    contador = 10;

 private static int Hilos = 0;

 public Contador() {

    hilos++;

   id = "Hilo " + Hilos;

 }

 public void run() {

   while (contador>0) {

         System.out.println(this);

         contador--;

         try {

             Thread.sleep(1000);

         } catch (InterruptedException e) {

         }

   }

 }

 public static void main(String[] args)  {

   int    i;

   Thread Hilo;

   for (i = 0; i < 5; i++) {

     hilo = new Thread ( new Contador() );

     hilo.start();

   }

 }

}

```

**La prioridad de los hilos**

La prioridad de un hilo le indica al planificador de CPU la  importancia de un hilo, de tal modo que le asignará más tiempo de CPU a los hilos de mayor prioridad.

La prioridad de un hilo se cambia con una llamada al método  setPriority(), usualmente en el constructor del hilo:

```java

public class HiloContador extends Thread {

...

  public HiloContador (int prioridad)  {

    super("Hilo " + ++hilos);

    setPriority (prioridad);

  }

```

Por defecto, la prioridad de los hilos es  Thread.NORM_PRIORITY

En el siguiente fragmento de código, el último hilo que  lanzamos se ejecutará "antes" que los demás:

```java

  int  i;

  Thread hilo;

  for (i = 0; i < 5; i++) {

      hilo  = new HiloContador (Thread.MIN_PRIORITY);

       hilo.start();

  }

  hilo = new HiloContador (Thread.MAX_PRIORITY);

  hilo.start();
```

Cuando en nuestra aplicación tenemos varios hilos ejecutándose, les daremos mayor prioridad aquellos hilos cuyo tiempo de  respuesta deba ser menor.

**Finalización de la ejecución de un hilo**

Se puede utilizar el método join() de la clase Thread para  esperar la finalización de la ejecución de un hilo:

```java

private static final int N = 5;

public static void main(String[] args){

 int    i;

 Thread Hilo[] = new Thread[N];

 for (i=0; i<N; i++) {

   hilo[i] = new HiloContador(Thread.NORM_PRIORITY);

   hilo[i].start();

 }

 for (i=0; i<5; i++) {

     try {

       hilo[i].join();

     } catch (InterruptedException e) {

     }

     System.out.println (Hilo[i]+" ha terminado");

   }

   System.out.println
("El programa principal ha terminado");

 }
```
