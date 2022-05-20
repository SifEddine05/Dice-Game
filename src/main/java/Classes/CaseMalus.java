package Classes;

public class CaseMalus extends Case {
    public CaseMalus() {
        Color = "rouge";
        Nb_Case = -2;
        nbr_Points = -10;
    }

    public void Action(Joeur j) {
        afficher();

        j.modifierCase(Nb_Case);
        System.out.println("Reculer " + Nb_Case + " en ariere");
        j.modifierScore(nbr_Points);

    }
}