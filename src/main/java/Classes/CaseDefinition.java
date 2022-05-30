package Classes;

import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.StringTokenizer;

public class CaseDefinition extends CaseQuestion implements Serializable {
    private transient BufferedReader file = null;

    public CaseDefinition(BufferedReader f) {
        // la definition de fichier
        Color = "blue";
        nbr_Points = 20;
        Nb_Case = 4;
        this.file = f;
    }

    public void SetLose() // si n'est pas reponder aux question
    {
        System.out.println("LOSSSSSSSS");
        nbr_Points = -10;
        Nb_Case = 0;
    }

    public String Action(Joeur j) {
        afficher();
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
            if (Nb_Case > 0) {
                return ("Avancer " + Nb_Case + " en avant");
                //System.out.println("Avancer " + Nb_Case + " en avant");
            }
            return "Relancer le De";
           // return ("Avancer " + Nb_Case + " en avant");
        }


    }

    public void genererQuestion() {
    };
}

/*
class CaseDefinition extends CaseQuestion {

    private BufferedReader file = null;

    public CaseDefinition(BufferedReader f) {
        // la definition de fichier
        Color = "bleu";
        nbr_Points = 20;
        Nb_Case = 4;
        this.file = f;
    }

    public void genererQuestion() {
        // BufferedReader f = null;
        StringTokenizer tok = null;
        try {
            // f = new BufferedReader(new FileReader("definition.txt"));
            String h = file.readLine();
            System.out.println(h);
            tok = new StringTokenizer(h, ",");
            System.out.println("le numero de la question est :" + tok.nextToken());
            System.out.println("la question est :" + tok.nextToken());
            for (int i = 1; i < 5; i++) {
                System.out.println("la suggestion " + i + " est " + tok.nextToken());
            }
        } catch (IOException e) {
            System.out.println("il ya une exception ");
        } finally {
            // f.close() ;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("veuillez saisir le numero de votre reponse ");
        int rep = sc.nextInt();
        if (Integer.parseInt(tok.nextToken()) == rep) {
            System.out.println("la reponse est juste ");
        } else {
            System.out.println("la reponse est fausse ");
            SetLose();
        }
    }

    public void SetLose() // si n'est pas reponder aux question
    {
        nbr_Points = -10;
        Nb_Case = 0;
    }

    public void Action(Joeur j) {
        afficher();
        genererQuestion();
        j.modifierCase(Nb_Case);
        if (Nb_Case > 0) {
            System.out.println("Avancer " + Nb_Case + " en avant");
        } else {
            System.out.println("Recouler " + Nb_Case + " en arrier");
        }
        j.modifierScore(nbr_Points);
    }

}
 */
