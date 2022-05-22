package Classes;
import java.util.Random;
public class CaseSaut extends Case {
    public CaseSaut() {
        Color = "Orange";
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

