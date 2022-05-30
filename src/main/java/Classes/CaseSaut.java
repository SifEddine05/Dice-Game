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
        int num_case_actuel = j.getCaseActuel();
        int val = Nb_Case;
        if (num_case_actuel + val > 99) {

            // joeur.modifierCase(-(joeur.getCaseActuel()+val-99));
            int val2 = 99 - j.getCaseActuel();
            val = -(j.getCaseActuel() + val - 99) + val2;
            j.modifierCase(val);
            // joeur.modifierCase(val2+joeur.getCaseActuel()) ;
            if (val > 0) {
                return ("Avancer " + val + " en avant");
            } else {
                return ("Recouler " + val + " en arriere");
            }

            //System.out.println();

        } else {
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
}

