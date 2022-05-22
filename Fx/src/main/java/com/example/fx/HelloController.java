/*package com.example.fx;

import Classes.Case;
import Classes.Grille;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import javax.crypto.Mac;

public class HelloController {

    @FXML
    private GridPane gridPane;

    @FXML
    void demarer(ActionEvent event) {
            Button btn = new Button("btn1");
            btn.setMaxWidth(Double.MAX_VALUE) ;
            btn.setMaxHeight(Double.MAX_VALUE);
            gridPane.add(btn, 10,10);
        Grille grille1 = new Grille() ;
        grille1.Charger_plateau();
        grille1.generer_plateau_randomly();
        Case Plateau[] = grille1.getPlateau();
        for(int i=0 ; i<99 ; i++)
        {

        }




    }

}
*/
package com.example.fx;

import Classes.Case;
import Classes.Grille;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private GridPane gridpane;

    @FXML
    void demarer(ActionEvent event) {

        Grille grille1 = new Grille() ;
        grille1.Charger_plateau();
        grille1.generer_plateau_randomly();
        Case Plateau[] = grille1.getPlateau();
    int i=0 ;
            for(int j=0 ;j<16 ; j++)
            {
                Button btn = new Button(Integer.toString(i));
                btn.setMaxWidth(Double.MAX_VALUE) ;
                btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
                btn.setStyle("-fx-background-color :"+Plateau[i].getColor());
                gridpane.add(btn, j,0);
                i++;
            }
        for(int j=1 ;j<19 ; j++)
        {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE) ;
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :"+Plateau[i].getColor());
            gridpane.add(btn, 15,j);
            i++;
        }
        for(int j=14 ;j>0 ; j--)
        {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE) ;
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :"+Plateau[i].getColor());
            gridpane.add(btn, j,18);
            i++;
        }
        for(int j=17 ;j>3 ; j--)
        {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE) ;
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :"+Plateau[i].getColor());
            gridpane.add(btn, 1,j);
            i++;
        }
        for(int j=2 ;j<12 ; j++)
        {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE) ;
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :"+Plateau[i].getColor());
            gridpane.add(btn, j,4);
            i++;
        }
        for(int j=5 ;j<16 ; j++)
        {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE) ;
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :"+Plateau[i].getColor());
            gridpane.add(btn, 11,j);
            i++;
        }
        for(int j=10 ;j>4 ; j--)
        {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE) ;
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :"+Plateau[i].getColor());
            gridpane.add(btn, j,15);
            i++;
        }
        for(int j=14 ;j>7 ; j--)
        {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE) ;
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :"+Plateau[i].getColor());
            gridpane.add(btn, 5,j);
            i++;
        }
        for(int j=6 ;j<8 ; j++)
        {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE) ;
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :"+Plateau[i].getColor());
            gridpane.add(btn, j,8);
            i++;
        }
        for(int j=9 ;j<11 ; j++)
        {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE) ;
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :"+Plateau[i].getColor());
            gridpane.add(btn, 7,j);
            i++;
        }


    }

}
