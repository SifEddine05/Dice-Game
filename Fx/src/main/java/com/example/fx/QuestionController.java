package com.example.fx;

import Classes.Case;
import Classes.CaseDefinition;
import Classes.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class QuestionController {
    /*public QuestionController(Partie p , String Reponse)
    {
        this.p=p ;
        this.Reponse = Reponse  ;
    }*/

    public void setP(Partie par) {
        this.p = par;
    }
    public void setReponse(String Rep){
       this.Reponse=Rep ;
    }
    @FXML
    private Label Aswr;

    @FXML
    private Label NumQues;

    @FXML
    private Label Question;

    @FXML
    private Button Sub;

    @FXML
    private RadioButton sug1;

    @FXML
    private RadioButton sug2;

    @FXML
    private RadioButton sug3;

    @FXML
    private RadioButton sug4;
    ToggleGroup group = new ToggleGroup() ;

    // HelloController hello = new HelloController();
   private Partie p ;
   private String Reponse ;

    @FXML
    void Submit(ActionEvent event) {
        int cs = p.getNum_case_act();
        Case plateau[] = p.getPlateau();
        HelloController.setTest(false);
        //System.out.println("True Or false : "+sug1.isSelected());
        if (sug1.isSelected()) {
            /*String rep = Reponse ;
            String sug = sug1.getText() ;
            System.out.println("Reponse :"+String.valueOf(Reponse)+" ,Sug "+String.valueOf(sug1.getText()) );*/
            if (Reponse.equals(sug1.getText())) {
               // System.out.println("les memes");
                Aswr.setText("Votre Reponse est Juste");
                HelloController.setTest(true);
            } else {
               // System.out.println(" n'est pasn les les memes");
                Aswr.setText("Votre Reponse est Fausse");
                // System.out.println("CSCSCS"+cs);
                ((CaseDefinition) plateau[cs]).SetLose();

            }
            Aswr.setVisible(true);
            Stage stg = (Stage) Sub.getScene().getWindow();
            stg.close();

        } else if (sug2.isSelected()) {
            if (!Reponse.equals(sug2.getText())) {
                Aswr.setText("Votre Reponse est Fausse");
                ((CaseDefinition) plateau[cs]).SetLose();
            } else {
                Aswr.setText("Votre Reponse est Juste");
                HelloController.setTest(true);
            }
            Aswr.setVisible(true);
            Stage stg = (Stage) Sub.getScene().getWindow();
            stg.close();

        } else if (sug3.isSelected()) {
            if (!Reponse.equals(sug3.getText())) {
                Aswr.setText("Votre Reponse est Fausse");
                ((CaseDefinition) plateau[cs]).SetLose();
            } else {
                Aswr.setText("Votre Reponse est Juste");
                HelloController.setTest(true);
            }
            Stage stg = (Stage) Sub.getScene().getWindow();
            stg.close();
            Aswr.setVisible(true);
        } else if (sug4.isSelected()) {
            if (!Reponse.equals(sug4.getText())) {
                Aswr.setText("Votre Reponse est Fausse");
                ((CaseDefinition) plateau[cs]).SetLose();
            } else {
                Aswr.setText("Votre Reponse est Juste");
                HelloController.setTest(true);

            }
            Aswr.setVisible(true);
            Stage stg = (Stage) Sub.getScene().getWindow();
            stg.close();
        } else {
            Aswr.setText("choissez  une reponse s'il vous plait ");
            Aswr.setVisible(true);
        }
        /*try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
            System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        }*/



    }
    public void genererQuestion() {
        BufferedReader file = p.getfile();
        sug1.setToggleGroup(group);
        sug2.setToggleGroup(group);
        sug3.setToggleGroup(group);
        sug4.setToggleGroup(group);
       // openNewWindow();
        //System.out.println("GenereQuestion");
        StringTokenizer tok = null;
        // openNewWindow();
        try {
            // f = new BufferedReader(new FileReader("definition.txt"));
            String h = file.readLine();
            //System.out.println(h);
            tok = new StringTokenizer(h, ",");
           // System.out.println("SSSSSSs:" + tok.nextToken());
            NumQues.setText("Question " + tok.nextToken());
            // System.out.println("le numero de la question est :" + tok.nextToken());
            Question.setText("la question est :" + tok.nextToken());
            // System.out.println("la question est :" + tok.nextToken());
            // for (int i = 1; i < 5; i++) {
            sug1.setText(tok.nextToken());
            sug2.setText(tok.nextToken());
            sug3.setText(tok.nextToken());
            sug4.setText(tok.nextToken());


            //System.out.println("la suggestion " + i + " est " + tok.nextToken());

        } catch (IOException e) {
            System.out.println("il ya une exception ");
        } finally {
            // f.close() ;
        }
       /* Scanner sc = new Scanner(System.in);
        System.out.println("veuillez saisir le numero de votre reponse ");
        int rep = sc.nextInt();*/
        //assert tok != null;
        this.Reponse = tok.nextToken();
      /*  if (Integer.parseInt(tok.nextToken()) == rep) {
            System.out.println("la reponse est juste ");
        } else {
            System.out.println("la reponse est fausse ");
            SetLose();
        }*/
    }
}