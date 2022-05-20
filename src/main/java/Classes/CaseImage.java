package Classes;

public class CaseImage extends CaseQuestion {
    public CaseImage() {
        // la definition de fichier
        Color = "rose";
        nbr_Points = 10;
        Nb_Case = 2;
    }

    public void SetLose() // si n'est pas reponder aux question
    {
        nbr_Points = 0;
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

