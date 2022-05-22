package Classes;

import javafx.scene.control.Label;

public class CaseDepart extends Case {
    public CaseDepart() {
        Color = "Yellow";
        Nb_Case = 0;
        nbr_Points = 0;

    }

    public String Action(Joeur j) {
        afficher();
        j.modifierScore(nbr_Points);
        j.modifierCase(Nb_Case);
        return ("Relancer le De") ;
        // System.out.println("avancer de "+val+" case en avant");
    }
}
