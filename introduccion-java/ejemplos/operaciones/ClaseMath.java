

/**
 * La clase java.lang.Math provee varios metodos para trabajar con tipo de datos numericos
 */
public class ClaseMath {
    public static void main(String[] args) {

        /**
         * Ejemplo1: Metodo round
         * Redondear
         */
        long result = Math.round(1.667); //result = 2
        int result1 = Math.round(1.49F); //result1 = 1

        /**
         * Ejemplo2 : Metodo pow
         * Elevar a la n
         */

        double result2 = Math.pow(2, 2); //result2 = 4 (2*2)
        double result3 = Math.pow(2, 3); //result3 = 8 (2*2*2)
        double result4 = Math.pow(5, 2); //result4 = 25.0 (5^2)
        int result5 = (int)Math.pow(5, 2); //result5 = 25 (5^2)

        /**
         * Ejemplo 3: Metodo sqrt
         * Raiz cuadrada
         */

        double result6 = Math.sqrt(20.25); //result6 = 4.5

        /**
         * Ejemplo 4: Metodo max y metodo min
         * conseguir el valor maximo y minimo en cada caso
         */

        int x = 67;
        int y = 23;

        int max = Math.max(x, y); //max = 67
        int min = Math.max(x, y); //min = 23


        /**
         * Ejemplo 5: Metodo random
         * Generar valores aleatorio
         *
         */

        double x1 = Math.random() * 100; //Genera un valor entre 0.0 y 100.0
        long result7 = (long)x1; //convertir de double a long

    }
}
