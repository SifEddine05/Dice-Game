package com.example.fx;

import Classes.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;

public class QuitterController {

    @FXML
    Button q_direct ;
    @FXML
    void direct(ActionEvent event)
    //quitter sans sauvegrader
    {
       /* System.out.println("quitter directement");
        System.out.println(gridpane);
            Stage stg = (Stage) q_direct.getScene().getWindow();
            stg.close();



            System.out.println("la ocndt");
            //Stage stg1 = (Stage) quit.getScene().getWindow();
            Stage stg1 = (Stage) gridpane.getScene().getWindow() ;
            stg1.close();*/




        System.out.println("restaurer");
        try{
            ObjectInputStream in;
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Point.dat"))));
            try {
                System.out.println (((Partie)in.readObject()).getJoeur().getUser().get_Nom());
                //  System.out.println (((Partie)in.readObject()).getJoeur().getScoreActuel());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();}

    }

    @FXML
    Button quiit ;
    @FXML
    void quitquit()
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

        if((HelloController.getPartie())!=null)
        {
            System.out.println("p null cndt");
            System.out.println((HelloController.getPartie()).getJoeur().getScoreActuel());
        }
        try {

            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Point.dat"))));
            System.out.println("sauvegarder") ;

            out.writeObject((HelloController.getPartie())) ;
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (NotSerializableException e)
        {
            System.out.println("there is an exception");
            e.printStackTrace() ;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
