package Classes;

public class CaseParcours extends Case {
    public CaseParcours() {
        Color = "blanc";
        Nb_Case = 0;
        nbr_Points = 0;
    }

    public void Action(Joeur j) {
        afficher();

        j.modifierCase(Nb_Case);
        j.modifierScore(nbr_Points);
    }

}
