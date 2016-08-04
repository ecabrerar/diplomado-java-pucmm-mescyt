##Recomendaciones Generales

A continuación un listado de reglas básicas que debemos seguir cuando estamos desarrollando una aplicación cliente servidor en Java.

* Validación de entrada de datos
  
Nuestra aplicación debe ser capaz de detectar posibles errores por parte del usuario a la hora de proceder a llenar cualquier formulario. Validando los datos que son obligatorios nos aseguramos que nuestra aplicación no colapse al momento de experimentar una entrada de dato errónea.

```java

  if(txtModelo.getText().isEmpty()
                || txtAnio.getText().isEmpty()
                || cbMarca.getSelectedIndex()==-1
                || cbColor.getSelectedIndex()==-1
                ){


....
}

```

Además de validar la entrada de datos, debemos realizar validaciones antes de hacer cualquier conversión de tipos u obtener los valores de una variable cualquiera, para evitar excepciones por valores nulos.

```java

      if(a==null){
         ...
        }else {
                    
          ....
        }

```

* Informar al usuario cuando ocurre una entrada de datos incorrecta o un error en la aplicación.

El usuario debe siempre estar informado de lo que pasa en la aplicación. Mostrar mensajes de alerta siempre es una buena práctica.

```java

        if(txtModelo.getText().isEmpty()
                || txtAnio.getText().isEmpty()
                || cbMarca.getSelectedIndex()==-1
                || cbColor.getSelectedIndex()==-1
                ){
            JOptionPane.showConfirmDialog(this, "Mensaje del Sistema", "Campos en blanco", JOptionPane.ERROR_MESSAGE);
        } else {
            
      		.....
        }



        if(a==null){
            JOptionPane.showMessageDialog(this, 
                    "Mensaje", "Llamar a mesa de ayuda", JOptionPane.INFORMATION_MESSAGE);
        }else {
          .....          
          
        }
        

```


* Manejo correcto de recursos

Cuando estamos trabajando con archivos, conexiones a base de datos, socket, etc., debemos manejar correctamente los recursos correspondientes a cada uno de estos casos, esto es, cerrar cada recursos luego de su uso para evitar problemas posteriores, como anidamientos de conexiones.


A partir de Java SE 7 se introdujo una forma sencilla de manejar los recursos **try-with-resources**.

Ejemplo:

```java

     try (Connection con = ConeccionDB.getInstancia().getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement(sqlInsert)) {
                stmt.setString(1, usuario.getNombre());
                stmt.setString(2, usuario.getApellido());
                stmt.setString(3, usuario.getUsuario());
                stmt.setString(4, usuario.getClave());

                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, ex.getMessage());
        }


```
Usando el try de esa forma nos aseguramos de que el recurso quede cerrado luego de su uso.
Esto es posible a que las clases anteriores implementa la interfaz **AutoClosable**. Se podrá utilizar **try-with-resources** siempre que implementen la **AutoClosable**.

* Cuestiones de Estilo

Escribimos código para que lo puedan leer otras personas, no sólo para que lo traduzca el compilador. 

Por tal motivo debemos seguir las recomendaciones de buenas prácticas

| Nombre | Convención |
| ------ | ----------- |
| Nombre de clase | Debe comenzar con letra mayúscula y ser un sustantivo, por ejemplo, Carro , Color, Boton, Sistema, Hilo, etc. |
| Nombre de interfaz | Debe comenzar con letra mayúscula y ser un adjetivo, por ejemplo, Runnable, Remote, ActionListener, etc. |
| Nombre de método | Debe comenzar con letra minúscula y ser un verbo, por ejemplo, actionPerformed (), main(), print (), println (), etc. |
| Nombre de variable | Debe comenzar con letra minúscula, por ejemplo, primerNombre, codPais, etc. |
| Nombre de paquete | Debe estar en letra minúscula, por ejemplo,java, lang, sql, util etc |
| Nombre de constantes | Debe estar en letra mayúscula. por ejemplo, ROJO, AMARILLO, MAX_PRIORITY, etc |


**Comentarios descriptivos:** 
Los comentarios deben comunicar algo. Jamás se utilizarán para *parafrasear* el código y repetir lo 
que es obvio. 

* Control de Acceso 

Asegurarse que las variables y métodos tengan especificado el control de acceso correcto. 

* Crear clase con elementos comunes y heredar en clases específicas.

Por ejemplo, podemos tener una clase abstracta con los elementos comunes en todos los tables models.
```java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ecabrerar
 */
public abstract class AbstractTableModelStandard extends AbstractTableModel{
    
    private List<?> dataArray;
    private final List<String>  columnas = new ArrayList<>();

    public AbstractTableModelStandard(String[] nombreColumnas, List<?> data) {
            
         columnas.addAll(Arrays.asList(nombreColumnas));        
                       
        this.dataArray = data;
    } 
   
    public AbstractTableModelStandard(String[] nombreColumnas){
       
         columnas.addAll(Arrays.asList(nombreColumnas));
    }
    
   protected List<?> getData(){
       return dataArray;
   }
   
   
   public void setData(List<?> data){
       this.dataArray=data;
   }
   
   public Object getRow(int row){
        return dataArray.get(row);
    }
 
    
    @Override
    public int getRowCount() {
        return dataArray.size();
    }

    @Override
    public int getColumnCount() {
       return columnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Debe sobreescribir este metodo");
    }
    
}


```
La clase anterior reune todos métodos comunes y en las clases hijas solo tenemos que sobre escribir el método  **getValueAt(int rowIndex, int columnIndex)**.

Creando una clase específica a partir de nuesta clase **AbstractTableModelStandard**

```java

/**
 *
 * @author ecabrerar
 */
public class TableModelAutoMejorada extends AbstractTableModelStandard {

    public TableModelAutoMejorada() {
        super(new String[]{"Modelo", "Marca", "Año", "Color"});

        super.setData(Arrays.asList(new Auto("Camry", Marca.TOYOTA, 2009, Color.ROJO),
                                   new Auto("Accord", Marca.HONDA, 2007, Color.NEGRO)));

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto a = (Auto) getData().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return a.getModelo();
            case 1:
                return a.getMarca();
            case 2:
                return a.getAnio();
            case 3:
                return a.getColor();
            default:
                return null;
        }

    }

}
```

También podemos hacer un ComboModel que reuna todos los elementos comunes.

```java
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ecabrerar
 */
public class ComboBoxModelStandard<T> extends AbstractListModel implements ComboBoxModel {

    private List<T> dataArray = new ArrayList<>();

    public ComboBoxModelStandard() {    } 

    public ComboBoxModelStandard(List<T> data) {
        this.dataArray = data;
    } 
    

    /**
     * The current selected object.
     */
    protected Object selectedObject;

    // implementation of javax.swing.ComboBoxModel
    /**
     * Set the value of the selected item. The selected item may be null.
     * <p>
     * @param anObject The combo box value or null for no selection.
     */
    @Override
    public void setSelectedItem(Object anObject) {
        if ((selectedObject != null && !selectedObject.equals(anObject))
                || selectedObject == null && anObject != null) {
            selectedObject = anObject;
            fireContentsChanged(this, -1, -1);
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedObject;
    }

    @Override
    public int getSize() {
        return dataArray.size();
    }

    @Override
    public Object getElementAt(int index) {
        return dataArray.get(index);
    }

    public T getData(int index) {
        return dataArray.get(index);
    }

    public void setData(List<T> dataArray) {
        this.dataArray = dataArray;
    } 
    

}



```
Haciendo implementaciones de nuestra clase **ComboBoxModelStandard**.

```java

/**
 *
 * @author ecabrerar
 */
public class ComboModelAutoMejorado extends ComboBoxModelStandard<Auto>{

    public ComboModelAutoMejorado() {
        
        List<Auto> objects = new ArrayList<>();

        objects.add(new Auto("Camry", Marca.TOYOTA, 2009, Color.ROJO));
        objects.add(new Auto("Accord", Marca.HONDA, 2007, Color.NEGRO));
        
        setData(objects);
    } 
    
}


```

Los ejemplos anteriores pueden encontrarlo en los proyectos [javase_swing_jtable](javase_swing_jtable) y [javase_swing_jcombobox](javase_swing_jcombobox).

* Separar en clases diferentes los métodos que tienen que ver con interacción con la base de datos. 

Yo recomiendo un mínimo de 4 métodos por clases.

Ejemplo:

```java

public class ServicioUsuario {

    public void salvar(Usuario usuario) {
	....
    }

    public void modificar(Usuario usuario) {
 	.....
    }

    public List<Usuario> consultarTodos() {
 	....
    }
    
    public Usuario consultarPorId(){ 
        .....
    }
}


```

* Usar el patrón singleton (instancia única) para instanciar nuestras clases.

Crear nuevos objetos cada vez que vamos a crear una clase nueva puede resultar en un alto consumo de memoria.

Es recomendable crear una instancia única al momento de crear un objeto.

Ejemplo:

```java
 **
 *
 * @author ecabrerar
 */
public class ServicioUsuario {
    
    private static final ServicioUsuario INSTANCIA = new ServicioUsuario();
    
    private ServicioUsuario() {}
    
    public static ServicioUsuario getInstancia(){
        return INSTANCIA;
    }
......
}
```
Haciendo el constructor de la clase privada nos aseguramos de que siempre tengan que usar el método **getInstancia()**
para construir objetos de la clase **ServicioUsuario**.

```java
ServicioUsuario.getInstancia().salvar(usuario);

List<Usuario> listaUsuarios = ServicioUsuario.getInstancia().consultarTodos();

```

Otra forma de crear una instancia única es la siguiente.


```java

public class ServicioUsuario {
    
     private static  ServicioUsuario INSTANCIA_UNICA = null;

     public static ServicioUsuario getInstanciaUnica(){
         
         if(INSTANCIA_UNICA==null){
             INSTANCIA_UNICA = new ServicioUsuario();
         }
        return INSTANCIA_UNICA;
    }
 .............
}

```

```java
ServicioUsuario. getInstanciaUnica().salvar(usuario);

List<Usuario> listaUsuarios = ServicioUsuario. getInstanciaUnica().consultarTodos();

```
* Encapsular las propiedades de las clases.

Esto significa crear métodos para acceder a las propiedades internas de las clases. Esto permite a que se pueda acceder a las propiedades de una clase a través de las interfaces sin que se conozca el estado interno de las propiedades.


Ejemplo:
```java
/**
 *
 * @author ecabrerar
 */
public class Usuario {
    private int codigo;
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}

```

Podemos acceder a las propiedades de la clase **Usuario** a través de los métodos setter y getter pero no podemos acceder las propiedas directamente.

Esto provee las siguientes ventajas: 
 
1. Oculta los detalles de implementación de una clase. 
2. Obliga al usuario a utilizar una interfaz para acceder a los datos. 
3. Hace que el código sea más fácil de mantener. 

* Manejo de Excepciones

 * Gestionar correctamente todas o la mayor parte de los errores que se pueden producir.
 * Evitarn mostrar al usuario los mismos mensajes generados por las excepciones, en su lugar colocar mensajes   personalizados que el usuario final pueda entender sin problemas.
 * Crear clases personalizadas para manejar nuestras excepciones.
    

```java
/**
 *
 * @author ecabrerar
 */
public class ExcepcionJdbcMySQL extends Exception{

    public ExcepcionJdbcMySQL() {
    }

    public ExcepcionJdbcMySQL(String message) {
        super(message);
    }

    public ExcepcionJdbcMySQL(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionJdbcMySQL(Throwable cause) {
        super(cause);
    }

    public ExcepcionJdbcMySQL(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

```

* Usar el patrón Observer para intercambiar datos entre formularios.
Ver guía [Implementación Patron Observer](ImplementacionPatronObserver.md).

* Convertir contraseña a MD5

```java
Es muy importante no almacenar data sencible como texto plano, un caso muy común es la contraseña.

A continuación una forma de convertir una cadena de caracteres a MD5.

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

/**
 *  
 * @author ecabrerar
 * @date Aug 4, 2016
 */
public class Util {

    private Util() {
    }

    /**
     *  Convertir una cadena de caracteres a MD5. Por ejemplo: una contraseña.
     *  String md5 =Util.toMD5(mensaje);
     * 
     * @param mensaje
     * @return
     * @throws NoSuchAlgorithmException 
     */
    
    public static String toMD5(String mensaje) throws NoSuchAlgorithmException {

        MessageDigest md5 = MessageDigest.getInstance("MD5");

        return (new HexBinaryAdapter()).marshal(md5.digest(mensaje.getBytes()));

    }
}

```
