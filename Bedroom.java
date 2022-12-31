// package MaisonPack;
// import MaisonPack.Equipement.*;

public class Bedroom extends Room
{
    protected Objet lit;
    protected GUI gui;

    Bedroom(GUI gui)
    {
        nameOfRoom="Bedroom";
        this.gui=gui;
    }
    @Override
    public void switchLight(Boolean onoff) 
    {
        // TODO Auto-generated method stub
        super.switchLight(onoff);
        if (onoff==true) 
        {   gui.BedroomPanel.setImage("images/Bedroom.jpg");
            // KCSystem.out.println("I am here");
        }
        else
        {
            gui.BedroomPanel.setImage("images/BedroomNoLight.jpg");   
        }
    }
}