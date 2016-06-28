**Manejo y uso de Eventos**

En las aplicaciones en modo consola, nuestro método main determina el orden en el que se ejecutan las operaciones de nuestro programa.

En las aplicaciones con interfaces gráficas de usuario, el orden en el que se ejecutan las operaciones dependerá de las acciones del usuario.

Nosotros sólo debemos de preocuparnos de qué acciones va a realizar nuestra aplicación, cuándo han de realizarse y definir los correspondientes manejadores de eventos, que serán invocados automáticamente cuando sus eventos asociados se produzcan.

**Eventos en Java:**

Un evento es un objeto que representa un cambio en un componente, este es generalmente producido por  el  usuario  al  realizar  alguna  operación,  por  ejemplo,  escribir  en  un  campo  de  texto  o  hacer  click sobre un botón.

El modelo de eventos de Java Cada lenguaje de programación tiene su propio modelo de eventos:

En Visual Basic, cada componente genera eventos específicos y nosotros redefinimos la respuesta del componente a cada evento (modelo simple pero bastante inflexible).

En C, todos los eventos se sitúan en una cola: debemos de ir leyendo los eventos de esta cola y decidir qué acción realizar en función del evento extraído de la cola (tedioso de programar).

En Java, se definen clases auxiliares (**event listeners**) que pueden recibir eventos de tipos específicos (p.ej. el clic del botón del ratón). Estas clases se asocian luego a componentes específicos.

A diferencia de VB, el manejador no viene predeterminado (mayor flexibilidad).

A diferencia de C, cada tipo de evento se puede tratar por separado.

**Manejo de Eventos**

En términos de objetos y métodos, el manejo de eventos en Java funciona de la siguiente forma:

1. Los manejadores de eventos **(event listeners)** se registran en las  distintas fuente de eventos **(event source)**.

2. Una fuente de eventos (el ratón, un botón, una ventana...)  envía objetos de tipo EventObject a todos los manejadores registrados cuando se produce un nuevo evento.

3. Cada manejador de eventos utiliza la información recibida a través del objeto de tipo **EventObject** para realizar las acciones que estime adecuadas.

En Java, los eventos están organizados en una jerarquía de clases dentro del paquete **java.awt.event**

La clase **java.util.EventObject** es la clase base de todos los eventos en Java.

La subclase **java.awt.AWTEvent** es la clase base de todos los eventos que se utilizan en la construcción de GUIs.

Cada tipo de evento **XxxEvent** tiene asociada una interfaz **XxxListener** que es la que nos permite definir manejadores de eventos.

Para simplificar la implementación de algunos manejadores de eventos, el paquete **java.awt.event **incluye clases base **XxxAdapter** que implementan las interfaces **XxxListener**.


| Interfaces | Clases Abstractas |
|------------|-------------------|
|ActionListener|ComponentAdapter |
|AdjustmentListener|ContainerAdapter|
|AWTEventListener|ContainerEvent|
|ComponentListener|FocusAdapter|
|ContainerListener|KeyAdapter
|FocusListener|MouseMotionAdapter
|InputMethodListener|WindowAdapter
|ItemListener||
|KeyListener||
|MouseListener||
|MouseMotionListener||
|TextListener||
|WindowListener||


**Conociendo los listeners más utilizados**

**Action Listener**

Es probablemente el más fácil y común manejador de eventos para implementar. Puedes implementar un **action listener** para definir la acción a realizar cuando un usuario realice una operación.

Un evento acción se produce, cada vez que una acción se lleva a cabo por el usuario.

**Ejemplos:** 

Cuando el usuario hace clic en un botón, elige un elemento del menú, pulsa Intro en un campo de texto.

El resultado es que un mensaje **actionPerformed** se envía a todos los oyentes de acción que están registrados en el componente correspondiente.

**Window Listeners**

Existen 3 listener para el manejo de eventos de ventana, **WindowListener**, **WindowFocusListener** y **WindowStateListener**.

Estos listeners manejan objetos **WindowEvent**. Los métodos en los 3 manejadores eventos son implementados por la clase abstracta **WindowAdapter**.

Las siguientes actividades de ventanas o estados pueden preceder a un evento de ventana:

1. **Opening a window (Apertura de una ventana)** : Mostrando una ventana por primera vez.

2. **Closing a window (Cierre de una ventana)** :  Extracción de la ventana de la pantalla.

3. **Iconifying a window** : La reducción de la ventana a un icono en el escritorio.

4. **Deiconifying a window** : Restauración de la ventana a su tamaño original.

5. **Focused window :** La ventana que contiene el foco.

6. **Activated window (frame or dialog) ( Activado ventana (JFrame o JDialog)) :** Esta ventana es o bien la ventana activa, o posee la ventana enfocada.

7. **Deactivated window (Desactivado ventana)** : En esta ventana se ha perdido el foco.

**Maximizing the window (Maximizar la ventana)** : El aumento de tamaño de una ventana para el tamaño máximo permitido, ya sea en la dirección vertical, la dirección horizontal, o en ambas direcciones.

**Mouse Listener**

Los eventos del ratón notifican cuando el usuario utiliza el ratón (o dispositivo de entrada similar) para interactuar con un componente.

Los eventos del ratón se producen cuando el cursor entra o sale de la zona en la pantalla de un componente y cuando el usuario presiona o libera uno de los botones del ratón.

**Property Change Listener**

Este evento se produce cuando ocurre un cambio del valor ligado a la propiedad.

**Por ejemplo:**

Quiere implementar un campo de texto con formato y necesitan una manera de detectar cuando el usuario ha introducido un nuevo valor.

Se puede registrar un detector de cambio de propiedad en el campo de texto con formato para escuchar a los cambios en la propiedad de valor.

**Focus Listener**

Ocurren cada vez que un componente gana o pierde el foco del teclado.

**Key Listener**

Los eventos de tecla indican cuando el usuario está escribiendo en el teclado. En concreto, los eventos de tecla son generados por el componente con el foco del teclado cuando el usuario pulsa y suelta las teclas del teclado.

**Item Listener**

Estos eventos son disparados por los componentes que implementan la interfaz ItemSelectable.

En general, los componentes que implementan la interfaz ItemSelectable mantienen en estado prendido / apagado para uno o más elementos.

Los componentes Swing que generan estos eventos son **check boxes**, **check menu items**, **toggle buttons** etc... y **combo boxes**.

Puedes obtener más información en [https://docs.oracle.com/javase/tutorial/uiswing/events/handling.html](https://docs.oracle.com/javase/tutorial/uiswing/events/handling.html)

