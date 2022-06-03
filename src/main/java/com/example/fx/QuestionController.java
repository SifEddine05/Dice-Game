package com.example.fx;

import Classes.Case;
import Classes.CaseDefinition;
import Classes.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;
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
    private HBox hbox ;
    private Boolean Tst = false ;


    // HelloController hello = new HelloController();
   private Partie p ;
   private String Reponse ;
   private int cpt ;

   @FXML
   Button del ;
   @FXML
   void Delete(ActionEvent event)
   {
       String rep="" ;
       TextField texts[] = new TextField[Reponse.length()];
       hbox.getChildren().toArray(texts) ;
       for(int i=0 ; i<Reponse.length() ; i++)
       {
           texts[i].setText("");
           texts[i].setDisable(false);
           texts[i].setStyle("-fx-background-color:#fabf72");
       }

   }

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
        File file1 = new File("src/main/resources/Img/delete.png") ;
        ImageView img1 =new ImageView();
        img1.setImage(new Image(file1.toURI().toString()));
        del.setGraphic(img1);
       // del.setStyle("-fx-background-image:url(./src/main/resources/Img/delete.png)");
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader("src/main/resources/Definitions/definition.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        cpt=0;
       // Tst=true ;
       // openNewWindow();
        //System.out.println("GenereQuestion");
        StringTokenizer tok = null;
        // openNewWindow();
        try {
            String h ;
            int i=0 ;
            while (i<p.getLastdef())
            {
                h = file.readLine();
                i++;
            }
            // f = new BufferedReader(new FileReader("definition.txt"));
             h = file.readLine();
            p.setLastdef(p.getLastdef()+1);
            //System.out.println(h);
            tok = new StringTokenizer(h, ",");
           // System.out.println("SSSSSSs:" + tok.nextToken());
            NumQues.setText("Definition " + tok.nextToken());

            // System.out.println("le numero de la question est :" + tok.nextToken());
            Question.setText("La definition est :" + tok.nextToken());
            Question.setWrapText(true);
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
           /* Pattern pattern = Pattern.compile(".{0,1}");
            TextFormatter formatter = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
                return pattern.matcher(change.getControlNewText()).matches() ? change : null;
            });
            text.setTextFormatter(formatter);*/

            text.textProperty().addListener((observable ,oldValu , newValue)->{
                text.setDisable(false);
                if(newValue.length()>max)
                {
                   // text.setText(text.getText().substring(0));
                    text.setDisable(true);
                    //btn.setOnAction(e -> Action(e));
                    text.setOnAction(e->{
                        text.setDisable(false);
                    });
                    cpt++;
                   // Tst = true ;
                }
                if(newValue.length()==0)
                {
                    Tst=false ;
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