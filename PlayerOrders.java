import java.util.Scanner;

public class PlayerOrders extends Thread 
{
    Player player;
    Habitant habitant;
    Maison maison;

    PlayerOrders(Player player ,Maison maison ,Habitant habitant)
    {
        this.habitant=habitant;
        this.player=player;
        this.maison=maison;
    }
    public void Eteindre()
    {
        Scanner scan=new Scanner(System.in);

        System.out.println("quelle lampe tu veux eteindre?");
        System.out.println("1-lampe living room");
        System.out.println("2-lampe kitchen");
        System.out.println("3-lampe bathroom");
        System.out.println("4-lampe bedroom");
        int reponse =scan.nextInt();
        if(reponse==1)
        {
            maison.living.switchLight(false);
        }
        else if(reponse==2)
        {
            maison.kit.switchLight(false);
        }
        else if (reponse==3)
        {
            maison.bath.switchLight(false);
        }
        else
        {
            maison.bed.switchLight(false);
        }

        

    

    }
    public void run()
    {
        Scanner scan=new Scanner(System.in);
        while (true)
        {
            System.out.println("What to you want to do?");
            System.out.println("1-Eteindre la lumiere");
            
            int reponse =scan.nextInt();
            if (reponse==1)
            {
                Eteindre();
            }

        }
    }
}
