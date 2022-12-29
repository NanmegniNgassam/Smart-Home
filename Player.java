
public class Player 
{
    String Name;
    int Level;
    protected int money;

    Player(int Level,int money)
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
    };

}
