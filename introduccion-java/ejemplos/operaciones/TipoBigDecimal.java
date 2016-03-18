

import java.math.BigDecimal;

public class TipoBigDecimal {
    public static void main(String[] args) {

        /**
         * Por que usar BigDecimal (y no Double) para calculos aritmeticos financieros ?
         */

        double unCentavo = 0.01;
        double suma = unCentavo + unCentavo + unCentavo + unCentavo + unCentavo + unCentavo;
        System.out.println(suma); //Que se imprime? Si contestaste: 0.06, estas equivocado.

        /**
         * Ahora escribe:
         */

        BigDecimal unCentavo1 = new BigDecimal("0.01");
        BigDecimal suma1 = unCentavo1.add(unCentavo1).add(unCentavo1).add(unCentavo1).add(unCentavo1).add(unCentavo1);
        System.out.println(suma1); // Que imprime? 0.06

        /**
         * Las computadoras no cuentan como nosotros, las computadoras "cuentan en binario", nosotros, contamos en decimal.
         * Cuando usamos una variable float o double, estamos dejandole al microprocesador de la computadora el trabajo de efectuar
         * los cálculos directamente (con su coprocesador matemático) pero como las computadoras "piensan" en binario, cometen errores
         * de precisión diferentes a los nuestros.
         *
         * Por ejemplo, nosotros los humanos, tenemos un problema para representar a la tercera parte de "1" (1/3),
         * y la escribimos: 0.3333333333333333333... (hasta el infinito), en nuestro sistema decimal (base 10), no hay modo de representar
         * a un tercio de un entero. Si por otro lado, nuestro sistema fuera base "9", entonces representariamos la tercera parte de un entero
         * simplemente con : "0.3" (y seria mas preciso que cualquier lista larga de números "3" en base 10.
         *
         * En binario (base 2), no se puede representar a 1/10 (la décima parte de 1) ni a 1/100 (la centésima parte de 1) y por eso,
         * cuando nosotros escribimos "0.01" la computadora lo entiende como 1100110011001100110011001100110011... (hasta el infinito)
         * y efectuá el calculo incorrectamente (desde nuestro punto de vista "decimal").
         *
         * Si hacen sistemas financieros, los pequeños errores de calculo acumulados con varios centavos pueden resultar en reportes cuyos
         * cálculos diferirán de las operaciones que normalmente realizamos los humanos.
         * Para resolver este problema, en Java se incluye la clase BigDecimal, que si bien realiza los cálculos mas lento que "Double/double"
         * los realiza del mismo modo que los humanos (en base 10) y así evitamos el problema.
         */


    }
}
