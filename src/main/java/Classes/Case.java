package Classes;

abstract public class Case {
    protected String Color;
    protected int Nb_Case;
    protected int nbr_Points;
    public void afficher()
    {
        System.out.println("Color "+this.Color+" Bonus "+this.nbr_Points+" Deplacer "+this.Nb_Case);
    }
    abstract void Action(Joeur j);
}
