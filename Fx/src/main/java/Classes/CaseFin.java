package Classes;

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
       // return ("Vous Avez Gagner Filistation !!!");
       // System.out.println("Vous Avez Gagner Filistation !!!");
        if (j.getScoreActuel() > j.getmeilleur_Score()) {
            j.set_meilleur_score(j.getScoreActuel());

            return ("Vous avez battu votre meilleur score \nle nouveau meilleur score est " + j.getScoreActuel());
            //System.out.println(
                   // "Vous avez battu votre meilleur score \nle nouveau meilleur score est " + j.getScoreActuel());

        } else {
            return ("votre score de ce Partie est : " + j.getCaseActuel() + "\n Votre meuilleur score est : "
                    + j.getmeilleur_Score());

        }
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

    }
}
