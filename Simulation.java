//The program answers the question:

//If there are two buses, one that comes every 12 minutes and one that comes every 8, when the earliest bus is expected to come?

 

//The simulation returns around 3.11 minutes

//This is true as it can be proved mathimatically:

//f(t) = [(8-t) + (12-t)]/8*12

//f(t) = (20-2t)/96

//E(T)=\int_0^{8} t*f(t) dt

//E(T)=\int_0^{8} t*((20-2t)/96) dt

//E(T)=\int_0^{8} t*((20t-2t^2)/96) dt

//E(T)=[(10t^2-(2t^3)/3)/96]_0^{8}

//E(T)=[(10*64-(2*512)/3)/96]-0

//E(T) = 3.11111111111 which agrees with our simulation as well

 

/**

* @author Andreas Loizou

*

*/

public class BusSimulation {

       final static Random random = new Random();

 

       /**

       * @param UPPER_RANGE The upper bound of the number.

       * @return A number between 0 and UPPER_RANGE included

       */

       public static double getRandomValue(final int UPPER_BOUND) {

             return random.nextDouble() * UPPER_BOUND;

       }

 

       /**

       * @param cycles How many times the simulation of the two buses will run

       * @return The average time the first bus needs

       */

       public static double simulation(final int cycles) {

             //cycles cannot be negative

             if (cycles < 0) {

                    throw new IllegalArgumentException(

                                 "cycles input variable is negative");

             }

             //Prevent division by zero

             if (cycles == 0) {

                    return 0;

             }

             //Start the calculation. Get the minimum time between the two buses

             double sum = 0;

             for (int i = 0; i < cycles; i++) {

                    sum += Math.min(get_random_value(12), get_random_value(8));

             }

             //Return the average time

             return sum / cycles;

       }

 

       /**

       * @param args Not used

       */

       public static void main(String[] args) {

             //Run several cycles of simulations

             final int MAX_NUMBER_OF_SIMULATIONS = 1000000;

             final int CYCLE_STEP = 10000;

             for (int i = 0; i < MAX_NUMBER_OF_SIMULATIONS; i += CYCLE_STEP) {

                    System.out.printf(i + "\t: " + "%.2f" + "\n", simulation(i));

             }

       }
}

