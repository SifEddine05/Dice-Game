package Classes;

public class Utilisateur {
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
