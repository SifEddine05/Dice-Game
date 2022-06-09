package com.example.fx;

import Classes.Joeur;
import Classes.Partie;
import Classes.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    Label player ;
    @FXML
    Label score ;

    @FXML
    Label bestjrscore ;

    @FXML
    Label bestjscore ;

    @FXML
    Button newbutton ;

    @FXML
    public void get() throws IOException, ClassNotFoundException {
        Utilisateur list_users[]=new Utilisateur[500] ;
    /*  ObjectOutputStream s= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/BestScore"))));
        // s.writeObject(Long.toString(p.getJoeur().getScoreActuel()));
        s.writeObject(p.getJoeur().getUser());
        s.close();*/
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("src/main/resources/BestScore"))));
     //  int best_score= Integer.parseInt((String) in.readObject()) ;
        Utilisateur best_score= (Utilisateur) in.readObject();
      // bestjscore.setText(Integer.toString(best_score));
        bestjscore.setText(Integer.toString((int) best_score.get_meilleur_score()));
        player.setText(best_score.get_Nom());
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
                      //  list_users[i].set_meilleur_score(p.getJoeur().getScoreActuel());
                        if(p.getJoeur().getScoreActuel()>best_score.get_meilleur_score())
                        {
                            morebestscore.setText("Confratulations !! you are the best score");
                            bestjscore.setText(Long.toString(p.getJoeur().getScoreActuel()));
                            p.getJoeur().getUser().set_meilleur_score(p.getJoeur().getScoreActuel());
                            player.setText(p.getJoeur().getUser().get_Nom());
                           // System.out.println(p.getJoeur().);
                            ObjectOutputStream s= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/BestScore"))));
                           // s.writeObject(Long.toString(p.getJoeur().getScoreActuel()));
                            s.writeObject(p.getJoeur().getUser());
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
            if(p.getJoeur().getScoreActuel()>0)
            {
                morebestscore.setText("Confratulations !! you get more than your best score");
                if(p.getJoeur().getScoreActuel()>best_score.get_meilleur_score())
                {
                    morebestscore.setText("Confratulations !! you are the best score");
                }
            }
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


    @FXML
    public void Newbutton(ActionEvent event)  throws IOException{


        //readFile();
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(AceuillController.class.getResource("Aceuill.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
             /*  Utilisateur user=new Utilisateur(p.getJoeur().getUser().get_Nom().toUpperCase()) ;
               Joeur j=new Joeur(user) ;
               Partie pAcceuil=new Partie(j) */;
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                Scene sc = new Scene(root1) ;
                stage.setScene(sc);
                Stage stg = (Stage) newbutton.getScene().getWindow();
                stg.close();
                stage.show();
                stage.setFullScreen(true);
               // HelloController helloController = fxmlLoader.getController();
            //    helloController.demare(pAcceuil);

            } catch(Exception e) {
                e.printStackTrace();
            }


    }

}
