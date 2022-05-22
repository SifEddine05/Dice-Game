package Classes;

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

    public void Action(Joeur j) {
        afficher();

        j.modifierCase(Nb_Case);
        if (Nb_Case > 0) {
            System.out.println("Avancer " + Nb_Case + " en avant");
        }
        j.modifierScore(nbr_Points);
    }

    public void genererQuestion() {
    };
}
