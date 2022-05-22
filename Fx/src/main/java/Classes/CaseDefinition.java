package Classes;

import javafx.scene.control.Label;

public class CaseDefinition extends CaseQuestion {
    public CaseDefinition() {
        // la definition de fichier
        Color = "blue";
        nbr_Points = 20;
        Nb_Case = 4;
    }

    public void SetLose() // si n'est pas reponder aux question
    {
        nbr_Points = -10;
        Nb_Case = 0;
    }

    public String Action(Joeur j ) {
        afficher();

        j.modifierCase(Nb_Case);
        j.modifierScore(nbr_Points);

        if (Nb_Case > 0) {
            return("Avancer " + Nb_Case + " en avant");
            //System.out.println("Avancer " + Nb_Case + " en avant");
        }
        return  "Relancer le De" ;
    }

    public void genererQuestion() {
    };
}
