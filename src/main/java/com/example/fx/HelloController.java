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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class HelloController {

    @FXML
    Button Start ;
    @FXML
    Button quit ;
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
    private Label Info2;
    @FXML
    private Label Info3 = new Label();
    @FXML
   private Label Info = new Label();
    @FXML
    private  Label Info4 = new Label();

    @FXML
    private  Label Question ;
    @FXML
    private  ImageView monkey ;
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


    static  Partie propsP ;

    static Partie getPartie() {return AceuillController.pAcceuil ;
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

    void  PositionMonkey(int valjoeur)
    {
        File filee ;
        if((0<=valjoeur && valjoeur<=15) || (47<=valjoeur && valjoeur<=59)|| (79<=valjoeur && valjoeur<=87) || valjoeur==99 || valjoeur==98 || valjoeur==97)
        {
            filee = new File("src/main/resources/Monkey/monkey.png") ;
            monkey.setImage(new Image(filee.toURI().toString()));
        } else if ((16<=valjoeur && valjoeur<=24) || (60<=valjoeur && valjoeur<=64)|| (88<=valjoeur && valjoeur<=89)) {
            filee = new File("src/main/resources/Monkey/monkey2.png") ;
            monkey.setImage(new Image(filee.toURI().toString()));
        } else if ((40<=valjoeur && valjoeur<=46) || (76<=valjoeur && valjoeur<=78)) {
            filee = new File("src/main/resources/Monkey/monkey3.png") ;
            // Image imgg1 = new Image(filee.toURI().toString()) ;
            monkey.setImage(new Image(filee.toURI().toString()));
        }
        else {
            filee = new File("src/main/resources/Monkey/monkey4.png") ;
            monkey.setImage(new Image(filee.toURI().toString()));
        }
    }
    void Action(ActionEvent e) {
//        imgv.setVisible(false);
        Case Plateau[] = p.getPlateau();
        Joeur j = p.getJoeur();
        Object node = e.getSource(); //returns the object that generated the event
        System.out.println(node instanceof Button); //prints true. demonstrates the source is a Button
        //since the returned object is a Button you can cast it to one
        Button b = (Button) node;

        //ImageView imgv = ((ImageView)b.getGraphic()) ;
/*ImageView imgv = new ImageView() ;
        imgv.setFitWidth(56);
        imgv.setFitHeight(46);
        imgv.setPreserveRatio(true);*/
        //gridpane.getChildren().remove(monkey);

       // boolean go =false ;
       // System.out.println(b.getText());
        int valjoeur = Integer.parseInt(b.getText());
        //imgv = this.imgv ;

       // monkey.setId("ss");

       // b.setGraphic(monkey);
        //monkey.setVisible(true);

        /*try {
            monkey =
        }
        catch (ClassCastException exception )
        {
            System.out.println("sifou");
        }

       if(monkey==null)
       {

       }*/

        //b.graphicProperty().setValue(monkey);


        if (Test(valjoeur) ) {
            Node n =  b.getGraphic();
            PositionMonkey(valjoeur);
            if(n!=null)
            {
               // ((ImageView) n).setImage(null);
                System.out.println("Btn "+b.getText());
                b.setGraphic(null);
                b.setContentDisplay(ContentDisplay.CENTER);
                b.setGraphic((monkey));

                //((ImageView) n).setPreserveRatio(true);
            }
            else {
                b.setContentDisplay(ContentDisplay.CENTER);
                b.setGraphic(monkey);

            }
                //b.setGraphic(monkey);
               // imgv.setVisible(false);
                b.setContentDisplay(ContentDisplay.CENTER);

                if(Plateau[valjoeur].getColor()=="blue")
                {

                       openNewWindow();
                        String ss = Plateau[j.getCaseActuel()].Action(j);
                        Info.setText(ss);
                        Info4.setVisible(false);
                        Info3.setText(""+num_case_actuel);
                        Info2.setText(""+j.getScoreActuel());
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
                    Info3.setText(""+num_case_actuel);
                    Info2.setText(""+j.getScoreActuel());
                    /*b.setGraphic(monkey);
                    b.setContentDisplay(ContentDisplay.CENTER);*/
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
                   /* b.setGraphic(monkey);
                    b.setContentDisplay(ContentDisplay.CENTER);*/
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
                    Info3.setText(""+num_case_actuel);
                    Info2.setText(""+j.getScoreActuel());
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
        System.out.println("eeeeeeeeeeeeeeeeee");
        Stage stg = (Stage) gridpane.getScene().getWindow();
       // System.out.println("W :"+stg.getWidth() );
       double w = stg.getWidth() / 14.0 ;
       double H = stg.getHeight() / 12.0 ;
        //System.out.println("H :"+stg.getHeight() ) ;
        // gridpane.getStylesheets().add(getClass().getResource());

        int i = 0;
        for (int j = 0; j < 16; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            if(j==0)
            {
                File filee = new File("src/main/resources/Monkey/monkey.png") ;
                monkey.setImage(new Image(filee.toURI().toString()));
                btn.setContentDisplay(ContentDisplay.CENTER);
                btn.setGraphic(monkey);
            }

            btn.setStyle("-fx-background-color:transparent");
            btn.setOnAction(e -> Action(e));

           // btn.setTextFill(Color.PURPLE);
            if(p.getPlateau()[i].getColor()=="White")
            {
                btn.setTextFill(Color.BLACK);
            }
            else {
                btn.setTextFill(Color.WHITE);
            }
            File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imageView = new ImageView(img) ;
            imageView.setFitWidth(w);
            imageView.setFitHeight(H);
            imageView.setPreserveRatio(true);
            gridpane.add(imageView , j, 0 );
           gridpane.add(btn, j, 0);

            i++;

            /*Button btn = new Button(Integer.toString(i));
            //btn.setStyle("-fx-background-color:bleu" );
            File file1 = new File("src/main/resources/Img/iii" + ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imgggg = new ImageView(img);
           btn.widthProperty().addListener(e->{
                imgggg.resize(btn.getWidth(),btn.getHeight());
                imgggg.setFitWidth(btn.getWidth());
            });
            btn.heightProperty().addListener(e->{
                imgggg.resize(btn.getWidth(),btn.getHeight());
                imgggg.setFitHeight(btn.getHeight());
            });
           // imgggg.resize(130,30);


            imgggg.setFitWidth(200);
            imgggg.setFitHeight(30);
            imgggg.setPreserveRatio(true);
           // gridpane.add(imgggg, j, 0);
          //  btn.getStylesheets().add("btn.css");
           // btn.setStyle("-fx-border-color : red");
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);

            btn.setOnAction(e -> Action(e));
            //gridpane.
           // gridpane.add(btn, j, 0);
*/
           // i++;
        }
        for (int j = 1; j < 11; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setStyle("-fx-background-color:transparent");
            btn.setOnAction(e -> Action(e));
            if(p.getPlateau()[i].getColor()=="White")
            {
                btn.setTextFill(Color.BLACK);
            }
            else {
                btn.setTextFill(Color.WHITE);
            }
            File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imageView = new ImageView(img) ;
            imageView.setFitWidth(w);
            imageView.setFitHeight(H);
            imageView.setPreserveRatio(true);
            gridpane.add(imageView , 15, j );
            gridpane.add(btn, 15, j);

            i++;

        }
        for (int j = 14; j > 0; j--) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setStyle("-fx-background-color:transparent");
            btn.setOnAction(e -> Action(e));

            if(p.getPlateau()[i].getColor()=="White")
            {
                btn.setTextFill(Color.BLACK);
            }
            else {
                btn.setTextFill(Color.WHITE);
            }
            File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imageView = new ImageView(img) ;
            imageView.setFitWidth(w);
            imageView.setFitHeight(H);
            imageView.setPreserveRatio(true);
            gridpane.add(imageView , j, 10 );
            gridpane.add(btn, j, 10);

            i++;
        }
        for (int j = 9; j > 1; j--) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setStyle("-fx-background-color:transparent");
            btn.setOnAction(e -> Action(e));
            if(p.getPlateau()[i].getColor()=="White")
            {
                btn.setTextFill(Color.BLACK);
            }
            else {
                btn.setTextFill(Color.WHITE);
            }
            File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imageView = new ImageView(img) ;
            imageView.setFitWidth(w);
            imageView.setFitHeight(H);
            imageView.setPreserveRatio(true);
            gridpane.add(imageView , 1, j );
            gridpane.add(btn, 1, j);

            i++;
        }
        for (int j = 2; j < 14; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setStyle("-fx-background-color:transparent");
            btn.setOnAction(e -> Action(e));
            if(p.getPlateau()[i].getColor()=="White")
            {
                btn.setTextFill(Color.BLACK);
            }
            else {
                btn.setTextFill(Color.WHITE);
            }
            File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imageView = new ImageView(img) ;
            imageView.setFitWidth(w);
            imageView.setFitHeight(H);
            imageView.setPreserveRatio(true);
            gridpane.add(imageView , j, 2 );
            gridpane.add(btn, j, 2);

            i++;
        }
        for (int j = 3; j < 9; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setStyle("-fx-background-color:transparent");
            btn.setOnAction(e -> Action(e));
            if(p.getPlateau()[i].getColor()=="White")
            {
                btn.setTextFill(Color.BLACK);
            }
            else {
                btn.setTextFill(Color.WHITE);
            }
            File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imageView = new ImageView(img) ;
            imageView.setFitWidth(w);
            imageView.setFitHeight(H);
            imageView.setPreserveRatio(true);
            gridpane.add(imageView , 13, j );
            gridpane.add(btn, 13, j);

            i++;
        }
        for (int j = 12; j > 2; j--) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setStyle("-fx-background-color:transparent");
            btn.setOnAction(e -> Action(e));
            if(p.getPlateau()[i].getColor()=="White")
            {
                btn.setTextFill(Color.BLACK);
            }
            else {
                btn.setTextFill(Color.WHITE);
            }
            File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imageView = new ImageView(img) ;
            imageView.setFitWidth(w);
            imageView.setFitHeight(H);
            imageView.setPreserveRatio(true);
            gridpane.add(imageView , j, 8 );
            gridpane.add(btn, j, 8);

            i++;
        }
        for (int j = 7; j > 3; j--) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setStyle("-fx-background-color:transparent");
            btn.setOnAction(e -> Action(e));
            if(p.getPlateau()[i].getColor()=="White")
            {
                btn.setTextFill(Color.BLACK);
            }
            else {
                btn.setTextFill(Color.WHITE);
            }
            File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imageView = new ImageView(img) ;
            imageView.setFitWidth(w);
            imageView.setFitHeight(H);
            imageView.setPreserveRatio(true);
            gridpane.add(imageView , 3, j );
            gridpane.add(btn, 3, j);

            i++;
        }
        for (int j = 4; j < 12; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setStyle("-fx-background-color:transparent");
            btn.setOnAction(e -> Action(e));
            if(p.getPlateau()[i].getColor()=="White")
            {
                btn.setTextFill(Color.BLACK);
            }
            else {
                btn.setTextFill(Color.WHITE);
            }
            File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imageView = new ImageView(img) ;
            imageView.setFitWidth(w);
            imageView.setFitHeight(H);
            imageView.setPreserveRatio(true);
            gridpane.add(imageView , j, 4 );
            gridpane.add(btn, j, 4);

            i++;
        }
        for (int j = 5; j < 8; j++) {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setStyle("-fx-background-color:transparent");
            btn.setOnAction(e -> Action(e));
            if(p.getPlateau()[i].getColor()=="White")
            {
                btn.setTextFill(Color.BLACK);
            }
            else {
                btn.setTextFill(Color.WHITE);
            }
            File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imageView = new ImageView(img) ;
            imageView.setFitWidth(w);
            imageView.setFitHeight(H);
            imageView.setPreserveRatio(true);
            gridpane.add(imageView , 11, j );
            gridpane.add(btn, 11, j);

            i++;
        }
        for(int j=10;j>4;j--)
        {
            Button btn = new Button(Integer.toString(i));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setStyle("-fx-background-color:transparent");
            btn.setOnAction(e -> Action(e));
            if(p.getPlateau()[i].getColor()=="White")
            {
                btn.setTextFill(Color.BLACK);
            }
            else {
                btn.setTextFill(Color.WHITE);
            }
            File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
            Image img =new Image(file1.toURI().toString()) ;
            ImageView imageView = new ImageView(img) ;
            imageView.setFitWidth(w);
            imageView.setFitHeight(H);
            imageView.setPreserveRatio(true);
            gridpane.add(imageView , j, 7 );
            gridpane.add(btn, j, 7);

            i++;
        }

        Button btn = new Button(Integer.toString(i));
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setMaxHeight(Double.MAX_VALUE);
        btn.setStyle("-fx-background-color:transparent");
        btn.setOnAction(e -> Action(e));
        //btn.setTextFill(Color.WHITE);
        if(p.getPlateau()[i].getColor()=="White")
        {
            btn.setTextFill(Color.BLACK);
        }
        else {
            btn.setTextFill(Color.WHITE);
        }
        File file1 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
        Image img =new Image(file1.toURI().toString()) ;
        ImageView imageView = new ImageView(img) ;
        imageView.setFitWidth(w);
        imageView.setFitHeight(H);
        imageView.setPreserveRatio(true);
        gridpane.add(imageView , 5, 6 );
        gridpane.add(btn, 5, 6);

        i++;
        Button btn1 = new Button(Integer.toString(i));
        btn1.setMaxWidth(Double.MAX_VALUE);
        btn1.setMaxHeight(Double.MAX_VALUE);
        btn1.setStyle("-fx-background-color:transparent");
        btn1.setOnAction(e -> Action(e));
        //btn.setTextFill(Color.WHITE);
        if(p.getPlateau()[i].getColor()=="White")
        {
            btn1.setTextFill(Color.BLACK);
        }
        else {
            btn1.setTextFill(Color.WHITE);
        }
        File file12 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
        Image img22 =new Image(file12.toURI().toString()) ;
        ImageView imageView2 = new ImageView(img22) ;
        imageView2.setFitWidth(w);
        imageView2.setFitHeight(H);
        imageView2.setPreserveRatio(true);
        gridpane.add(imageView2 , 6, 6 );
        gridpane.add(btn1, 6, 6);

        i++;
       /* Button btn1 = new Button(Integer.toString(i));
        //  Button btn = new Button(Integer.toString(i));
        btn1.setMaxWidth(Double.MAX_VALUE);
        btn1.setMaxHeight(Double.MAX_VALUE);
        btn1.setStyle("-fx-background-color:transparent");
        btn1.setOnAction(e -> Action(e));
        //btn.setStyle("-fx-background-color :" + Plateau[i].getColor());
        //gridpane.add(btn1, 7, 6);
        File file2 = new File("src/main/resources/Img/test" + ".png") ;
        Image img122 =new Image(file2.toURI().toString()) ;
        ImageView imageV = new ImageView(img122) ;
        imageV.setFitWidth(w);
        imageV.setFitHeight(H);
        imageV.setPreserveRatio(true);
        gridpane.add(imageV , 7, 6 );
        gridpane.add(btn1, 7, 6);
        //imgv.setPreserveRatio(true);
      /*  gridpane.add(imageView , 6, 6 );
        gridpane.add(btn, 6, 6);*/

        //bk.setPosition();
        //System.out.println("SS :"+bk.get());
        //i++;*/
        Button btn12 = new Button(Integer.toString(i));
        btn12.setMaxWidth(Double.MAX_VALUE);
        btn12.setMaxHeight(Double.MAX_VALUE);
        btn12.setStyle("-fx-background-color:transparent");
        btn12.setOnAction(e -> Action(e));
        //btn.setTextFill(Color.WHITE);
        if(p.getPlateau()[i].getColor()=="White")
        {
            btn12.setTextFill(Color.BLACK);
        }
        else {
            btn12.setTextFill(Color.WHITE);
        }
        File file122 = new File("src/main/resources/Cases/Case" +p.getPlateau()[i].getColor()+ ".png") ;
        Image img222 =new Image(file122.toURI().toString()) ;
        ImageView imageView22 = new ImageView(img222) ;
        imageView22.setFitWidth(w);
        imageView22.setFitHeight(H);
        imageView22.setPreserveRatio(true);
        gridpane.add(imageView22 , 7, 6 );
        gridpane.add(btn12, 7, 6);

        i++;
       // System.out.println("sssssssssssssssss");
        gridpane.setHgap(2);
        gridpane.setVgap(2);
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
            File file = new File("src/main/resources/Img/play.PNG") ;
            //File file1 = new File("src/main/resources/Img/inverted-dice-" + nb2 + ".png") ;
            ImageView i=new ImageView()  ;
            i.setImage(new Image(file.toURI().toString()));
            Start.setGraphic(i);
            file = new File("src/main/resources/Img/quit.PNG") ;
            ImageView i2=new ImageView()  ;
            i2.setImage(new Image(file.toURI().toString()));
            quit.setGraphic(i2);
      // Partie Partie = new Partie(j);
        this.p = AceuillController.pAcceuil ;
           // this.propsP=Partie ;
        this.num_case_actuel=AceuillController.pAcceuil.getNum_case_act();
        Case Plateau[] =(AceuillController.pAcceuil).getPlateau();
        CreePlateau(Plateau);
        Lancer_De.setDisable(false);
        //openNewWindow();
           // openNewwindowImage();
        //Info.setText("Som" + De.Som());
       // System.out.println("Som" + De.Som());

    }

    @FXML
    void quitter()
    {
        System.out.println("quitter le jeux");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("Quitter.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            Scene sc = new Scene(root1) ;
            sc.setFill(Color.TRANSPARENT);
            stage.setScene(sc);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }


    }



}
