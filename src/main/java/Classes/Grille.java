package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class Grille implements Serializable {
   // private transient  BufferedReader f = null;
   // private  transient BufferedReader fimg = null ;

    public Case plateau[] = new Case[100];
/*public  BufferedReader getFile ()
{
    return this.f ;
}
*/


    /*public BufferedReader getFimg() {
        return this.fimg;
    }*/

    public void Charger_plateau()// remplir le plateau sequentiellement avec des cases
    {
        // plateau=new Case[100] ;
        /*try {
            //FileReader(String.valueOf(getClass().getResource("definition.txt"))
           // fimg = new BufferedReader(new FileReader("src/main/resources/Images/image.txt")) ;
            f = new BufferedReader(new FileReader("src/main/resources/Definitions/definition.txt"));
        } catch (IOException e) {
            System.out.println("l'erreure est : " + e.getStackTrace());
        }*/
        int j;
        int i;
        plateau[0] = new CaseDepart();
        for (i = 0; i < 5; i++) {
            j = 5*i + 1;
            plateau[j] = new CaseBonus();
            //  plateau[j] = new CaseFin();

            plateau[j + 1] =  new CaseMalus();
            //plateau[j+1 ] = new CaseFin();

            plateau[j + 2] =new CaseImage();
           // plateau[j + 2] = new CaseFin();
          //  plateau[j + 3] =new CaseFin();
            plateau[j + 3] = new CaseDefinition();
            plateau[j + 4]=new CaseSaut();

           // plateau[j + 3] = new CaseImage();
           // plateau[j+4]=new CaseSaut() ;
          //  plateau[j + 4] =new CaseSaut();
        }
        for (i = 26; i < 98; i++) {
           // plateau[i] = new CaseFin();
            plateau[i]=new CaseParcours() ;
        }
       // plateau[98] = new CaseParcours();
        plateau[98] = new CaseParcours();
        plateau[99] = new CaseFin();

    }

    public void generer_plateau_randomly()// generer un palteau aleatoire apres sa creation on utilisant des
    // permutations
    {
        this.Charger_plateau();
        for (int i = 1; i < 96; i++) {
            int index = ((int) (Math.random() * 97)) + 1;
            Case temp = plateau[i];
            if(plateau[i].Color.equals("green"))
            {
                if( !plateau[i+1].Color.equals("red") && !plateau[i-1].Color.equals("red") )
                {
                    plateau[i] = plateau[index];
                    plateau[index] = temp;
                }
            }
            else
            {
                plateau[i] = plateau[index];
                plateau[index] = temp;
            }

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
