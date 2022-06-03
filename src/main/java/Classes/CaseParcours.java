package Classes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.Serializable;

public class CaseParcours extends Case implements Serializable {
    public CaseParcours() {
        Color = "White";
        Nb_Case = 0;
        nbr_Points = 0;
    }
@FXML
Label Info2 ;
    public String Action(Joeur j) {
        afficher();
        j.modifierCase(Nb_Case);
        j.modifierScore(nbr_Points);
        return ("Relancer le De") ;

    }

}
