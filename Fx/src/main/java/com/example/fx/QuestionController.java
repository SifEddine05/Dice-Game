package com.example.fx;

import Classes.Case;
import Classes.CaseDefinition;
import Classes.CaseImage;
import Classes.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

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
    private HBox hbox ;
    private Boolean Tst = false ;


    // HelloController hello = new HelloController();
   private Partie p ;
   private String Reponse ;
   private int cpt ;

    @FXML
    void Submit(ActionEvent event) {
        int cs = p.getNum_case_act();
        Case plateau[] = p.getPlateau();
        HelloController.setTest(false);

        //System.out.println("True Or false : "+sug1.isSelected());
        if(Tst)
        {
            String rep="" ;
            TextField texts[] = new TextField[Reponse.length()];
            hbox.getChildren().toArray(texts) ;
           // System.out.println("SS"+texts[1].getText());
           //= ((TextField) new hbox.getChildren().)
            for(int i=0 ; i<texts.length ; i++)
            {
                rep = rep.concat(texts[i].getText());
            }
           rep =  rep.toUpperCase() ;
            if(Reponse.equals(rep))
            {
              // System.out.println("True");
                HelloController.setTest(true);
            }
            else {
                //System.out.println("false");
               ((CaseDefinition) plateau[cs]).SetLose();
                HelloController.setTest(false);
            }
            Stage stg = (Stage) Sub.getScene().getWindow();
            stg.close();
        }else {
            Aswr.setVisible(true);
        }



    }
    public void genererQuestion() {
        BufferedReader file = p.getfile();
        cpt=0;
       // Tst=true ;
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
            NumQues.setText("Definition " + tok.nextToken());
            // System.out.println("le numero de la question est :" + tok.nextToken());
            Question.setText("La definition est :" + tok.nextToken());
            // System.out.println("la question est :" + tok.nextToken());
            // for (int i = 1; i < 5; i++) {


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
        for (int i=0 ; i<Reponse.length() ; i++)
        {
            TextField text = new TextField() ;
            text.setId("char"+i);
            int max=0 ;

            text.textProperty().addListener((observable ,oldValu , newValue)->{
                if(newValue.length()>max)
                {
                    text.setDisable(true);
                    cpt++;
                   // Tst = true ;
                }
                if(newValue.length()==0)
                {
                    cpt--;
                }
                if(cpt==Reponse.length())
                {
                    Tst =true ;
                    Aswr.setVisible(false);
                }
            });

            hbox.getChildren().add(text);
        }
    }
}