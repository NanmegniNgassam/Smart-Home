// package MaisonPack;
// import MaisonPack.Equipement.*;

public class LivingRoom extends Room
{
    public Objet TV;
    public Objet baignoire;
    public GUI gui;
    // nameOfRoom="Living Room";
    
    // super.nameOfRoom="LivingRoom" ;
    LivingRoom(GUI gui)
    {
        System.out.println("i am here");
        nameOfRoom="LivingRoom";
        TV=new Television();
        this.gui=gui;

    }
    @Override
    public void switchLight(Boolean onoff) {
        super.switchLight(onoff);

    }


}