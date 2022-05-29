package com.example.fx;

import Classes.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AceuillController {
     Partie pAcceuil ;
    @FXML
    Button newgame ;

    @FXML
    Button cnt ;

    @FXML
    TextField name ;
    @FXML
    Label mess=new Label() ;

    public void Newgame(ActionEvent event)  {
        if (name.getText().length() == 0) {
            mess.setText("saisier votre nom SVP !");
        } else {
            mess.setText("");
            newgame.setDisable(false);
            cnt.setDisable(false);

            try{
                FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("hello-view.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                // ImagesController imagesController = fxmlLoader.getController();
                //questionController.setReponse(Reponse);
                //  imagesController.setP(p);
                // imagesController.genererImage();
       /* Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene sc=new Scene(root1) ;
        sc.setFill(Color.TRANSPARENT);
        stage.setScene(sc);
        stage.showAndWait();*/

                Stage stage = new Stage();
                // stage.initStyle(StageStyle.TRANSPARENT);
                stage.initStyle(StageStyle.DECORATED);
                Scene sc = new Scene(root1) ;

                // sc.setFill(Color.TRANSPARENT);
                stage.setScene(sc);
                Stage stg = (Stage) newgame.getScene().getWindow();
                stg.close();
                stage.showAndWait();


            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void Loadgame(ActionEvent event) {
        if (name.getText().length() == 0) {
            mess.setText("saisier votre nom SVP !");
        }
        else
        {
            System.out.println("Autoriser");
        }
    }

    public void Exit(ActionEvent event) {
        Stage stg = (Stage) newgame.getScene().getWindow();
        stg.close();
    }
}
