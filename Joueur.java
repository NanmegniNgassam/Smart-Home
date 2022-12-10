class Joueur
{
    protected String Name;
    protected int famine;
    protected int sante;
    protected Room location;
    protected int level;
    protected float money;
    protected Boolean isAlive=true;

    Joueur(String Name,int famine,int sante,Room location,int level,int money)
    {
        this.Name=Name;
        this.famine=famine;
        this.sante=sante;
        this.level=level;
        this.money=money;
        this.location=location;
    }

    public void seDeplacer(Room r){};
    public void seNourrir(){};
    public void prendreUnBain(){};
    public void allumerTelevision(){};
    public void faireLaLessive(){};
    public void faireUneSieste(int dure){};
    public void allumerLeChauffage(){};
    public void payerFacture(float amount){};
    public void jouerPs4(){};




}