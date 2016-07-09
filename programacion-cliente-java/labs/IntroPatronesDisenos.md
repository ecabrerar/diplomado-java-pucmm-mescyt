**Introducción a Patrones de Diseño**

Los patrones de diseño **(design patterns) **son la base para la búsqueda de soluciones a problemas comunes en el desarrollo de software y otros ámbitos referentes al diseño de interacción o interfaces.

Un patrón de diseño es una solución a un problema de diseño. Para que una solución sea considerada un patrón debe poseer ciertas características. 

Una de ellas es que debe haber comprobado su efectividad resolviendo problemas similares en ocasiones anteriores. Otra es que debe ser reusable, lo que significa que es aplicable a diferentes problemas de diseño en distintas circunstancias.

## **Breve Reseña Histórica**

En 1979 el arquitecto **Christopher Alexander** aportó al mundo de la arquitectura el libro **The Timeless Way of Building**; en él proponía el aprendizaje y uso de una serie de patrones para la construcción de edificios de una mayor calidad.

En palabras de este autor, "Cada patrón describe un problema que ocurre infinidad de veces en nuestro entorno, así como la solución al mismo, de tal modo que podemos utilizar esta solución un millón de veces más adelante sin tener que volver a pensarla otra vez."

Los patrones que **Christopher Alexander** y sus colegas definieron, publicados en un volumen denominado **A Pattern Language**, son un intento de formalizar y plasmar de una forma práctica generaciones de conocimiento arquitectónico.

Los patrones no son principios abstractos que requieran su redescubrimiento para obtener una aplicación satisfactoria, ni son específicos a una situación particular o cultural, son algo intermedio. 

Un patrón define una posible solución correcta para un problema de diseño dentro de un contexto dado, describiendo las cualidades invariantes de todas las soluciones.

Más tarde, en **1987**, **Ward Cunningham **y **Kent Beck** usaron varias ideas de **Alexander** para desarrollar cinco patrones de interacción hombre-ordenador (HCI) y publicaron un artículo en OOPSLA-87 titulado **Using Pattern Languages for OO Programs**.

No obstante, no fue hasta principios de los 90’s cuando los patrones de diseño tuvieron un gran éxito en el mundo de la informática a partir de la publicación del libro **Design Patterns** escrito por el grupo** Gang of Four (GoF)** compuesto por **Erich Gamma**, **Richard Helm, Ralph Johnson** y **John Vlisides**, en el que se recogían 23 patrones diseño comunes.

## **Objetivos de los patrones**

Los patrones de diseño pretenden:

* Proporcionar catálogos de elementos reusables en el diseño de sistemas software.

* Evitar la reiteración en la búsqueda de soluciones a problemas ya conocidos y solucionados anteriormente.

* Formalizar un vocabulario común entre diseñadores.

* Estandarizar el modo en que se realiza el diseño.

* Facilitar el aprendizaje de las nuevas generaciones de diseñadores condensando conocimiento ya existente.

Asimismo, no pretenden:

* Imponer ciertas alternativas de diseño frente a otras.

* Eliminar la creatividad inherente al proceso de diseño.

No es obligatorio utilizar los patrones, solo es aconsejable en el caso de tener el mismo problema o similar que soluciona el patrón, siempre teniendo en cuenta que en un caso particular puede no ser aplicable. Abusar o forzar el uso de los patrones puede ser un error.

## **Categorías de patrones**

Según la escala o nivel de abstracción:

* **Patrones de arquitectura:** Aquéllos que expresan un esquema organizativo estructural fundamental para sistemas software.

* **Patrones de diseño:** Aquéllos que expresan esquemas para definir estructuras de diseño (o sus relaciones) con las que construir sistemas software.

* **Idiomas:** Patrones de bajo nivel específicos para un lenguaje de programación o entorno concreto.

Además, también es importante reseñar el concepto de **Antipatrón de Diseño**, que con forma semejante a la de un patrón, intenta prevenir contra errores comunes de diseño en el software. 

La idea de los antipatrones es dar a conocer los problemas que acarrean ciertos diseños muy frecuentes, para intentar evitar que diferentes sistemas acaben una y otra vez en el mismo callejón sin salida por haber cometido los mismos errores.

## **Estructuras o plantillas de patrones**

Para describir un patrón se utilizan plantillas más o menos estandarizadas, de forma que se expresen uniformemente y puedan constituir efectivamente un medio de comunicación uniforme entre diseñadores. Varios autores eminentes en esta área han propuesto plantillas ligeramente distintas. Si bien la mayoría definen los mismos conceptos básicos.

La plantilla más común es la utilizada precisamente por el **GoF** y consta de los siguientes apartados:

* **Nombre del patrón:** nombre estándar del patrón por el cual será reconocido en la comunidad (normalmente se expresan en inglés).

* **Clasificación del patrón: **creacional, estructural o de comportamiento.

* **Intención:** ¿Qué problema pretende resolver el patrón? También conocido como: Otros nombres de uso común para el patrón.

* **Motivación:** Escenario de ejemplo para la aplicación del patrón.

* **Aplicabilidad:** Usos comunes y criterios de aplicabilidad del patrón.

* **Estructura: **Diagramas de clases oportunos para describir las clases que intervienen en el patrón.

* **Participantes:** Enumeración y descripción de las entidades abstractas (y sus roles) que participan en el patrón.

* **Colaboraciones:** Explicación de las interrelaciones que se dan entre los participantes.

* **Consecuencias:** Consecuencias positivas y negativas en el diseño derivadas de la aplicación del patrón.

* **Implementación: **Técnicas o comentarios oportunos de cara a la implementación del patrón.

* **Código de ejemplo:** Código fuente ejemplo de implementación del patrón.

* **Usos conocidos:** Ejemplos de sistemas reales que usan el patrón.

* **Patrones relacionados:** Referencias cruzadas con otros patrones.

**Patron  MVC (Model View Controller):**

**MVC (Modelo Vista Controlador):** Divide un componente o un subsistema en tres partes lógicas: la interfaz de usuario, y la lógica de control en tres componentes distintos, facilitando la modificación o personalización de cada parte.

## **Descripción del patrón**

Modelo: Esta es la representación específica de la información con la cual el sistema opera. La lógica de datos asegura la integridad de estos y permite todo derivar nuevos datos. 

Muchos sistemas informáticos utilizan un Sistema de Gestión de Base de Datos para gestionar los datos. En MVC corresponde al **modelo**.

**Vista**: Este presenta el modelo en un formato adecuado para interactuar, usualmente la interfaz de usuario.

**Controlador**: Este responde a eventos, usualmente acciones del usuario e invoca cambios en el modelo y probablemente en la vista.

** Patrón Singleton**

**Singleton (instancia única) **está diseñado para restringir la creación de objetos pertenecientes a una clase o el valor de un tipo a un único objeto.

Su intención consiste en garantizar que una clase sólo tenga una instancia y proporcionar un punto de acceso global a ella.

El patrón singleton se implementa creando en nuestra clase un método que crea una instancia del objeto sólo si todavía no existe alguna. Para asegurar que la clase no puede ser instanciada nuevamente se regula el alcance del constructor (con atributos como protegido o privado).

**Patrón Observer**

El patrón **Observador (en inglés: Observer)** también conocido como "spider" define una dependencia del tipo uno-a-muchos entre objetos, de manera que cuando uno de los objetos cambia su estado, el observador se encarga de notificar este cambio a todos los otros dependientes.

El objetivo de este patrón es desacoplar la clase de los objetos clientes del objeto, aumentando la modularidad del lenguaje, así como evitar bucles de actualización **(espera activa o polling)**.

Este patrón también se conoce como el patrón de publicación-inscripción o modelo-patrón. 

Estos nombres sugieren las ideas básicas del patrón, que son bien sencillas: el objeto de datos, llamémoslo "Objeto" a partir de ahora, contiene atributos mediante los cuales cualquier objeto observador o vista se puede suscribir a él pasándole una referencia a sí mismo. 

El Sujeto mantiene así una lista de las referencias a sus observadores.

Los observadores a su vez están obligados a implementar unos métodos determinados mediante los cuales el Sujeto es capaz de notificar a sus observadores **"suscritos"** los cambios que sufre para que todos ellos tengan la oportunidad de refrescar el contenido representado.

De manera que cuando se produce un cambio en el Sujeto, ejecutado, por ejemplo, por alguno de los observadores, el objeto de datos puede recorrer la lista de observadores avisando a cada uno.

     

