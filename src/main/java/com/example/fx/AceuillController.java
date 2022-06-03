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

   /* public void Readfrom(int dernImg)
    {
        try {
            BufferedReader fimg = new BufferedReader(new FileReader("src/main/resources/Images/image.txt")) ;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }*/
    @FXML
    public void checkNew(ActionEvent e)
    {
        if(newuser.isSelected())
        {
            cnt.setDisable(true);
        }
        else cnt.setDisable(false);
    }
    public Utilisateur[] getusers (){
        Utilisateur list_users[]=new Utilisateur[500] ;

        ObjectInputStream save = null;
        try {
            save = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("src/main/resources/Utilsateurs"))));

        list_users= (Utilisateur[]) save.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            save.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // System.out.println(list_users[0].get_Nom());
        return list_users ;
    }
    public void Newgame(ActionEvent event)  throws IOException{

        Utilisateur listusers[] = getusers() ;
        //readFile();
        if (name.getText().length() == 0) {
            username.setText("saisier votre nom SVP !");
        }
        else {
            username.setText("");
            newgame.setDisable(false);
            cnt.setDisable(false);

            try{
                FXMLLoader fxmlLoader = new FXMLLoader(AceuillController.class.getResource("hello-view.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                if(newuser.isSelected())
                {
                    //cnt.setDisable(true);
                    boolean existe = false ;
                    int i =0 ;
                    while (!existe &&  i < listusers.length)
                    {
                        String nom = name.getText() ;
                        //System.out.println("ssssssssssssssssss"+listusers[0].get_Nom()+"..."+nom);
                        if(listusers[i]==null) i=listusers.length ;
                        else if(listusers[i].get_Nom().equals(nom.toUpperCase())) existe=true;
                        else  i++ ;
                    }
                    if (existe==true)
                    {
                        username.setText("this name exist please change it !");
                        username.setVisible(true);
                    }
                    else
                    {
                        user=new Utilisateur(name.getText().toUpperCase()) ;
                        j=new Joeur(user) ;
                        pAcceuil=new Partie(j) ;
                        int j= 0 ;
                        boolean tt = true ;
                        while (j<listusers.length && tt)
                        {
                            if(listusers[j]==null)
                            {
                                tt=false ;
                            }
                            else j++ ;
                            System.out.println("sss");
                        }
                        //il faut faire boucle pour trouver la fin
                        listusers[j]=user ;
                        ObjectOutputStream save2 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/Utilsateurs"))));
                       save2.writeObject(listusers);
                       save2.close();
                        ///ajouter user a la table des users

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
                    }
                }
                else
                {
                    boolean test = false ;
                    int i =0 ;
                    while (!test &&  i < listusers.length)
                    {
                        String nom = name.getText() ;
                        //System.out.println("ssssssssssssssssss"+listusers[0].get_Nom()+"..."+nom);
                        if(listusers[i]==null) i=listusers.length ;
                        else if(listusers[i].get_Nom().equals(nom.toUpperCase())) test=true;
                        else  i++ ;
                    }
                    if (test)
                    {
                        user=listusers[i] ; ;
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
                    }
                    else
                    {
                        username.setText("this user name dosen't exist ");
                        username.setVisible(true);
                    }
                    //ajouter l'utilistaeur a la liste
                }


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
                       // System.out.println("file"+pAcceuil.getDernierImg());
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
