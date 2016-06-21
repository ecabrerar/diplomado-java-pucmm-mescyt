**Campo de Texto Formateado en Swing**

Los campos de texto con formato proporcionan un mecanismo para que los desarrolladores especifique los caracteres que un usuario puede introducir en un campo de texto dado. 

La clase **JFormattedTextField** agrega un formateador y un valor de objeto a las características heredadas de la clase **JTextField**. El formateador valida que el texto mostrado en el campo cumpla con las característica del propio formateador.

**Declaración de formatos para formatear números enteros**

```java

NumberFormat formatoMonto = NumberFormat.getNumberInstance();
```

**Declaración de formatos para formatear números con valores decimales**

```java
NumberFormat formatoTasa = NumberFormat.getNumberInstance();
formatoTasa.setMinimumFractionDigits(3); //Cantidad de dígitos con punto decimal mínimo
```

**Declaración de formatos para formatear monedas**

```java
NumberFormat  formatoCuotaMensual = NumberFormat.getCurrencyInstance();
```

**Creando e inicializando campos JFormattedTextField**

```java
JFormattedTextField txtVlrMonto = new JFormattedTextField(formatoMonto);
txtVlrMonto.setValue(Integer.MIN_VALUE); //Valor por defecto
txtVlrMonto.setColumns(10); //Tamaño del campo

```

Continuamos con el campo de  Tasa

```java
JFormattedTextField txtVlrTasa = new JFormattedTextField(formatoTasa);
txtVlrTasa.setValue(Double.MIN_VALUE);//Valor por defecto
txtVlrTasa.setColumns(10); //Tamaño del campo
```

Finalmente agregamos el formato al campo de la Cuota Mensual

```java
JFormattedTextField txtVlrCuotaMensual = new JFormattedTextField(formatoCuotaMensual);
txtVlrCuotaMensual.setValue(Double.MIN_VALUE);//Valor por defecto
txtVlrCuotaMensual.setColumns(10); //Tamaño del campo
```

La propiedad de texto se define por la clase **JTextField**. Esta propiedad siempre refleja lo que muestra el campo. El valor de la propiedad, definido por la clase **JFormattedTextField**, podría no reflejar el último texto que se muestra en el campo. Mientras el usuario está escribiendo, las propiedades de texto cambian, pero el valor de la propiedad no cambia hasta que se hayan confirmados (committed) los cambios.

Para ser más precisos, el valor de un campo de texto con formato se puede ajustar mediante el uso de ya sea el método setValue o el método **commitEdit**. El método setValue establece el valor para el argumento especificado. El argumento puede ser técnicamente cualquier objeto, pero el formateador tiene que ser capaz de convertirlo en una cadena. De lo contrario, el campo de texto no muestra ninguna información sustantiva.

El método **commitEdit** establece el valor de cualquier objeto que determina el formateador está representado por el texto del campo.

El método **commitEdit** es llamado automáticamente cuando cualquiera de las siguientes situaciones ocurre:

* Cuando el usuario pulsa la tecla **Enter** mientras que el campo tiene el foco.

* De forma predeterminada, cuando el campo pierde el foco, por ejemplo, cuando el usuario presiona la tecla Tab para cambiar el foco a otro componente. Usted puede utilizar el método **setFocusLostBehavior** para especificar un resultado diferente cuando el campo pierde el foco.

Cuando se establece el valor de un campo de texto con formato, el texto del campo se actualiza para reflejar el valor.

Exactamente cómo se representa el valor como texto depende del formateador del campo.

Para obtener el valor actual de un campo de texto con formato, utilice el método **getValue**. Si es necesario, se puede asegurar que el valor refleja el texto llamando al método **commitEdit** antes que **getValue**.

Debido a que el método de **getValue** devuelve un objeto, es necesario hacer una conversión de tipo para el valor de su campo.

**Por ejemplo:**

```java
double vlrMonto = ((Number) txtVlrMonto.getValue()).doubleValue();
txtVlrCuotaMensual.setValue(cuotaMensual); //Donde cuota mensjual es un valor double.
```

**_Nota_**:

En un campo de texto formateado, el texto y su valor son dos propiedades diferentes. Usar **getValue()** para obtener el valor en lugar de usar **getText()** como estamos acostumbrado en los campos **JTextField**.

Puede seguir investigando en [https://docs.oracle.com/javase/tutorial/uiswing/components/formattedtextfield.html](https://docs.oracle.com/javase/tutorial/uiswing/components/formattedtextfield.html)
