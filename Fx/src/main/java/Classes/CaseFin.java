package Classes;

import com.example.fx.HelloController;
import javafx.scene.control.Label;

public class CaseFin extends Case {
    private Boolean gagner = false;

    public CaseFin(Joeur j) {
        Color = "Black";
        // if (j.getCaseActuel()==99)
        // {
        // this.gagner = true ;
        // }
        // else
        // {
        // Nb_Case=-(j.getCaseActuel()+valeurDesDe-99);
        // nbr_Points= 0;
        // }
    }

    public CaseFin() {
        Color = "Black";
    }

    public String Action(Joeur j) {
        afficher();
        HelloController.setFin();

        // if (gagner==true)
        // {
        // System.out.println("Vous Avez Gagner Filistation !!!");
        // j.fin();
        // }
        // else{
        // j.modifierCase(Nb_Case);
        // j.modifierScore(nbr_Points);
        // System.out.println("Reculer "+Nb_Case+" en avant");
        // }
        return  "" ;
    }
}
