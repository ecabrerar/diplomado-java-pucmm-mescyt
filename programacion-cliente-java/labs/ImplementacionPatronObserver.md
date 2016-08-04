**Implementación Patron Observer**

Muchas veces queremos pasar información de una ventana a otra usando Java Swing.

Es probable que existan varias formas de realizar tal operación, pero voy a enfocarme en una solución probado y conocida ampliamente en el desarrollo de software.

Me refiero a la utilización de un patrón de diseño llamado **_Patrón Observer (Observador)_**. Este patrón proporciona a los componentes una forma flexible de enviar mensajes de difusión a los receptores interesados.

En clase anteriores hicimos referencia a los [Patrones Diseños](IntroPatronesDisenos.md) como la base para la búsqueda de soluciones a problemas comunes en el desarrollo de software y otros ámbitos referentes al diseño de interacción o interfaces.


**Patrón Observer**

**Descripción**

Nombre

* Observador

* También conocido como **publisher–subscriber** (editor-subscriptor), 	Dependents (dependientes)

**Propiedades**

* Tipo: comportamiento

* Nivel: objeto, componente

Permite definir dependencias uno-a-muchos de forma que los cambios en un objeto se comuniquen a los objetos que dependen de él.

**Aplicabilidad**

Este patrón se usa cuando:

Existe al menos un emisor de mensajes.

Uno o más receptores de mensajes podrían variar dentro de una aplicación o entre aplicaciones.

Si se produce un cambio en un objeto se requiere el cambio de otros y no se sabe cuántos se necesitan cambiar. No queremos que estén fuertemente acoplados.

En el API de Java tenemos la interfaz Observer y la clase Observable. Esto permite que muchos objetos reciban eventos de otro objeto en lugar de los sistemas de eventos básicos que sólo permiten notificar a un único objeto.

**Estructura**

Los elementos que participan en este patrón son los siguientes:

* Sujeto (Observado): Interfaz que define cómo pueden interactuar los observadores con el sujeto. Define métodos para añadir y quitar observadores y avisarles de que se han producido cambios en el sujeto.

* SujetoConcreto: Implementa la interfaz Sujeto. Contiene una lista de observadores a los que avisa cuando cambia su estado.
	

* Observador: Interfaz para actualizar los objetos ante cambios en un sujeto.

* ObservadorConcreto: Mantiene una referencia a un objeto SujetoConcreto. Implementa la interfaz Observador y define los métodos para responder a los mensajes recibidos del sujeto.

**Consecuencias**

1. Desacoplamiento entre sujetos y observadores, convirtiéndolos en entidades reutilizables por separado.

2. Es un medio muy flexible de distribuir la información desde un objeto a muchos, de forma dinámica en tiempo de ejecución y sin que las clases implicadas sean conscientes del resto.

3. El sujeto puede incluir cierta información en el mensaje de actualización de forma que cada observador pueda decidir si el cambio de estado le afecta o no.

4. Un sujeto puede ser a su vez observador respecto de otros.

5. Un problema es que un pequeño cambio en el sujeto puede provocar mucho procesamiento en los observadores.

En el ejemplo [javase_swing_jtable](javase_swing_jtable) hicimos la implementación del patrón observador.

Primeramente creamos una interfaz llamado **ISubject** que representa al sujeto. Esta Interfaz define cómo pueden interactuar los observadores con el sujeto. Define métodos para añadir y quitar observadores y avisarles de que se han producido cambios en el sujeto.
```java
public interface ISubject {

 	List<IObserver> observers = new ArrayList<>();

 	void addObserver(IObserver observador);

 	void removeObserver(IObserver observador);

 	void notify(Class clase,Object argumento,String mensaje);

}
```
Luego definimos la interfaz **IObserver**, la cual usaremos para actualizar los objetos ante cambios en un sujeto.
```java
public interface IObserver {

	void update(Class clase,Object argumento,String mensaje);

}
```
Implementamos la interfaz **ISubject** en el formulario **DgAddCar** que captura los datos de un carro y lo enviará al observador que será representado por el formulario **DgShowRoom.**
```java
public class DgAddCar extends javax.swing.JDialog implements ISubject{

  ....

	@Override

	public void addObserver(IObserver observador) {

    		observers.add(observador);
     	 

	}

	@Override

	public void removeObserver(IObserver observador) {

   		observers.remove(observador);

	}

	@Override

	public void notify(Class clase, Object argumento, String mensaje) {

	    	for (IObserver observer : observers) {

			observer.update(clase, argumento, mensaje);

	    	}

	}

}
```
Como podrás notar, hemos implementados los 3 métodos de la interfaz **ISubject.**

El método **notify(Class clase, Object argumento, String mensaje)** contiene la lógica para enviar los mensajes al observador.
```java
public class DgShowRoom extends javax.swing.JDialog implements IObserver{

@Override

public void update(Class clase, Object argumento, String mensaje) {

 	 

    	if("show_room".equals(mensaje)){

        	TableModelAuto tmAuto = (TableModelAuto) jTable1.getModel();

        	tmAuto.setValueAt((Auto)argumento, jTable1.getRowCount(), jTable1.getRowCount());

        	JOptionPane.showMessageDialog(this,"Mensaje", "Registro Agregado", JOptionPane.INFORMATION_MESSAGE);

    	}

	}

}
```
El método **update** actualiza el JTable y muestra los datos enviados por el formulario que captura los datos.

Ahora solamente resta habilitar tanto el sujeto como el observador para que intercambien información.

Nosotros queremos que al pulsar el botón **Agregar**  en el formulario **DgShowRoom** se abra una ventana de **DgAddCar**, entonces, al momento de crear la instancia, debemos decirle que será observado.
```java
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

    	DgAddCar add = new DgAddCar(new JFrame(), true);

    	add.addObserver(this);

    	add.setVisible(true);

} 
```
En el formulario **DgAddCar **queremos que al pulsar el botón **Aceptar** se envíen los datos al formulario  **DgShowRoom** y se actualice el JTable.
```java
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

    	Auto auto = getAutoDesdeComponente();

    	if (auto == null) {

        	JOptionPane.showMessageDialog(this,

                	"Mensaje", "Revise su codigo", JOptionPane.INFORMATION_MESSAGE);

    	} else {

        	notify(getClass(), auto, "show_room");

        	dispose();

   

    	}

} 
```
Es importante analizar cuidadosamente la función de los métodos **update** y **notify.**

Para mayor información sobre el ejemplo anterior descargar y abrir el proyecto  [javase_swing_jtable](javase_swing_jtable)
