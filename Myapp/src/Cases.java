import java.util.Random;
import java.util.*;

abstract class Case {
    protected String Color;
    protected int Nb_Case;
    protected int nbr_Points;
    public void afficher()
    {
        System.out.println("Color "+this.Color+" Bonus "+this.nbr_Points+" Deplacer "+this.Nb_Case);
    }
    abstract void Action(Joeur j);
}

class CaseDepart extends Case {
    public CaseDepart() {
        Color = "jaune";
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

class CaseParcours extends Case {
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

class CaseBonus extends Case {
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

class CaseMalus extends Case {
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

class CaseSaut extends Case {
    public CaseSaut() {
        Color = "orange";
        Random rand = new Random(); // instance of random class
        int random = rand.nextInt(10);
        int type = rand.nextInt(2) + 1;
        if (type == 0) {
            Nb_Case = random;
        } else {
            Nb_Case = -random;
        }
        nbr_Points = 0;
    }

    public void Action(Joeur j) {
        afficher();

        j.modifierCase(Nb_Case);
        if (Nb_Case < 0) {
            System.out.println("Reculer " + Nb_Case + " en ariere");
        } else {
            System.out.println("Avancer" + Nb_Case + " en avant");
        }
        j.modifierScore(nbr_Points);
    }
}

abstract class CaseQuestion extends Case {
    // le fichier des questions
    abstract void genererQuestion();

}

class CaseDefinition extends CaseQuestion {
    public CaseDefinition() {
        // la definition de fichier
        Color = "bleu";
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

class CaseImage extends CaseQuestion {
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

class CaseFin extends Case {
    private Boolean gagner = false;

    public CaseFin(Joeur j) {
        Color = "noire";
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

    }

    public void Action(Joeur j) {
        afficher();

        System.out.println("Vous Avez Gagner Filistation !!!");
        if (j.getScoreActuel() > j.getmeilleur_Score()) {
            System.out.println(
                    "Vous avez battu votre meilleur score \nle nouveau meilleur score est " + j.getScoreActuel());
            j.set_meilleur_score(j.getScoreActuel());

        } else {
            System.out.println("votre score de ce Partie est : " + j.getCaseActuel() + "\n Votre meuilleur score est : "
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

class De {
    public static int De1() {
        Random rand = new Random(); // instance of random class
        int random = rand.nextInt(6);
        return random + 1;
    }

    public static int De2() {
        Random rand = new Random(); // instance of random class
        int random2 = rand.nextInt(6);
        return random2 + 1;
    }
}

class Utilisateur {
    private String nom;
    private long meilleur_Score = 0;

    public Utilisateur(String nom) {
        this.nom = nom;

    }

    public void set_meilleur_score(long score) {
        this.meilleur_Score = score;
    }

    public long get_meilleur_score() {
        return this.meilleur_Score;
    }
}

class Joeur {
    private long ScoreActuel = 0;
    private int numCaseActuel = 0;
    private Utilisateur user;

    public Joeur(Utilisateur user) {
        this.user = user;
    }
    // public void fin( long MS) { //il reste le traitement de le plus grand score
    // pour tous les users
    // if(this.ScoreActuel>this.user.get_meilleur_score())
    // {
    // System.out.println("Vous avez battu votre meilleur score \nle nouveau
    // meilleur score est "+this.ScoreActuel);
    // user.set_meilleur_score(this.ScoreActuel);
    // }
    // else
    // {
    // System.out.println("votre score de ce Partie est : "+this.ScoreActuel+"\n
    // Votre meuilleur score est : "+this.user.get_meilleur_score());

    // }
    // }
    public long getmeilleur_Score() {
        return this.user.get_meilleur_score();
    }

    public void modifierScore(long val) {
        this.ScoreActuel = this.ScoreActuel + val;
    }

    public long getScoreActuel() {
        return this.ScoreActuel;
    }

    public int getCaseActuel() {
        return this.numCaseActuel;
    }

    public void modifierCase(int val) {
        this.numCaseActuel = this.numCaseActuel + val;
    }

    public void set_meilleur_score(long val) {
        this.user.set_meilleur_score(val);
    }

}

class Grille {
    public Case plateau[] = new Case[100];

    public void Charger_plateau()// remplir le plateau sequentiellement avec des cases
    {
        // plateau=new Case[100] ;
        int j;
        int i;
        plateau[0] = new CaseDepart();
        for (i = 0; i < 5; i++) {
            j = 5*i + 1;
            plateau[j] = new CaseBonus();
            plateau[j + 1] = new CaseMalus();
            plateau[j + 2] = new CaseDefinition();
            plateau[j + 3] = new CaseImage();
            plateau[j+4]=new CaseSaut() ;
            
        }
        for (i = 26; i < 98; i++) {
            plateau[i] = new CaseParcours();
        }
        plateau[98] = new CaseParcours();
        plateau[99] = new CaseFin();
    }

    public void generer_plateau_randomly()// generer un palteau aleatoire apres sa creation on utilisant des
                                          // permutations
    {
        this.Charger_plateau();
        for (int i = 1; i < 98; i++) {
            int index = ((int) (Math.random() * 97)) + 1;
            Case temp = plateau[i];
            plateau[i] = plateau[index];
            plateau[index] = temp;
        }
    }

    public void afficher() // afficher les ceses du plateau
    {
        this.Charger_plateau() ;
        this.generer_plateau_randomly() ;
        for (int i = 0; i < 100; i++) {
            System.out.println(" le case numero : " + i + "    " + plateau[i]);
        }
    }
}

class Partie {
    private Grille grille = new Grille();
    private int num_case_act = 0;
    private Joeur joeur;
    static long meilleure_score;

    public Partie(Joeur j) {
        this.joeur = j;
        grille.Charger_plateau();
        grille.generer_plateau_randomly();
    }

    public int lancer_De() {
        int a = De.De1();
        int b = De.De2();
        System.out.println("lancer le D1 " + a);
        System.out.println("lancer le D2 " + b);
        System.out.println("vous douvez deplacer " + (a + b));
        return a + b;
    }

    public Boolean Test(int valjoeur) // tester si le joeur aller a la case vrai
    {
        if (joeur.getCaseActuel() == valjoeur) {
            num_case_act =  valjoeur;
            return true;
        } else {
            System.out.println("la case est errone cliquer sur une autre case ");

            return false;
        }
    }

    public void deplacer() // lancer le De et faire l'action de la case une seule fois
    {

        int val = lancer_De();
        if (num_case_act + val > 99) {
            System.out.println("Reculer " + (joeur.getCaseActuel() + val - 99) + " en arriere");
            // joeur.modifierCase(-(joeur.getCaseActuel()+val-99));
            val = -(joeur.getCaseActuel() + val - 99);
        }
        joeur.modifierCase(val);
        System.out.println("Cliquer sur la case :");
        Scanner sc = new Scanner(System.in);
        int valjoeur = sc.nextInt();
        while (!Test(valjoeur)) {
            System.out.println("Cliquer sur la case :");
            valjoeur = sc.nextInt();
            System.out.println("===========================");
        }
        grille.plateau[num_case_act].Action(joeur);
        System.out.println("Cliquer sur la case :");
        valjoeur = sc.nextInt();
        while (!Test(valjoeur)) {
            System.out.println("Cliquer sur la case :");
            valjoeur = sc.nextInt();
        }
    }

    public void jouer() {
        while (num_case_act != 99) {
            deplacer();
        }

    }

}
class CaseFausseException extends Exception {

}
public class Cases {
    public static void main(String[] args) {
        // Utilisateur usr = new Utilisateur("Boualem");
        // Joeur j = new Joeur(usr);
        // Partie p = new Partie(j);
        // p.jouer();
        Grille grille=new Grille() ;
        grille.afficher();

}
}

