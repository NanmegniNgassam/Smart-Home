// package MaisonPack;
// import Playerpack.*;
public class Maison    
{

    public Kitchen kit;
    public Bedroom bed;
    public Bathroom bath;
    public LivingRoom living;
    public GUI gui;
    Habitant habitant;
    Player player;


    public Maison(Player player,GUI gui)
    {
        kit=new Kitchen(gui);
        bed=new Bedroom();
        bath=new Bathroom(gui);
        living=new LivingRoom(gui);
        this.gui=gui;
        this.player=player;
    }
    public void setHabitant(Habitant habitant)
    {
        this.habitant=habitant;
    }

    public void update()
    {
        // System.out.println("!!!!!!!!!!!!!"+habitant.electricity);
        int elec=habitant.electricity;
        // System.out.println(elec);
        gui.setTextlectriclabel(elec);
        gui.setTextFaminelabel(habitant.famine);
        gui.setTextMoneyLabel(player.money);
        gui.setTextLampesOn(Room.nbOfturnedOnLights);
    }



}
