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
            if(maison.living.lightState==true)
            {
                maison.living.switchLight(false);
                maison.update();
                System.out.println("Livin1!!!!!!!!!!!11");

            }
        }
        else if(reponse==2)
        {
            if(maison.kit.lightState==true)
            { maison.kit.switchLight(false);
                maison.update();
                
            }
        }
        else if (reponse==3)
        {
            System.out.println("!kit!!!!!!!!!!!!");
            System.out.println("");

            if(maison.bath.lightState==true)
            {
                maison.bath.switchLight(false);
                System.out.println("!Bath!!!!!!!!!!!!!");
                maison.update();
            }
        }
        else
        {
            if(maison.bed.lightState==true)
            {
                maison.bed.switchLight(false);
                System.out.println("!Bedroom!!!!!!!!!!!!!");

                maison.update();
            }
        }

        

    

    }
    public void run()
    {
        Scanner scan=new Scanner(System.in);
        while (true)
        {
            System.out.println("What to you want to do?");
            System.out.println("1-Eteindre la lumiere");
            System.out.println("2-Upgrade television");
            System.out.println("3- upgrade la laverie");


            
            
            int reponse =scan.nextInt();
            if (reponse==1)
            {
                Eteindre();
            }
            if (reponse==2)
            {
                player.upgrade(maison.living.TV);
            }
            if (reponse==3)
            {
                player.upgrade(maison.bath.laverie);
            }


        }
    }
}
