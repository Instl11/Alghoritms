package swap_var;


public class Main {
    public static void main(String[] args) {

        /**
         * Нужно, чтобы в итоге значения a и b поменялись местами
         * */

        int a = 7;
        int b = 3;

        a = a + b;
        b = a - b;
        a = a - b;


        System.out.println("A = " + a);
        System.out.println("B = " + b);


    }
}
