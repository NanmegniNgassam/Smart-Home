import java.util.*;
import java.util.Random;

class MainPlay 
{
    static Maison maison;
    static void doList(Joueur player)
    {
        try {java.lang.Thread.sleep(800);} catch (InterruptedException e) {e.printStackTrace();}//sleep pour decaler 
        
        if(player.location instanceof Kitchen)
        {   
            kitchenDoList(player);
        }
        else if(player.location instanceof Bedroom)
        {
            bedroomDoList(player);
        }
    }
    static void doDeplacement(Joueur player)
    {
            // Scanner sc3= new Scanner(System.in); 
            Random rand = new Random();

            System.out.println("where you wanna go?");
            System.out.println("0-to bedroom");
            System.out.println("1-to kitchen");
            System.out.println("2-to bathroom");
            System.out.println("3-to livingroom");
            // int reponse=sc3.nextInt();
            int reponse = rand.nextInt(4);
            if (reponse==0)
            {
                System.out.println("le joueur se deplace au bedroom...");
                try 
                {
                    java.lang.Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                // System.out.println(maison.bed.nameOfRoom);
                player.location=maison.bed;
            }
            else if(reponse==1)
            {   
                System.out.println("le joueur se deplace au kitchen...");
                try 
                {
                    java.lang.Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // System.out.println(maison.bed.nameOfRoom);
                player.location=maison.kit;
            }
    }
    static void kitchenDoList(Joueur player)
    {
        Random rand = new Random();
        // Scanner sc2= new Scanner(System.in); 
        System.out.println("Do you want to do?");
        System.out.println("0-to eat");
        System.out.println("1-se deplacer");

        // System.out.println("0-to sleep");
        // int reponse=sc2.nextInt();
        int reponse = rand.nextInt(2);
        System.out.println("Random reponse:"+reponse);

        if (reponse==0)
        {
            if (player.money<10){System.out.println("Il y'a plus d'argent");player.isAlive=false;Gameover();}
            else
            {
                player.money-=10;
                System.out.println("Sold -10...");
                if (player.famine<10)player.famine=0;//to avoid a negative value for famine
                else{player.famine-=10;}
                System.out.println("Yummy yummy yummy deliciousss!");
                try 
                {
                    java.lang.Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(reponse==1)
        {
            
            doDeplacement(player);
        }
    }
    static void bedroomDoList(Joueur player)
    {
        // Scanner sc= new Scanner(System.in); 
        Random rand = new Random();

        System.out.println("Do you want to do?");
        System.out.println("0-to sleep");
        System.out.println("1-se deplacer");
        // int reponse=sc.nextInt();
        int reponse = rand.nextInt(2);


        if(reponse==0)
        {
            System.out.println("how many hours you want so sleep");
            for (int cptH=rand.nextInt(10);cptH!=0;cptH--)//i take the input +for :)
            {
                try 
                {
                    java.lang.Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("there is "+cptH+" hours left zzz....");
                if(player.famine>100){Gameover();}
                player.famine++;
                if(player.famine>100){Gameover();}

            }
        }
        else if(reponse==1)
        {
            doDeplacement(player);
        }
    }
    static void Gameover()
    {
        System.out.println("GameOverBastard!");
        System.exit(0);

    }
    static private Joueur Gameinit()
    {
        
            maison=new Maison();
            Joueur player=new Joueur("Saad",85,90,maison.kit,0,30);
            
            SchedulerThread threadSched=new SchedulerThread(player);
            EtatThread threadEtat=new EtatThread(player);
    
            threadSched.start();
            threadEtat.start();
            return player;
    }
    public static void main(String[] args)
    {
        System.out.println("Do you want to start the game?");
        Scanner sc= new Scanner(System.in); 

        int rep= sc.nextInt();
        if (rep==0)System.out.println("Bye");
        else
        {
            Joueur player;
            player=Gameinit();
            while(player.isAlive)
            {
                doList(player);
            }
                
        //etc we should put these question as a function

        }
        
        sc.close();

    }    
}
