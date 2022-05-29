package Classes;

import javafx.scene.control.Label;

public class CaseBonus extends Case {
    public CaseBonus() {
        Color = "Green";
        Nb_Case = 2;
        nbr_Points = 10;
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
            return ("Avancer " + Nb_Case + " en avant");
        }
    }
}
