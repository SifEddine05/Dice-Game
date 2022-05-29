package Classes;
import javafx.scene.control.Label;

import java.io.Serializable;
import java.util.Random;
public class CaseSaut extends Case implements Serializable {
    public CaseSaut() {
        Color = "Orange";
        Random rand = new Random(); // instance of random class
        int random = rand.nextInt(10)+1;
        int type = rand.nextInt(2) ;
        if (type == 0) {
            Nb_Case = random;
        } else {
            Nb_Case = -random;
        }
        nbr_Points = 0;
    }

    public String Action(Joeur j) {
        afficher();

        j.modifierCase(Nb_Case);
        j.modifierScore(nbr_Points);

        if (Nb_Case < 0) {
            return ("Reculer " + Nb_Case + " en ariere");
            //System.out.println("Reculer " + Nb_Case + " en ariere");
        } else {
            return ("Avancer" + Nb_Case + " en avant");
           // System.out.println("Avancer" + Nb_Case + " en avant");
        }
    }
}

