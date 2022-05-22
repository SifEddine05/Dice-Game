package Classes;

public class Grille {
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
    public Case [] getPlateau ()
    {
        return  this.plateau ;
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
