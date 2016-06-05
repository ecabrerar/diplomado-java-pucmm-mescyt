**Centrar  componentes JDialog y JFrame en la pantalla.**

Cuando estamos desarrollando una aplicacion cliente servidor nos gusta centrar los formularios en el centro de la pantalla.

Para centrar un JDialog necesitamos conocer el tamaño de nuestro formulario (**JDialog**) y el tamaño de la pantalla (**Monitor**).

**Ejemplo:**

Definimos el JDialog que queremos centrar:

JDialog dialog  = new JDialog(new JFrame(), true); 

 //JDialog necesita un JFrame para su ejecución por eso pasamos el JFrame en el constructor

Luego obtener la dimensión(Ancho y Alto) del JDialog

 Dimension d = dialog.getSize();

//La clase Dimension nos permite obtener el ancho y la altura.

Nuestro próximo paso es obtener la dimensión de la pantalla

Dimension d1 = dialog.getToolkit().getScreenSize();

Tenemos la dimensión del formulario y la pantalla.

Para obtener el centro de la pantalla lo hacemos haciendo el siguiente cálculo.

**Restar la dimension del JDialog a la dimension de la pantalla y la dividimos entre dos.**

(d1.width-d.width)/2, (d1.height-d.height)/2

Ahora con el método **setLocation **ubicamos el formulario en el centro de la pantalla.

 dialog.setLocation((d1.width-d.width)/2, (d1.height-d.height)/2);

Poniendo todo junto.

Crear una clase y llamarla **CentrarJDialog** y definir su método main.

public class CentrarJDialog {

public static void main(String[] args) {

    	

	}

}

Luego definir el **JDialog** que deseamos centrar y ponerle un tamaño de **300 de ancho** y **200 de alto**.

JDialog dialog  = new JDialog(new JFrame(), true);

dialog.setSize(300, 200); //Tamaño del Dialog

Obtener la dimensión del **JDialog** y de la pantalla

Dimension d = dialog.getSize();

Dimension d1 = dialog.getToolkit().getScreenSize();

Agregar valores al método **setLocation**

 dialog.setLocation((d1.width-d.width)/2, (d1.height-d.height)/2);

Debemos especificar que queremos que el JDialog sea visible.

 dialog.setVisible(true);

Si no se especifica el método **setVisible **con valor **true **el JDialog no se mostrará.

Final:

import java.awt.Dimension;

import javax.swing.JDialog;

import javax.swing.JFrame;

/**

 *

 * @author ecabrerar

 */

public class CentrarJDialog {

    

	public static void main(String[] args) {

    	JDialog dialog  = new JDialog(new JFrame(), true);

    	dialog.setSize(300, 200); //Tamaño del Dialog

   	 

     	Dimension d = dialog.getSize();

     	Dimension d1 = dialog.getToolkit().getScreenSize();

    	dialog.setLocation((d1.width-d.width)/2, (d1.height-d.height)/2);

    	dialog.setVisible(true);

	}

}

El **JFrame** por lo regular se utiliza como formulario principal o ventana principal y es conveniente usarlo **maximizado**. Esto es porque casi siempre contiene informaciones del menú y configuraciones.

Para maximizar el **JFrame** usamos el método **setExtendedState** y especificamos que lo haga tanto horizontal como vertical.

**frame****.****setExtendedState****(****JFrame****.****MAXIMIZED_BOTH****);**

Poniendo todo junto.

Crear una clase y llamarla **CentrarJFrame** y definir su método **main**.

public class CentrarJFrame {

	public static void main(String[] args) {

   	 

	}

}

Definir el JFrame que queremos maximizar y le ponemos un título

 JFrame frame = new JFrame();

  frame.setTitle("Frame Centralizado");

Luego ponemos los valores al método **setExtendedState** y especificando que lo haga tanto horizontal como vertical.

**frame****.****setExtendedState****(****JFrame****.****MAXIMIZED_BOTH****);**

Debemos especificar que queremos que el JDialog sea visible.

 **frame**.setVisible(true);

Si no se especifica el método **setVisible **con valor **true **el JFrame no se mostrará.

Final:

import javax.swing.JFrame;

/**

 *

 * @author ecabrerar

 */

public class CentrarJFrame {

	public static void main(String[] args) {

   	JFrame frame = new JFrame();

   	frame.setTitle("Frame Centralizado");

   	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

   	frame.setVisible(true);

  	 

	}

}

Si vamos a necesitar centrar formularios frecuentemente es recomendable crear una clase utilitaria con varios métodos que nos permite realizar las dos operaciones anteriores.

Podemos crear una clase que se llame **UtilPantalla **que contenga una sobrecarga de constructores para recibir tanto un **JDialog** como un **JFrame**.

public class UtilPantalla {

	private JDialog dialog;

	private JFrame frame;

	public UtilPantalla(JDialog dialog) {

    	this.dialog = dialog;

	}

	public UtilPantalla(JFrame frame) {

    	this.frame = frame;

	}

	

}

Luego de eso creamos el método para centrar **JDialog**

public void centrar(){

    	//Obtener la dimension del JDialog

    	Dimension d = dialog.getSize();

    	//Obtener la dimension de la pantalla

    	Dimension d1 = dialog.getToolkit().getScreenSize();

   	 

    	dialog.setLocation((d1.width-d.width)/2, (d1.height-d.height)/2);

}

Y a continuación el método para los JFrame.

public void maximizar(){

    //En el caso de los JFrame se recomienda usar la siguiente sintaxis.

    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

}

Poniendo todo junto 

import java.awt.Dimension;

import javax.swing.JDialog;

import javax.swing.JFrame;

/**

 *

 * @author ecabrerar

 */

public class UtilPantalla {

	private JDialog dialog;

	private JFrame frame;

	public UtilPantalla(JDialog dialog) {

    	this.dialog = dialog;

	}

	public UtilPantalla(JFrame frame) {

    	this.frame = frame;

	}

    

	public void centrar(){

    	//Obtener la dimension del JDialog

    	Dimension d = dialog.getSize();

    	//Obtener la dimension de la pantalla

    	Dimension d1 = dialog.getToolkit().getScreenSize();

   	 

    	dialog.setLocation((d1.width-d.width)/2, (d1.height-d.height)/2);

	}

    

	public void maximizar(){

    	//En el caso de los JFrame se recomienda usar la siguiente sintaxis.

    	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

}

La forma de uso es la siguiente :

UtilPantalla scr = new UtilPantalla(frame); //Se debe pasar la instancia del JFrame

scr.maximizar();

UtilPantalla scr = new UtilPantalla(dialog); //Se debe pasar la instancia del JDialog

scr.centrar();

