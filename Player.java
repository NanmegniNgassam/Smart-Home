// package Playerpack;
// import MaisonPack.*;
// import MaisonPack.Equipement.*;
public  class Player 
{
    String Name;
    int Level;
    public int money;
    int paiementFacture;
    int Facturefrequence=15;
    GUI gui;

    Player(int Level,int money)
    {
        this.Level=Level;
        this.money=money;
        this.paiementFacture=100;
    }
    void setGui(GUI gui)
    {
        this.gui=gui;
    }
    void interagiraveclumiere(Room m)
    {
        m.switchLight(false);
    }

    void upgrade (Objet obj)
    {
        obj.upgrade();
        if(this.money-(10+obj.level-10)<0){System.out.println("Pas d'argent pour l'update!");MainPlay.Gameover();}
        else{this.money-=(10+obj.level*10);};
        gui.maison.update();
        // obj.electricityUse=-2;
    };
    public void payerFacture()
    {
        if(this.money-paiementFacture <0){System.out.println("pas d'argent pour payer la facture");MainPlay.Gameover();}
        else
        {
            this.money-=paiementFacture;
            this.Facturefrequence=15;
            gui.setTempsFacture(this.Facturefrequence);
        }
        
    };


}
