
public class Player 
{
    String Name;
    int Level;
    protected float money;

    Player(int Level,float money)
    {
        this.Level=Level;
        this.money=money;
    }

    void interagiraveclumiere(Room m)
    {
        m.switchLight(false);
    }

    void upgrade (Objet obj)
    {
        obj.upgrade();
    }

}
