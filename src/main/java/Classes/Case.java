package Classes;

import javafx.scene.control.Label;

import java.io.Serializable;

abstract public class Case implements Serializable {
    protected String Color;
    protected int Nb_Case;
    protected int nbr_Points;
    public void afficher()
    {
        System.out.println("Color "+this.Color+" Bonus "+this.nbr_Points+" Deplacer "+this.Nb_Case);
    }
    public String getColor()
    {
        return  this.Color ;
    }
    public abstract String Action(Joeur j );
}
