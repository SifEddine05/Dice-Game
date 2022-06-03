package Classes;

import java.io.Serializable;

public class Utilisateur implements Serializable {
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
    public  String get_Nom(){return this.nom ;}

}
