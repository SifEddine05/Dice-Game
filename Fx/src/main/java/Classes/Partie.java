package Classes;

import java.util.Scanner;
public class Partie {
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
