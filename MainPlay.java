import java.util.*;
import java.util.Random;

class MainPlay 
{
    static int oldChoixKitchen=-1;
    static int oldChoixDeplacement=1;//car on suposse que le joueur est present dans le kitchen au debut de la game
    static int oldChoixBedroom=-1;
    static int oldChoixBathroom=-1;



    static Maison maison;
    static void doList(Habitant player)
    {
        try {java.lang.Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}//sleep pour decaler 
        
        if(player.location instanceof Kitchen)
        {   
            kitchenDoList(player);
        }
        else if(player.location instanceof Bedroom)
        {
            bedroomDoList(player);
        }
        else if(player.location instanceof Bathroom)
        {
            bathroomDoList(player);
        }
        else if(player.location instanceof LivingRoom)
        {
            livingDoList(player);
        }
    }
    static void kitchenDoList(Habitant player)
    {
        //Warning:Il faut ajouter des autres methodes pour cette chambre sinon le choix (what you want to do) est pas necessaire

        Random rand = new Random();
        System.out.println("Do you want to do?");
        System.out.println("0-to eat");
        System.out.println("1-se deplacer");
    
        int reponse = rand.nextInt(2);

        System.out.println("Random reponse kitchen:"+reponse);
        if (reponse==0)
        {
            player.seNourrir();
        }
        else if(reponse==1)
        {
            doDeplacement(maison,player);        
        }
    }
    static void bedroomDoList(Habitant player)
    {
        //Warning:Il faut ajouter des autres methodes pour cette chambre sinon le choix (what you want to do) est pas necessaire
        Random rand = new Random();
        System.out.println("Do you want to do?");
        System.out.println("0-to sleep");
        System.out.println("1-se deplacer");
        int reponse = rand.nextInt(2);
        System.out.println("Random reponse bedroom:"+reponse);

        if(reponse==0)
        {
            
            player.faireUneSieste();
            doDeplacement(maison,player);//car c'est illogique que le joueur reste entrain de dormir dans la chambre
        }
        else if(reponse==1)
        {
            doDeplacement(maison,player);
        }
    }

    static void doDeplacement(Maison maison,Habitant player)
    {
        Random rand = new Random();

        System.out.println("where you wanna go?");
        System.out.println("0-to bedroom");
        System.out.println("1-to kitchen");
        System.out.println("2-to bathroom");
        System.out.println("3-to livingroom");
        // int reponse=sc3.nextInt();
        int reponse = rand.nextInt(4);
        //{
        //pour eviter que le joueur par exemple soit dans la chambre x et il se deplace encore une fois dans x
        while(reponse==oldChoixDeplacement)
        {
            System.out.println("Youpii");
            reponse=rand.nextInt(4);
        }
        //}
        oldChoixDeplacement=reponse;
        System.out.println("Random reponse123:"+reponse);
        player.doDeplacement(maison, reponse);
    }
    static void bathroomDoList(Habitant player)
    {
        //Warning:Il faut ajouter des autres methodes pour cette chambre sinon le choix (what you want to do) est pas necessaire

        Random rand = new Random();
        System.out.println("Do you want to do?");
        System.out.println("0-faire la lessive");
        System.out.println("1-se deplacer");
        int reponse = rand.nextInt(2);
        System.out.println("Random reponse bethroom:"+reponse);

        if(reponse==0)
        {
            player.faireLaLessive();
            doDeplacement(maison,player);//car c'est illogique que le joueur reste entrain de faire la lessive
        }
        else if(reponse==1)
        {
            doDeplacement(maison,player);
        }
    }

    static void livingDoList(Habitant player)
    {
        Random rand = new Random();
        System.out.println("Do you want to do?");
        System.out.println("0-faire la lessive");
        System.out.println("1-se deplacer");
        int reponse = rand.nextInt(2);
        System.out.println("Random reponse bethroom:"+reponse);

        if(reponse==0)
        {
            player.allumerTelevision();
            doDeplacement(maison,player);//car c'est illogique que le joueur reste entrain de regarder la tele
        }
        else if(reponse==1)
        {
            doDeplacement(maison,player);
        }
    }

    static void Gameover()
    {
        System.out.println("GameOverBastard!");
        System.exit(0);

    }
    static private Habitant Gameinit()
    {
            maison=new Maison();
            Habitant player=new Habitant("Saad",65,90,maison.kit,0,30);
            
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
            Habitant player;
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
