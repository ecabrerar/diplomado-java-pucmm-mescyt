## Recomendaciones Generales

A continuación un listado de reglas básicas que debemos seguir cuando estamos desarrollando una aplicación Java.


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
Convertir contraseña a MD5

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
