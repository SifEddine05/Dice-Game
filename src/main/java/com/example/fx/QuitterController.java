package com.example.fx;

import Classes.Partie;
import Classes.Utilisateur;
import Classes.jeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuitterController {
    private  Partie p ;
    public void setP(Partie partie)
    {
        this.p = partie ;
    }

    @FXML
    Button q_direct ;
    @FXML
    void direct(ActionEvent event)
    {
       /* FXMLLoader fxmlLoader = new FXMLLoader(QuitterController.class.getResource("hello-view.fxml"));
        HelloController helloController = fxmlLoader.getController() ;*/
        HelloController.close() ;
        Stage stg = (Stage) q_direct.getScene().getWindow();
        stg.close();
    }

    @FXML
    Button quiit ;
    @FXML
    void quitquit(ActionEvent e )
    //quitter la page de Exit
    {
        System.out.println("quit ");
        Stage stg = (Stage) quiit.getScene().getWindow();
        stg.close();
    }



    @FXML
    void sauvegarder() throws IOException, ClassNotFoundException
    //sauvegarder une partie lorsque on essaye de quitter le jeux
    {
        Utilisateur list_users[]=new Utilisateur[500] ;
        //list_users[0]=p.getJoeur().getUser() ;
        // list_users.add(p.getJoeur().getUser()) ;
        ObjectInputStream save = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("src/main/resources/Utilsateurs"))));
       // save.writeObject(list_users);
        list_users= (Utilisateur[]) save.readObject();
       // System.out.println(list_users[0].get_Nom());
        save.close();
       ObjectOutputStream save2 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/Utilsateurs"))));

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
                    System.out.println(" le joeur existe et le meilleur score avant : "+list_users[i].get_meilleur_score());
                    if(p.getJoeur().getScoreActuel()>list_users[i].get_meilleur_score())
                    {
                        list_users[i].set_meilleur_score(p.getJoeur().getScoreActuel());
                    }
                    System.out.println(" le joeur existe et le meilleur score avant : "+list_users[i].get_meilleur_score());

                    trv=true ;
                    cnt=false ;

                }

                    //System.out.println("le nom de user "+list_users[i].get_Nom());
                    i++ ;
            }
        }

        if(!trv)
        {
            System.out.println("le joeur n'existe pas");
            p.getJoeur().getUser().set_meilleur_score(p.getJoeur().getScoreActuel());
            list_users[i]=p.getJoeur().getUser() ;
        }
        save2.writeObject(list_users);
        save2.close();
      //  save.close();
       // save.writeObject(list_users);


        String name = p.getJoeur().getUser().get_Nom() ;
        try {
            if(p.getJoeur().getScoreActuel()>p.getJoeur().getUser().get_meilleur_score())
            {
                p.getJoeur().getUser().set_meilleur_score(p.getJoeur().getScoreActuel());
            }
            System.out.println(p.getJoeur().getUser().get_meilleur_score());
            ObjectOutputStream  out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream( new  File("src/main/resources/users/"+name+".dat"))));
//écriture les objets dans un fichier
            out.writeObject(p);
          //  out.writeObject(jeu);
            out.close();
        }
        catch
        (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        HelloController.close();
        Stage stg = (Stage) q_direct.getScene().getWindow();
        stg.close();

    }


}
