###Diplomado en Lenguaje JAVA (PUCMM - MESCYT)

Por Eudris Cabrera Rodríguez

Escenario:
En una empresa las personas están clasificadas en las siguientes categorías:

* Empleado : Si trabaja por un sueldo fijo.
* Consultor: Si trabaja por horas.
* Pasante:   No recibe pago y no cumple un horario regular.

De cada persona se registra la siguiente información:  nombre, #empleado,cedula,direccion, telefono,fecha de nacimiento y fecha de contratación. 

El empleado además del sueldo base puede aumentar su salario si trabaja horas extras. Si el empleado trabaja más de 44 horas en una semana, las horas extras tienen una tarifa establecida y el cálculo de estas se le suma al monto del sueldo fijo. 

El empleado además de los datos propios de una persona tiene un puesto o posición, un sueldo fijo y puede ganar horas extras dependiendo de la cantidad de horas trabajadas. 

Al empleado se le realiza un descuento de 2.72% por concepto de AFP(Administración de Fondos de Pensiones)  y 3.01 por Seguro Familiar de Salud (SFS).

El precio de la hora extra depende de la posición del empleado.

Sueldos por posiciones de empleados:
Secretaria: 15,000
Contable:  25,000
Mécanico: 18,000
Coordinador : 35,000
Gerente : 55,000.

A los gerentes no se le pagan las horas trabajadas fuera de horario (horas extras).

El consultor tiene un precio por horas trabajadas y en base a eso se calcula su sueldo.
Al consultor se le realiza un descuento de 10% de su salario por concepto de retención impositiva vigente del impuesto sobre la renta.

 El consultor tiene un sueldo en base a las horas trabajadas y la tarifa por hora establecida.

El pasante no recibe sueldo y se le asignan viáticos para gastos de pasaje y dieta. 
El monto de los viáticos no debe sobrepasar los 6000 pesos. En caso de que pase de 6 mil el sistema debe informar que está fuera de rango.
 
Se desea modelar el escenario anterior en un diseño de clases.
Además debemos incluir funcionalidades para imprimir el listado de empleados incluyendo por lo menos 1 por cada categoría y el listado de consultores.

**Opcional (puntos adicionales):**

Capturar los valores para los empleados desde la consola y guardarlo temporalmente en una lista para luego ser mostrados.

Los valores correspondientes a sueldos deben estar formateado con el símbolo de la moneda y luego de cada dato debe haber un cambio de línea.

Debes considerar si es necesario agregar nuevas entidades en su diseño de clases.
Evaluar si es necesario reemplazar la lógica condicional con polimorfismo y si se requiere crear una jerarquía de clase para los sueldos.

Agregar comentarios que justifiquen sus decisiones en el diseño.

**Consejo:**
Hacer diseño inicial y luego mejorar su solución.

Nota: Crear proyecto desde cero en NetBeans y seguir las estructuras de paquetes que hemos utilizado anteriormente..
