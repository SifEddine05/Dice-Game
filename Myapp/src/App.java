import java.util.Random;

class De {
    public static int   De1()
    {
        Random rand = new Random(); //instance of random class
        int random = rand.nextInt(6); 
        return random+1;
    }public static int   De2()
    {
        Random rand = new Random(); //instance of random class
        int random2 = rand.nextInt(6); 
        return random2+1;
    } 

}
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(" de1 "+-De.De1()+" de2 "+De.De2());
    }
}
