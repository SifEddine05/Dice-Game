package com.example.fx;

import Classes.Partie;
import Classes.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;

public class FinController {
    private Partie p ;
    public void setP(Partie partie)
    {
        this.p = partie ;
    }

    @FXML
    Label morebestscore ;
    @FXML
    Label score ;

    @FXML
    Label bestjrscore ;

    @FXML
    Label bestjscore ;

    @FXML
    public void get() throws IOException, ClassNotFoundException {
        Utilisateur list_users[]=new Utilisateur[500] ;
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("src/main/resources/BestScore"))));
       int best_score= Integer.parseInt((String) in.readObject()) ;
        in.close();
        // list_users[0]=p.getJoeur().getUser() ;
        // list_users.add(p.getJoeur().getUser()) ;
        ObjectInputStream save = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("src/main/resources/Utilsateurs"))));
        // save.writeObject(list_users);
        list_users= (Utilisateur[]) save.readObject();
        // System.out.println(list_users[0].get_Nom());
        save.close();
        ObjectOutputStream save2 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/Utilsateurs"))));
       /* save2.writeObject(list_users);
        save2.close();*/
        boolean cnt=true ;
        boolean trv=false ;
        int i=0 ;
        while (i<500 && cnt==true)
        {
            // System.out.println("le meilleur score "+list_users[i].get_meilleur_score());
            if(list_users[i]==null)
            {
                cnt=false ;
            }
            else
            {
                if(list_users[i].get_Nom().toUpperCase().equals(p.getJoeur().getUser().get_Nom().toUpperCase()))
                {
                    bestjrscore.setText(String.valueOf(list_users[i].get_meilleur_score()));
                   // morebestscore.setText("Confratulations !! you get more than your best score");
                    if(p.getJoeur().getScoreActuel()>list_users[i].get_meilleur_score())
                    {
                        morebestscore.setText("Confratulations !! you get more than your best score");
                        if(p.getJoeur().getScoreActuel()>best_score)
                        {
                            morebestscore.setText("Confratulations !! you are the best score");
                            ObjectOutputStream s= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/BestScore"))));
                            s.writeObject(Long.toString(p.getJoeur().getScoreActuel()));
                            s.close();
                        }
                        morebestscore.setVisible(true);
                        bestjrscore.setText(String.valueOf(list_users[i].get_meilleur_score()));
                        list_users[i].set_meilleur_score(p.getJoeur().getScoreActuel());
                    }

                    trv=true ;
                    cnt=false ;

                }

                //System.out.println("le nom de user "+list_users[i].get_Nom());
                i++ ;
            }
        }

        if(!trv)
        {
            p.getJoeur().getUser().set_meilleur_score(p.getJoeur().getScoreActuel());
            list_users[i]=p.getJoeur().getUser() ;
        }
        save2.writeObject(list_users);
        save2.close();
    }


    @FXML
    public void fin()  {

        try {
            get() ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        score.setText(String.valueOf(p.getJoeur().getScoreActuel()));
    }

}
