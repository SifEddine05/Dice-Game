package Classes;

import java.io.Serializable;

public class Joeur implements Serializable {
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

    public Utilisateur getUser(){return user;}

}
