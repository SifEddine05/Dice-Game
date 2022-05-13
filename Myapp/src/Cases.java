import java.util.Random;
abstract class    Case {
  protected String Color ; 
  protected int  Nb_Case;
  protected int nbr_Points ; 
  abstract void Action (Joeur j ) ;  
}
class CaseDepart extends Case {
    public CaseDepart()
    {
        Color="jaune";
        Nb_Case=0;
        nbr_Points=0; 

    }
    public void Action(Joeur j)
    {
        j.modifierScore(nbr_Points);
        j.modifierCase(Nb_Case);
        //System.out.println("avancer de  "+val+" case en avant");
    }
}
class CaseParcours extends Case
{
    public CaseParcours()
    {
        Color="blanc";
        Nb_Case=0;
        nbr_Points=0; 
    }
    public void Action (Joeur j)
    {
        j.modifierCase(Nb_Case);
        j.modifierScore(nbr_Points);

    }

}
class CaseBonus extends Case {
    public CaseBonus()
    {
        Color="verte";
        Nb_Case=2;
        nbr_Points=10; 
    }
    public void Action (Joeur j)
    {
        j.modifierCase(Nb_Case);
        System.out.println("Avancer "+Nb_Case+" en avant");
        j.modifierScore(nbr_Points);

    }

}
class CaseMalus extends Case {
    public CaseMalus ()
    {
        Color = "rouge";
        Nb_Case = -2 ; 
        nbr_Points = -10;
    } 
    public void Action (Joeur j)
    {
        j.modifierCase(Nb_Case);
        System.out.println("Reculer "+Nb_Case+" en ariere");
        j.modifierScore(nbr_Points);

    }
} 
class CaseSaut extends Case {
    public CaseSaut ()
    {
        Color = "orange";
        Random rand = new Random(); //instance of random class
        int random = rand.nextInt(10); 
        int type =rand.nextInt(2)+1;
        if (type == 0){
            Nb_Case = random ; 
        }
        else{
            Nb_Case = -random ; 
        }
        nbr_Points = 0;
    }  
    public void Action (Joeur j)
    {
        j.modifierCase(Nb_Case);
        if (Nb_Case<0){
            System.out.println("Reculer "+Nb_Case+" en ariere");
        }
        else 
        {
            System.out.println("Avancer"+Nb_Case+" en avant");
        }
        j.modifierScore(nbr_Points);
    }
}
abstract class CaseQuestion extends Case 
{
    //le fichier des questions 
    abstract void genererQuestion () ; 

}
class CaseDefinition extends CaseQuestion {
    public CaseDefinition ()
    {
        // la definition de fichier 
        Color = "bleu" ; 
        nbr_Points = 20;
        Nb_Case = 4 ; 
    }
    public void SetLose () //si n'est pas reponder aux question
    {
        nbr_Points = -10;
        Nb_Case = 0 ; 
    }
    public void Action (Joeur j)
    {
        j.modifierCase(Nb_Case);
        if (Nb_Case>0){
            System.out.println("Avancer "+Nb_Case+" en avant");
        }
        j.modifierScore(nbr_Points);
    }
    public void genererQuestion(){}; 
}

class CaseImage extends CaseQuestion {
    public CaseImage ()
    {
        // la definition de fichier 
        Color = "rose" ; 
        nbr_Points = 10;
        Nb_Case = 2 ; 
    }
    public void SetLose () //si n'est pas reponder aux question
    {
        nbr_Points = 0;
        Nb_Case = 0 ; 
    }
    public void Action (Joeur j)
    {
        j.modifierCase(Nb_Case);
        if (Nb_Case>0){
            System.out.println("Avancer "+Nb_Case+" en avant");
        }
        j.modifierScore(nbr_Points);
    }
    public void genererQuestion(){}; 
}

class CaseFin extends Case {
    private Boolean gagner = false ;  
    public CaseFin (int valeurDesDe , Joeur j)
    {
        Color = "noire" ; 
        if (j.getCaseActuel()==99)
        {
             this.gagner = true ;
        } 
        else 
        {
            Nb_Case=-(j.getCaseActuel()+valeurDesDe-99);
            nbr_Points= 0;
        }
    }
    public static void  fin(Joeur j ) {
        j.
    }
    public void Action (Joeur j)  
    {
        if (gagner==true)
        {
            System.out.println("Vous Avez Gagner Filistation !!!");
            fin();
        }
        else{
            j.modifierCase(Nb_Case);
            j.modifierScore(nbr_Points);
            System.out.println("Reculer "+Nb_Case+" en avant");
        }
    
    }
}
class De {
    public static int   De1()
    {
        Random rand = new Random(); //instance of random class
        int random = rand.nextInt(6); 
        return random+1;
    }
    public static int   De2()
    {
        Random rand = new Random(); //instance of random class
        int random2 = rand.nextInt(6); 
        return random2+1;
    } 
}
class Utilisateur {
    private String nom ; 
    private long meilleur_Score = 0  ; 
    public Utilisateur (String nom )
    {
        this.nom = nom ; 

    }
    public void set_meilleur_score(long score)
    {
        this.meilleur_Score=score ;
    }
    public long get_meilleur_score ()
    {
        return this.meilleur_Score ; 
    }
}
class Joeur {
    private long ScoreActuel=0 ; 
    private int  numCaseActuel =0; 
    private Utilisateur user ; 
    public Joeur (Utilisateur user){
        this.user=user; 
    }
    public void modifierScore(long val )
    {
        this.ScoreActuel=this.ScoreActuel+val ; 
    }
    public int getCaseActuel ()
    {
        return this.numCaseActuel;
    }
    public void modifierCase(int val)
    {
        this.numCaseActuel=this.numCaseActuel+val ; 
    }


}