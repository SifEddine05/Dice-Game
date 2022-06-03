package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.Serializable;
import java.util.Scanner;
public class Partie implements Serializable {
    private Grille grille = new Grille();
    private int num_case_act = 0;
    private int lastimg ;
    private int lastdef ;
    private String lastmsg ="Throw dice";
    public void setLastimg(int imm)
    {
        this.lastimg=imm ;
    }
    public int getlastimg()
    {
        return this.lastimg ;
    }
    public void setLastdef(int def)
    {
        this.lastdef=def ;
    }
    public int getLastdef()
    {
        return this.lastdef ;
    }
    public void setLastmsg(String lastmsg)
    {
        this.lastmsg=lastmsg;
    }
    public String getLastmsg()
    {
        return this.lastmsg ;
    }
    private Joeur joeur;
    static long meilleure_score;

    public Partie(Joeur j ) {
        this.joeur = j;
        this.grille.Charger_plateau();
        this.grille.generer_plateau_randomly();
    }
    public Joeur getJoeur()
    {
        return this.joeur ;
    }
    public Case [] getPlateau ()
    {
        return  this.grille.getPlateau() ;
    }
   public int lancer_De() {
        De De = new De() ;
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

    /*public void deplacer() // lancer le De et faire l'action de la case une seule fois
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
    }*/

   /* public BufferedReader getfile()
    {
        return this.grille.getFile();
    }
    /*public BufferedReader getFileimg()
    {
        return this.grille.getFimg() ;
    }*/
    public void setNum_case_act(int val)
    {
        this.num_case_act=val ;
    }
    public int getNum_case_act ()
    {
        return this.num_case_act;
    }

   /* public void jouer() {
      /*  while (num_case_act != 99) {
            deplacer();
        }*/

    }


