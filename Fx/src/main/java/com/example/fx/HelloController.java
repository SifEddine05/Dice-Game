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

import Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class HelloController {
    private De De = new De();
    @FXML
    private Label NumQues ;
    @FXML
    private GridPane gridpane;
    @FXML
    private Button Lancer_De;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private Label Info2=new Label();
    @FXML
    private Label Info3 = new Label();
    @FXML
   private Label Info = new Label();
    @FXML
    private  Label Info4 = new Label();

    @FXML
    private  Label Question ;
    @FXML
    private RadioButton  sug1 ;
    @FXML
    private RadioButton sug2  ;
    @FXML
    private RadioButton  sug3;
    @FXML
  private   RadioButton  sug4  ;

    @FXML
   private Label Aswr ;
    @FXML
    private  Button Sub  ;
    private static Boolean Test ;
    private static Boolean Testimg ;
    public static void setTestimg(Boolean b)
    {
        Testimg= b ;
    }

    public static void setTest(Boolean b)
    {
        Test= b ;
    }


    public Partie getPartie() {
        return p;
    }

    private Partie p;
   private String Reponse ;

    private int num_case_actuel ;
    private static  Boolean Fin =false;
    Alert alert= new Alert(Alert.AlertType.NONE) ;
    public static void setFin()
    {
        Fin=true ;
    }
public void openNewwindowImage()
{
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("Images.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        ImagesController imagesController = fxmlLoader.getController();
        //questionController.setReponse(Reponse);
        imagesController.setP(p);
        imagesController.genererImage();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.showAndWait();
        //return true ;

    } catch(Exception e) {
        e.printStackTrace();
    }
}


    public void openNewWindow (){


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("Question.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            QuestionController questionController = fxmlLoader.getController();
            questionController.setReponse(Reponse);
            questionController.setP(p);
          questionController.genererQuestion();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            stage.showAndWait();
            //return true ;

        } catch(Exception e) {
            e.printStackTrace();
        }
       // return false;
    }
    /*@FXML
    void Submit(ActionEvent event) {
        int cs = p.getNum_case_act() ;
       Case plateau [] = p.getPlateau() ;
        if(sug1.isSelected())
        {

            if( sug1.getText()!=Reponse )
            {
                Aswr.setText("Votre Reponse est Fausse");
                ((CaseDefinition)plateau[cs]).SetLose();
            }
            else
            {
                Aswr.setText("Votre Reponse est Juste");
            }
            Aswr.setVisible(true);

        } else if (sug2.isSelected()) {
            if( sug2.getText()!=Reponse )
            {
                Aswr.setText("Votre Reponse est Fausse");
                ((CaseDefinition)plateau[cs]).SetLose();
            }
            else
            {
                Aswr.setText("Votre Reponse est Juste");
            }
            Aswr.setVisible(true);

        } else if (sug3.isSelected()) {
            if( sug3.getText()!=Reponse )
            {
                Aswr.setText("Votre Reponse est Fausse");
                ((CaseDefinition)plateau[cs]).SetLose();
            }
            else
            {
                Aswr.setText("Votre Reponse est Juste");
            }
            Aswr.setVisible(true);
        } else if (sug4.isSelected()) {
            if( sug4.getText()!=Reponse )
            {
                Aswr.setText("Votre Reponse est Fausse");
                ((CaseDefinition)plateau[cs]).SetLose();
            }
            else
            {
                Aswr.setText("Votre Reponse est Juste");
            }
            Aswr.setVisible(true);
        }
        else
        {
            Aswr.setText("choissez  une reponse s'il vous plait ");
            Aswr.setVisible(true);
        }
        /*try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
            System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        }*/
     /*   Stage stg  = (Stage) Sub.getScene().getWindow() ;
        stg.close();



    }*/



    public Boolean Test(int valjoeur) // tester si le joeur aller a la case vrai
    {
        //num_case_actuel = p.getNum_case_act();
        Joeur joeur = p.getJoeur();
        if (joeur.getCaseActuel() == valjoeur) {
            //set Num caseAct(valJoueur)
            p.setNum_case_act(valjoeur);
            num_case_actuel=valjoeur ;
            return true;
        } else {
            Info4.setVisible(true);
            Info4.setText("la case est errone cliquer sur la case correct");
            //  System.out.println("la case est errone cliquer sur une autre case ");

            return false;
        }
    }

    void Action(ActionEvent e) {
        // num_case_actuel = p.getNum_case_act();
        Case Plateau[] = p.getPlateau();
        Joeur j = p.getJoeur();
        Object node = e.getSource(); //returns the object that generated the event
        System.out.println(node instanceof Button); //prints true. demonstrates the source is a Button
        //since the returned object is a Button you can cast it to one
        Button b = (Button) node;
       // boolean go =false ;
       // System.out.println(b.getText());
        int valjoeur = Integer.parseInt(b.getText());

            if (Test(valjoeur) ) {
                if(Plateau[valjoeur].getColor()=="blue")
                {


                    openNewWindow();
                        String ss = Plateau[j.getCaseActuel()].Action(j);
                        Info.setText(ss);
                        Info4.setVisible(false);
                        Info3.setText("La case Actuel est : "+num_case_actuel);
                        Info2.setText("Votre Score est : "+j.getScoreActuel());
                        if(Test)
                        {
                            Info4.setVisible(true);
                            Info4.setText("Votre Reponse est juste");
                        }
                        else
                        {
                            Info4.setVisible(true);
                            Info4.setText("Votre Reponse est fausse");
                        }

                } else if (Plateau[valjoeur].getColor()=="Pink") {
                    openNewwindowImage();
                    String ss = Plateau[j.getCaseActuel()].Action(j);
                    Info.setText(ss);
                    Info4.setVisible(false);
                    Info3.setText("La case Actuel est : "+num_case_actuel);
                    Info2.setText("Votre Score est : "+j.getScoreActuel());
                    if(Testimg)
                    {
                        Info4.setVisible(true);
                        Info4.setText("Votre Reponse est juste");
                    }
                    else
                    {
                        Info4.setVisible(true);
                        Info4.setText("Votre Reponse est fausse");
                    }
                    
                } else
                {
                    String ss = Plateau[j.getCaseActuel()].Action(j);
                    if (Fin)
                    {
                        alert.setTitle("Filistation !!!");

                        if (j.getScoreActuel() > j.getmeilleur_Score()) {
                            j.set_meilleur_score(j.getScoreActuel());
                            alert.setContentText("Vous Avez Gagner Filistation !!!\nVous avez battu votre meilleur score \\nle nouveau meilleur score est \" + j.getScoreActuel()");
                          //  return ("Vous avez battu votre meilleur score \nle nouveau meilleur score est " + j.getScoreActuel());
                            //System.out.println(
                            // "Vous avez battu votre meilleur score \nle nouveau meilleur score est " + j.getScoreActuel());

                        } else {
                            alert.setContentText("Vous Avez Gagner Filistation !!! votre score de ce Partie est : " + j.getCaseActuel() + "\n Votre meuilleur score est : "+ j.getmeilleur_Score());
                           // return ("votre score de ce Partie est : " + j.getCaseActuel() + "\n Votre meuilleur score est : "
                                  //  + j.getmeilleur_Score());

                        }
                    }
                    Info.setText(ss);


                    Info4.setVisible(false);
                    Info3.setText("La case Actuel est : "+num_case_actuel);
                    Info2.setText("Votre Score est : "+j.getScoreActuel());
                }

            }
            if(Info.getText()=="Relancer le De")
            {
                Lancer_De.setDisable(false);
            }
       // }


    }


    public void lancer_De(ActionEvent event) {
        Lancer_De.setDisable(true);
        Info4.setVisible(false);
        Thread thread = new Thread() {
            public void run() {
                /*  System.out.println("Thread Running");*/

                for (int i = 0; i < 15; i++) {

                    /*  File file = new File("D:\\Img2.png");*/

                    int nb1 = De.De1();
                    int nb2 = De.De2();
                   /* String url1 = String.valueOf(getClass().getResource("inverted-dice-" + nb1 + ".png"));
                    String url2 = String.valueOf(getClass().getResource("inverted-dice-" + nb2 + ".png"));
                    Image img11 = new Image(url1);
                    Image img22 = new Image(url2);*/
                   File file = new File("src/main/resources/Img/inverted-dice-" + nb1 + ".png") ;
                    File file1 = new File("src/main/resources/Img/inverted-dice-" + nb2 + ".png") ;
                    img1.setImage(new Image(file.toURI().toString()));
                    img2.setImage(new Image(file1.toURI().toString()));

                   /* img1.setImage(img11);
                    img2.setImage(img22);*/
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Lancer_De.setDisable(true);


            }
        };
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //int num_case_act = p.getNum_case_act();
        Joeur joeur = p.getJoeur();
        int val = De.Som();
        Info.setText("Avancer "+val+" Cases en avant");
        System.out.println("NumCase"+num_case_actuel);
        System.out.println("Avancer "+val+" Cases en avant");
       // System.out.println("");
       /* if (num_case_act + val > 99) {
            Info.setText("Reculer " + (joeur.getCaseActuel() + val - 99) + " en arriere");
            val = -(joeur.getCaseActuel() + val - 99);
        }*/
        if (num_case_actuel + val > 99) {

            // joeur.modifierCase(-(joeur.getCaseActuel()+val-99));
            int val2 = 99 - joeur.getCaseActuel();
            val = -(joeur.getCaseActuel() + val - 99) + val2;
            // joeur.modifierCase(val2+joeur.getCaseActuel()) ;
            if (val > 0) {
                Info.setText("Avancer " + val + " en avant");
            } else {
                Info.setText("Recouler " + val + " en arriere");
            }

        }
        joeur.modifierCase(val);
        Lancer_De.setDisable(true);
    }


    /**********************************Creation de joeur**************/
    Utilisateur user = new Utilisateur("Sifou");
    Joeur j = new Joeur(user);

    /********************************************/
    public void CreePlateau(Case Plateau[]) {

        int i = 0;
        for (int j = 0; j < 16; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");

            btn.setOnAction(e -> Action(e));
            btn.setStyle("-fx-background-color :" + Plateau[i].getColor());
            gridpane.add(btn, j, 0);
            i++;
        }
        for (int j = 1; j < 19; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setOnAction(e -> Action(e));
            btn.setStyle("-fx-background-color :" + Plateau[i].getColor());
            gridpane.add(btn, 15, j);
            i++;
        }
        for (int j = 14; j > 0; j--) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setOnAction(e -> Action(e));
            btn.setStyle("-fx-background-color :" + Plateau[i].getColor());
            gridpane.add(btn, j, 18);
            i++;
        }
        for (int j = 17; j > 3; j--) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setOnAction(e -> Action(e));
            btn.setStyle("-fx-background-color :" + Plateau[i].getColor());
            gridpane.add(btn, 1, j);
            i++;
        }
        for (int j = 2; j < 12; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setOnAction(e -> Action(e));
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :" + Plateau[i].getColor());
            gridpane.add(btn, j, 4);
            i++;
        }
        for (int j = 5; j < 16; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setOnAction(e -> Action(e));
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :" + Plateau[i].getColor());
            gridpane.add(btn, 11, j);
            i++;
        }
        for (int j = 10; j > 4; j--) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setOnAction(e -> Action(e));
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :" + Plateau[i].getColor());
            gridpane.add(btn, j, 15);
            i++;
        }
        for (int j = 14; j > 7; j--) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setOnAction(e -> Action(e));
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :" + Plateau[i].getColor());
            gridpane.add(btn, 5, j);
            i++;
        }
        for (int j = 6; j < 8; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setOnAction(e -> Action(e));
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :" + Plateau[i].getColor());
            gridpane.add(btn, j, 8);
            i++;
        }
        for (int j = 9; j < 11; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setOnAction(e -> Action(e));
//                btn.setStyle("HOVERED_BUTTON_STYLE");
            btn.setStyle("-fx-background-color :" + Plateau[i].getColor());
            gridpane.add(btn, 7, j);
            i++;
        }
    }



    /*public void deplacer1(Partie p) // lancer le De et faire l'action de la case une seule fois
    {
        /*int num_case_act = p.getNum_case_act() ;
        Joeur joeur = p.getJoeur() ;
        int val = De.Som();
        if (num_case_act + val > 99) {
            Info.setText("Reculer " + (joeur.getCaseActuel() + val - 99) + " en arriere");
            val = -(joeur.getCaseActuel() + val - 99);
        }
        joeur.modifierCase(val);*/
        //System.out.println("Cliquer sur la case :");
        //  Scanner sc = new Scanner(System.in);
        //int valjoeur = sc.nextInt();
       /* while (!Test(valjoeur)) {
            System.out.println("Cliquer sur la case :");
            valjoeur = sc.nextInt();
            System.out.println("===========================");
        }*/
        // grille.plateau[num_case_act].Action(joeur);
       /* System.out.println("Cliquer sur la case :");
        valjoeur = sc.nextInt();
        while (!Test(valjoeur)) {
            System.out.println("Cliquer sur la case :");
            valjoeur = sc.nextInt();
        }
    }*/
        @FXML
        void demarer (ActionEvent event){

       Partie Partie = new Partie(j);
        this.p = Partie;
        this.num_case_actuel=p.getNum_case_act();
        Case Plateau[] = Partie.getPlateau();
        CreePlateau(Plateau);
        Lancer_De.setDisable(false);
        //openNewWindow();
           // openNewwindowImage();
        //Info.setText("Som" + De.Som());
       // System.out.println("Som" + De.Som());

    }


}
