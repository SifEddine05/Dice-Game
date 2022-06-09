package com.example.fx;

import Classes.Case;
import Classes.CaseImage;
import Classes.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.util.StringTokenizer;

public class ImagesController {

    @FXML
    private Label NumImg;

    @FXML
    private Label Qes;

    @FXML
    private RadioButton btn1;

    @FXML
    private RadioButton btn2;

    @FXML
    private RadioButton btn3;

    @FXML
    private RadioButton btn4;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;
    @FXML
    private Button Sub ;
    @FXML
    private Button bb ;

    @FXML
    private  Label Aswr ;

    private Partie p ;
    private String Reponse ;
    ToggleGroup group = new ToggleGroup() ;


    public void setP(Partie par) {
        this.p = par;
        System.out.println("SETPPPPPPPP");
    }
    public void setReponse(String Rep){
        this.Reponse=Rep ;
    }

@FXML
void bb(ActionEvent event) {
    genererImage();
}
    @FXML
    void submit(ActionEvent event) {

        int cs = p.getNum_case_act();
        Case plateau[] = p.getPlateau();
        HelloController.setTestimg(false);
        if (btn1.isSelected()) {
            if (Reponse.equals(btn1.getId())) {
                HelloController.setTestimg(true);
            } else {
                ((CaseImage) plateau[cs]).SetLose();
            }
           // Aswr.setVisible(true);
            Stage stg = (Stage) Sub.getScene().getWindow();
            stg.close();

        } else if (btn2.isSelected()) {
            if (!Reponse.equals(btn2.getId())) {
                //Aswr.setText("Votre Reponse est Fausse");
                ((CaseImage) plateau[cs]).SetLose();
            } else {
               // Aswr.setText("Votre Reponse est Juste");
                HelloController.setTestimg(true);
            }
           // Aswr.setVisible(true);
            Stage stg = (Stage) Sub.getScene().getWindow();
            stg.close();

        } else if (btn3.isSelected()) {
            if (!Reponse.equals(btn3.getId())) {
               // Aswr.setText("Votre Reponse est Fausse");
                ((CaseImage) plateau[cs]).SetLose();
            } else {
               // Aswr.setText("Votre Reponse est Juste");
                HelloController.setTestimg(true);
            }
            Stage stg = (Stage) Sub.getScene().getWindow();
            stg.close();
           // Aswr.setVisible(true);
        } else if (btn4.isSelected()) {
            if (!Reponse.equals(btn4.getId())) {
              //  Aswr.setText("Votre Reponse est Fausse");
                ((CaseImage) plateau[cs]).SetLose();
            } else {
               // Aswr.setText("Votre Reponse est Juste");
                HelloController.setTestimg(true);

            }
            //Aswr.setVisible(true);
            Stage stg = (Stage) Sub.getScene().getWindow();
            stg.close();
        } else {
          //  Aswr.setText("choissez  une reponse s'il vous plait ");
            Aswr.setVisible(true);
        }
    }

public void genererImage() {

    BufferedReader file = null;
    try {
        file = new BufferedReader(new FileReader("src/main/resources/Images/image.txt"));
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

    btn1.setToggleGroup(group);
    btn2.setToggleGroup(group);
    btn3.setToggleGroup(group);
    btn4.setToggleGroup(group);
    // openNewWindow();
    //System.out.println("GenereQuestion");
    StringTokenizer tok = null;
    // openNewWindow();
    try {
        String h ;
        int i=0 ;
        while (i<p.getlastimg())
        {
            h = file.readLine();
            i++;
        }
        // f = new BufferedReader(new FileReader("definition.txt"));
         h = file.readLine();
        p.setLastimg(p.getlastimg()+1);
        //System.out.println(h);
        tok = new StringTokenizer(h, ",");
        // System.out.println("SSSSSSs:" + tok.nextToken());
        NumImg.setText("Image " + tok.nextToken());
       // p.setDernierImg(p.getDernierImg()+1);
        // System.out.println("le numero de la question est :" + tok.nextToken());
        Qes.setText("" + tok.nextToken());
        // System.out.println("la question est :" + tok.nextToken());
        // for (int i = 1; i < 5; i++) {
       /* sug1.setText(tok.nextToken());
        sug2.setText(tok.nextToken());
        sug3.setText(tok.nextToken());
        sug4.setText(tok.nextToken());*/


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
    String img = tok.nextToken() ; // pour le debut des images
    int n = Integer.parseInt(img) ;
    System.out.println("Le n est:"+n);
        File file1 = new File("src/main/resources/Images/Img"+n+".jpg") ;
        img1.setImage(new Image(file1.toURI().toString()));
    //System.out.println("Le n est:"+n);
    File file2 = new File("src/main/resources/Images/Img" + (n+1) + ".jpg") ;
    img2.setImage(new Image(file2.toURI().toString()));
    File file3 = new File("src/main/resources/Images/Img" + (n+2) + ".jpg") ;
    img3.setImage(new Image(file3.toURI().toString()));
    File file4 = new File("src/main/resources/Images/Img" + (n+3) + ".jpg") ;
    img4.setImage(new Image(file4.toURI().toString()));
        //img2.setImage(new Image(file1.toURI().toString()));
        //img1.

      /*  if (Integer.parseInt(tok.nextToken()) == rep) {
            System.out.println("la reponse est juste ");
        } else {
            System.out.println("la reponse est fausse ");
            SetLose();
        }*/
}
    @FXML
    public void Selected(ActionEvent event)
    {

        Aswr.setVisible(false);
    }
    @FXML
    private TextField text ;


}

