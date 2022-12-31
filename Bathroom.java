// package MaisonPack;
// import MaisonPack.Equipement.*;
public class Bathroom extends Room
{
    public Objet laverie;
    GUI gui;
    // private Objet baignoire ;

    Bathroom(GUI gui)
    {
        nameOfRoom="Bathroom";
        laverie=new Laverie();
        this.gui=gui;
    }
    @Override
    public void switchLight(Boolean onoff) {
        super.switchLight(onoff);
        if (onoff==true) 
        {   
            
            System.out.println("I am here");
        }
    }

}