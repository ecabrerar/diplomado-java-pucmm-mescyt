**Uso de ComboBox**


Un **JComboBox** permite al usuario elegir una de varias opciones. Por defecto, un Combo Box no es editable y cuenta con un botón y una lista desplegable de valores.

Si cambiamos las propiedades del Combo Box, lo podemos usar de forma editable. Un Combo Box editable cuenta con un campo de texto con un pequeño botón. El usuario puede escribir un valor en el campo de texto o hacer clic en el botón para mostrar una lista desplegable.

**JComboBox** stá  compuesto por 3 elementos , un objeto de la clase **ComboBox**, un objeto **ComboBoxModel** y los datos.

Esto implica que para mostrar los datos en un ComboBox debemos crear un ComboBoxModel.

Por  defecto un **JComboBox** tiene un ComboBoxModel que se llama **DefaultComboBoxModel**

Cuando usamos el editor de NetBeans este agrega automáticamente una instancia de la clase **DefaultComboBoxModel** con algunas valores iniciales.

Si queremos tener más control sobre nuestra aplicación debemos crear nuestro propio **ComboBoxModel**.

Para a crear un ComboBoxModel, creamos una nueva clase Java y extender de la clase abstracta AbstractListModel, la cual nos provee varios métodos necesarios para el ComboBoxModel.

Nuestra clase inicial :
```java
public class EjemploComboBoxModel extends AbstractListModel {

}
```


Luego implementamos los métodos que nos provee  AbstractListModel :

**1- int getSize()**:  debemos sobreescribirlo para que devuelva la cantidad de items que tiene el combo

**2- E getElementAt(int index):** debemos sobreescribirlo para que devuelva un elemento a partir de un indice dado.

Debemos agregar un List que utilizaremos contener los valores del combo model.

```java
 private final List<ClaseEjemplo> objects;

```

En el constructor agregamos los valores al combo model

```java
public EjemploTableModel() {
        
        objects =  new ArrayList<>();

        objects.add(new ClaseEjemplo(1,"Juan Perez","Santiago"));
	objects.add(new ClaseEjemplo(2,"Juana Peña","Santiago"));
    }
```

Poniendo todo junto

```java

public class EjemploComboBoxModel extends AbstractListModel {

     private final List<ClaseEjemplo> objects;

     public EjemploTableModel() {
        
        objects =  new ArrayList<>();

        objects.add(new ClaseEjemplo(1,"Juan Perez","Santiago"));
	objects.add(new ClaseEjemplo(2,"Juana Peña","Santiago"));
     }

    @Override
    public int getSize() {
        return objects.size();
    }

    @Override
    public Object getElementAt(int index) {
        return objects.get(index);
    }

}
```

El metodo **getElementAt(int index)** devuelve el dato del tipo Object y debemos de hacer la conversión a un objeto en específico.

```java
    @Override
    public Object getElementAt(int index) {
        return ((ClaseEjemplo)objects.get(index)).getNombre();
    }

```

Todavía falta algo para concluír con nuestro Combo Model, implementar la interfaz **ComboBoxModel**.

Dicha interfaz nos obliga a implementar los siguientes métodos.

**1- Object getSelectedItem()** Devuelve un valor seleccionado
**2- void setSelectedItem(Object anItem)** Nos permite agregar nuevos elementos al ComboBoxModel

```java

   @Override
    public Object getSelectedItem() {
        return selectedObject;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        
        if((selectedObject !=null && !selectedObject.equals(anItem)) ||
            selectedObject == null && anItem !=null){
            
            selectedObject = anItem; 
            fireContentsChanged(this, -1, -1);
        }
    }

```

Para obtener un valor del ComboBox Model es más conveniente agregar un método para tales fines.

```java
  
    public ClaseEjemplo getData(int index){
        return objects.get(index);
    }

```


Finalmente


```java

public class EjemploComboBoxModel extends AbstractListModel {

     private final List<ClaseEjemplo> objects;
     protected Object selectedObject = null; 

     public EjemploTableModel() {
        
        objects =  new ArrayList<>();

        objects.add(new ClaseEjemplo(1,"Juan Perez","Santiago"));
	objects.add(new ClaseEjemplo(2,"Juana Peña","Santiago"));
     }

    @Override
    public int getSize() {
        return objects.size();
    }

    @Override
    public Object getElementAt(int index) {
        return ((ClaseEjemplo)objects.get(index)).getNombre();
    }

     @Override
    public Object getSelectedItem() {
        return selectedObject;
    }

    public ClaseEjemplo getData(int index){
        return objects.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        
        if((selectedObject !=null && !selectedObject.equals(anItem)) ||
            selectedObject == null && anItem !=null){
            
            selectedObject = anItem; 
            fireContentsChanged(this, -1, -1);
        }
    }

}
```

Finalmente en el contructor del GUI donde vamos donde queremos usar el ComboBoxModel, le cargamos los datos al JComboBox:
```java
jComboBox1.setModel(new EjemploComboBoxModel());
```

si queremos podemos crear un metodo para hacerlo mas elegante:
```java
private void setData(){
    jComboBox1.setModel(new EjemploComboBoxModel());
}
```
Lo Llamamos desde el contructor:
```java
  public FrmEjemplo() {

    	initComponents();
    	this.setData();

}
```

**Ejemplo:**


Tenemos una clase llamada Auto que contiene las propiedades  **modelo, marca, anio y color.**

La clase Auto se representa de la siguiente forma.

```java

public class Auto {
    
    private String modelo;
    private Marca marca;
    private int anio;
    private Color color;

    public Auto(String modelo, Marca marca, int anio, Color color) {
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
        this.color = color;
    }
    
    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    } 
    
}


public enum Marca {
    TOYOTA,HONDA,KIA;
}

public enum Color {
    BLANCO,ROJO,NEGRO,GRIS;
}

```

Queremos crear un ComboBoxModel para poder desplegar un listado de autos en un **JComboBox**.

Creamos una clase **Java **y asignamos el nombre de **ComboModelAuto. **Debemos extender de la clase abstracta **AbstractListModel.** e implementamos la interfaz **ComboBoxModel**.

Clase Inicial

```java

public class ComboModelAuto extends AbstractListModel implements ComboBoxModel{

}

```
Definimos un List para los datos y una varible del tipo Object para el valor seleccionado.

```java
 
 private final List<Auto> objects;
 protected Object selectedObject = null; 

```
Como estamos extendiendo de AbstractListModel debemos de implementar los métodos abstractos **getSize(),**
**y getElementAt(int index)**.

```java

    @Override
    public int getSize() {
        return objects.size();
    }

    @Override
    public Object getElementAt(int index) {
        return ((Auto)objects.get(index)).getModelo();
    }

```

Ahora debemos implementar los métodos de ComboBoxModel : **setSelectedItem(Object anItem)** y **getSelectedItem()**.

```java

    @Override
    public void setSelectedItem(Object anItem) {
        
        if((selectedObject !=null && !selectedObject.equals(anItem)) ||
            selectedObject == null && anItem !=null){
            
            selectedObject = anItem; 
            fireContentsChanged(this, -1, -1);
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedObject;
    }

```
En el constructor vamos a cargar los datos al ComboBox Model

```java

   public ComboModelAuto() {
        
        objects =  new ArrayList<>();

        objects.add(new Auto("Camry", Marca.TOYOTA, 2009, Color.ROJO));
        objects.add(new Auto("Accord", Marca.HONDA, 2007, Color.NEGRO));
    }

```

Para obtener un valor del ComboBox Model es más conveniente agregar un método para tales fines.

```java

    @Override
    public Object getElementAt(int index) {
        return ((Auto)objects.get(index)).getModelo();
    }

```

Poniendo todo junto

```java
/**
 *
 * @author eudriscabrera
 */
public class ComboModelAuto extends AbstractListModel implements ComboBoxModel{
    
   private final List<Auto> objects;
   protected Object selectedObject = null; 

    public ComboModelAuto() {
        
        objects =  new ArrayList<>();

        objects.add(new Auto("Camry", Marca.TOYOTA, 2009, Color.ROJO));
        objects.add(new Auto("Accord", Marca.HONDA, 2007, Color.NEGRO));
    }

    
    @Override
    public int getSize() {
        return objects.size();
    }

    @Override
    public Object getElementAt(int index) {
        return ((Auto)objects.get(index)).getModelo();
    }
    
    public Auto getData(int index){
        return objects.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        
        if((selectedObject !=null && !selectedObject.equals(anItem)) ||
            selectedObject == null && anItem !=null){
            
            selectedObject = anItem; 
            fireContentsChanged(this, -1, -1);
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedObject;
    }
    
}

```

Si queremos asignarle nuestro **ComboModelAuto** a un JComboBox cualquier debemos hacerlo en el constructor del componente principal donde está el JComboBox.


**Ejemplo:**

```java

    public DgShowRoom(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        initComboAuto();

    }



   private void initComboAuto() {
        cbAuto.setModel(new ComboModelAuto());
        cbAuto.setSelectedIndex(-1);
    }

```

Para mayor información sobre el ejemplo anterior descargar abrir el proyecto (javase_swing_jcombobox)[javase_swing_jcombobox]

