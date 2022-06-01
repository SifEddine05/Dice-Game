package com.example.fx;

import Classes.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;

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
    void sauvegarder()
    //sauvegarder une partie lorsque on essaye de quitter le jeux
    {
        String name = p.getJoeur().getUser().get_Nom() ;
        try {
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
