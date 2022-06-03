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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.in;

public class AceuillController {
     private  Partie pAcceuil ;
     public Joeur j ;
     public Utilisateur user ;
     @FXML
     Label username ;
     @FXML
    CheckBox newuser ;
    @FXML
    Button newgame ;

    @FXML
    Button cnt ;

    @FXML
    TextField name ;
    @FXML
    Label mess=new Label() ;
    public void Newgame(ActionEvent event)  throws IOException{


        //readFile();
        if (name.getText().length() == 0) {
            username.setText("saisier votre nom SVP !");
        } else {
            username.setText("");
            newgame.setDisable(false);
            cnt.setDisable(false);

            try{
                FXMLLoader fxmlLoader = new FXMLLoader(AceuillController.class.getResource("hello-view.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                if(newuser.isSelected())
                {

                }
                user=new Utilisateur(name.getText().toUpperCase()) ;
                j=new Joeur(user) ;
                pAcceuil=new Partie(j) ;
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                Scene sc = new Scene(root1) ;
                stage.setScene(sc);
                Stage stg = (Stage) newgame.getScene().getWindow();
                stg.close();
                stage.show();
                stage.setFullScreen(true);
                HelloController helloController = fxmlLoader.getController();
                helloController.demare(pAcceuil);

            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void Loadgame(ActionEvent event) {
        if (name.getText().length() == 0) {
            username.setText("saisier votre nom SVP !");
        }
        else
        {
           String nom = name.getText().toUpperCase() ;
            try{
                ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("src/main/resources/users/"+nom+".dat"))));
                try {
                    pAcceuil = ((Partie)in.readObject());
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(AceuillController.class.getResource("hello-view.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        user=pAcceuil.getJoeur().getUser();
                        j=pAcceuil.getJoeur();
                        //pAcceuil=new Partie(j) ;
                        Stage stage = new Stage();
                        stage.initStyle(StageStyle.DECORATED);
                        Scene sc = new Scene(root1) ;
                        stage.setScene(sc);
                        Stage stg = (Stage) newgame.getScene().getWindow();
                        stg.close();
                        stage.show();
                        stage.setFullScreen(true);
                        HelloController helloController = fxmlLoader.getController();
                        helloController.demare(pAcceuil);

                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                in.close();
            } catch (FileNotFoundException e) {
                username.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();}
        }
    }

    public void Exit(ActionEvent event) {
        Stage stg = (Stage) newgame.getScene().getWindow();
        stg.close();
    }

}
