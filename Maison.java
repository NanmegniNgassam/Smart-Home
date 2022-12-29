class Maison    
{

    Kitchen kit;
    Bedroom bed;
    Bathroom bath;
    LivingRoom living;
    GUI gui;
    Habitant habitant;
    Player player;


    Maison(Player player,GUI gui)
    {
        kit=new Kitchen();
        bed=new Bedroom();
        bath=new Bathroom();
        living=new LivingRoom();
        this.gui=gui;
        this.player=player;
    }
    void setHabitant(Habitant habitant)
    {
        this.habitant=habitant;
    }

    void update()
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
