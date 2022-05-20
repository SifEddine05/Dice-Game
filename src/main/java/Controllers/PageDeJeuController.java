package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import Classes.sifou;

public class PageDeJeuController {

    @FXML
    private Button color;

    @FXML
    void onclick(ActionEvent event) {
        sifou s = new sifou() ;
        s.cc(color);
    }

}
