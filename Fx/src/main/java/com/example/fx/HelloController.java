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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    public static void setTest(Boolean b)
    {
        Test= b ;
    }


    public Partie getPartie() {
        return p;
    }

    private Partie p;
   private String Reponse ;





    public boolean openNewWindow (){


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
            return true ;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
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
        int num_case_act = p.getNum_case_act();
        Joeur joeur = p.getJoeur();
        if (joeur.getCaseActuel() == valjoeur) {
            //set Num caseAct(valJoueur)
            p.setNum_case_act(valjoeur);
            return true;
        } else {
            Info4.setVisible(true);
            Info4.setText("la case est errone cliquer sur la case correct");
            //  System.out.println("la case est errone cliquer sur une autre case ");

            return false;
        }
    }

    void Action(ActionEvent e) {
        int num_case_act = p.getNum_case_act();
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
                        Info3.setText("La case Actuel est : "+j.getCaseActuel());
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

                }
                else
                {
                    String ss = Plateau[j.getCaseActuel()].Action(j);
                    Info.setText(ss);
                    Info4.setVisible(false);
                    Info3.setText("La case Actuel est : "+j.getCaseActuel());
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

                    /*  File file = new File("D:\\inverted-dice-2.png");*/

                    int nb1 = De.De1();
                    int nb2 = De.De2();
                    String url1 = String.valueOf(getClass().getResource("inverted-dice-" + nb1 + ".png"));
                    String url2 = String.valueOf(getClass().getResource("inverted-dice-" + nb2 + ".png"));
                    Image img11 = new Image(url1);
                    Image img22 = new Image(url2);
                    img1.setImage(img11);
                    img2.setImage(img22);
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
        int num_case_act = p.getNum_case_act();
        Joeur joeur = p.getJoeur();
        int val = De.Som();
        Info.setText("Avancer "+val+" Cases en avant");
        System.out.println("NumCase"+num_case_act);
       // System.out.println("");
        if (num_case_act + val > 99) {
            Info.setText("Reculer " + (joeur.getCaseActuel() + val - 99) + " en arriere");
            val = -(joeur.getCaseActuel() + val - 99);
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
        Case Plateau[] = Partie.getPlateau();
        CreePlateau(Plateau);
        Lancer_De.setDisable(false);
        //Info.setText("Som" + De.Som());
       // System.out.println("Som" + De.Som());

    }


}
