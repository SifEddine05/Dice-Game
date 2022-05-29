package Classes;

import javafx.scene.control.Label;

import java.io.Serializable;

public class CaseBonus extends Case implements Serializable {
    public CaseBonus() {
        Color = "Green";
        Nb_Case = 2;
        nbr_Points = 10;
    }

    public String Action(Joeur j ) {
        afficher();
        j.modifierCase(Nb_Case);
        j.modifierScore(nbr_Points);

        return ("Avancer " + Nb_Case + " en avant");
        //System.out.println();

    }
}
