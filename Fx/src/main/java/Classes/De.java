package Classes;

import javafx.fxml.FXML;

import java.util.Random;

public class De {
    public static int Som  ;
    public  int De1() {
        this.Som=0;

        Random rand = new Random(); // instance of random class
        int random = rand.nextInt(6);
        this.Som=this.Som+(random+1);
        System.out.println("De1"+Som);
        return (random + 1);
    }

    public  int De2() {
        Random rand = new Random(); // instance of random class
        int random2 = rand.nextInt(6);
        this.Som=this.Som+(random2+1) ;
        System.out.println("De2"+Som);
        return (random2 + 1);
    }
    public  int Som ()
    {
        System.out.println("Ss"+Som);
        return this.Som ;
    }
}
