package Classes;

public class CaseBonus extends Case {
    public CaseBonus() {
        Color = "verte";
        Nb_Case = 2;
        nbr_Points = 10;
    }

    public void Action(Joeur j) {
        afficher();

        j.modifierCase(Nb_Case);
        System.out.println("Avancer " + Nb_Case + " en avant");
        j.modifierScore(nbr_Points);

    }
}
