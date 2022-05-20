package Classes;
import  java.util.* ;
public class De {
    public static int De1() {
        Random rand = new Random(); // instance of random class
        int random = rand.nextInt(6);
        return random + 1;
    }

    public static int De2() {
        Random rand = new Random(); // instance of random class
        int random2 = rand.nextInt(6);
        return random2 + 1;
    }
}
