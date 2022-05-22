package Classes;

import javafx.scene.control.Label;

public class CaseMalus extends Case {
    public CaseMalus() {
        Color = "Red";
        Nb_Case = -2;
        nbr_Points = -10;
    }

    public String  Action(Joeur j) {
        afficher();

        j.modifierCase(Nb_Case);
        j.modifierScore(nbr_Points);

        return("Reculer " + Nb_Case + " en ariere");
      //  System.out.println("Reculer " + Nb_Case + " en ariere");

    }
}