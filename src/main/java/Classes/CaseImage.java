package Classes;

import javafx.scene.control.Label;

import java.io.Serializable;

public class CaseImage extends CaseQuestion implements Serializable {
    public CaseImage() {
        // la definition de fichier
        Color = "Pink";
        nbr_Points = 10;
        Nb_Case = 2;
    }

    public void SetLose() // si n'est pas reponder aux question
    {
        nbr_Points = 0;
        Nb_Case = 0;
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
                return ("Avancer " + val + " en avant");
            } else {
                return ("Recouler " + val + " en arriere");
            }

            //System.out.println();

        } else {
            j.modifierCase(Nb_Case);
            j.modifierScore(nbr_Points);

            if (Nb_Case > 0) {
                return ("Avancer " + Nb_Case + " en avant");
                //System.out.println("Avancer " + Nb_Case + " en avant");
            }
            return ("Relancer le De") ;
        }

    }

    public void genererQuestion() {
    };
}

