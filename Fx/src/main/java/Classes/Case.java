package Classes;

import javafx.scene.control.Label;

abstract public class Case {
    protected String Color;
    protected int Nb_Case;
    protected int nbr_Points;
    public void afficher()
    {
        System.out.println("Color "+this.Color+" Bonus "+this.nbr_Points+" Deplacer "+this.Nb_Case);
    }
    public String getColor()
    {
        return  this.Color ;
    }
    public abstract String Action(Joeur j );
    public  String testFin(Joeur j  )
    {
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
