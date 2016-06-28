Distribución del espacio **(layout management)**:  antes de construir una interfaz gráfica de usuario es importante saber cómo se distribuyen especialmente los componentes.

Los layout managers controlan la forma en la que colocan los componentes dentro de un contenedor.

**Principales Manejadores de Distribución de Espacio (Core Layout Managers)**

**java.awt.FlowLayout**

FlowLayout ordena los componentes en un flujo direccional, una después de la otra, si pasamos a una nueva línea cuando no hay más componentes, se agregan en la línea actual. La dirección se determina por la propiedad **componentOrientation** del contenedor y puede ser uno de dos valores: **ComponentOrientation.LEFT_TO_RIGHT** o **ComponentOrientation.RIGHT_TO_LEFT**

**FlowLayout** es el controlador de distribución por defecto de AWT y los componentes Swing.

**java.awt.GridLayout**

GridLayout expone componentes de un contenedor en una rejilla rectangular. El recipiente se divide en rectángulos de igual tamaño, y uno de los componentes se coloca en cada rectángulo. Típicamente, un **GridLayout** se construye mediante la especificación del número de filas y columnas.

**java.awt.BorderLayout**

BorderLayout expone los componentes en cinco regiones: norte, sur, este, oeste y central. A medida que se añade cada componente a un contenedor con un BorderLayout, la ubicación se especifica similar a: contenedor.add(componente, BorderLayout.CENTER);

**java.awt.CardLayout**

CardLayout actúa como un organizador de componentes apilados en un contenedor, siendo visible sólo una tarjeta a la vez. El primer componente añadido es el componente visible cuando se muestra por primera vez el contenedor. Existen métodos para pasar por la pila de forma secuencial o para acceder a una tarjeta en particular.

**javax.swing.BoxLayout**

**BoxLayout** permite que varios componentes se distribuyen verticalmente (Y_AXIS) u horizontal (X_AXIS). Los componentes no se dividan, por lo que cuando se cambia el tamaño del marco de los componentes se mantienen en su disposición inicial.

Los componentes están dispuestos en el orden en que se agregan al controlador de distribución.

**java.awt.GridBagLayout**

**GridBagLayout** es el controlador de distribución más flexible, manteniendo una cuadrícula dinámica, rectangular de celdas. Cada componente puede ocupar una o más células, y tiene una instancia de **GridBagConstraints** para especificar cómo un componente se debe mostrar en su área de visualización.

