package Classes;

public class CaseDepart extends Case {
    public CaseDepart() {
        Color = "Yellow";
        Nb_Case = 0;
        nbr_Points = 0;

    }

    public void Action(Joeur j) {
        afficher();
        j.modifierScore(nbr_Points);
        j.modifierCase(Nb_Case);
        // System.out.println("avancer de "+val+" case en avant");
    }
}
