package Classes;

import javafx.scene.control.Label;

import java.io.Serializable;

public class CaseMalus extends Case implements Serializable {
    public CaseMalus() {
        Color = "Red";
        Nb_Case = -2;
        nbr_Points = -10;
    }

    public String  Action(Joeur j) {
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
                return ("move forward " + val + " steps");
            } else {
                return ("go back " + val + " steps");
            }

            //System.out.println();

        } else {
            j.modifierCase(Nb_Case);
            j.modifierScore(nbr_Points);

            return("go back " + Nb_Case + " steps");
        }

      //  System.out.println("Reculer " + Nb_Case + " en ariere");

    }
}