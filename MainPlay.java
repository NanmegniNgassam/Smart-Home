import java.util.*;
import java.util.Random;

class MainPlay 
{
    static int oldChoixKitchen=-1;
    static int oldChoixDeplacement=1;//car on suppose que le joueur est present dans le kitchen au debut de la game
    static int oldChoixBedroom=-1;
    static int oldChoixBathroom=-1;



    static Maison maison;
    static void doList(Habitant habitant,Player player)
    {
        try {java.lang.Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}//sleep pour decaler 
        
        if(habitant.location instanceof Kitchen)
        {   
            kitchenDoList(habitant,player);
        }
        else if(habitant.location instanceof Bedroom)
        {
            bedroomDoList(habitant);
        }
        else if(habitant.location instanceof Bathroom)
        {
            bathroomDoList(habitant);
        }
        else if(habitant.location instanceof LivingRoom)
        {
            livingDoList(habitant);
        }
    }
    static void kitchenDoList(Habitant habitant,Player player)
    {
        //Warning:Il faut ajouter des autres methodes pour cette chambre sinon le choix (what you want to do) est pas necessaire

        Random rand = new Random();
        System.out.println("Do you want to do?");
        System.out.println("0-to eat");
        System.out.println("1-se deplacer");
    
        int reponse = rand.nextInt(2);
        
        maison.bath.switchLight(true);

        System.out.println("Random reponse kitchen:"+reponse);
        if (reponse==0)
        {  
            if (player.money<=10){System.out.println("Il y'a plus d'argent");habitant.isAlive=false;MainPlay.Gameover();}
            else
            {
                player.money-=10;
                habitant.seNourrir();   
            }
        }
        else if(reponse==1)
        {
            doDeplacement(maison,habitant);        
        }
    }
    static void bedroomDoList(Habitant habitant)
    {
        //Warning:Il faut ajouter des autres methodes pour cette chambre sinon le choix (what you want to do) est pas necessaire
        Random rand = new Random();
        // System.out.println("Do you want to do?");
        // System.out.println("0-to sleep");
        // System.out.println("1-se deplacer");
        // int reponse = rand.nextInt(2);
        int reponse=0;
        System.out.println("Random reponse bedroom:"+reponse);
        maison.bed.switchLight(true);

        if(reponse==0)
        {
            
            habitant.faireUneSieste();
            doDeplacement(maison,habitant);//car c'est illogique que le joueur reste entrain de dormir dans la chambre
        }
        else if(reponse==1)
        {
            doDeplacement(maison,habitant);
        }
    }

    static void doDeplacement(Maison maison,Habitant habitant)
    {
        Random rand = new Random();

        // System.out.println("where you wanna go?");
        // System.out.println("0-to bedroom");
        // System.out.println("1-to kitchen");
        // System.out.println("2-to bathroom");
        // System.out.println("3-to livingroom");
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
        habitant.doDeplacement(maison, reponse);
    }
    static void bathroomDoList(Habitant habitant)
    {
        //Warning:Il faut ajouter des autres methodes pour cette chambre sinon le choix (what you want to do) est pas necessaire

        // Random rand = new Random();
        // System.out.println("Do you want to do?");
        // System.out.println("0-faire la lessive");
        // System.out.println("1-se deplacer");
        // int reponse = rand.nextInt(2);
        int reponse=0;
        System.out.println("Random reponse bethroom:"+reponse);

        maison.bath.switchLight(true);
        if(reponse==0)
        {
            habitant.faireLaLessive();
            doDeplacement(maison,habitant);//car c'est illogique que le joueur reste entrain de faire la lessive
        }
        else if(reponse==1)
        {
            doDeplacement(maison,habitant);
        }
    }

    static void livingDoList(Habitant habitant)
    {
        Random rand = new Random();
        // System.out.println("Do you want to do?");
        // System.out.println("0-faire la lessive");
        // System.out.println("1-se deplacer");
        // int reponse = rand.nextInt(2);
        int reponse=0;
        System.out.println("Random reponse bethroom:"+reponse);
        maison.living.switchLight(true);
        if(reponse==0)
        {
            habitant.allumerTelevision();
            doDeplacement(maison,habitant);//car c'est illogique que le joueur reste entrain de regarder la tele
        }
        else if(reponse==1)
        {
            doDeplacement(maison,habitant);
        }
    }

    static void Gameover()
    {
        System.out.println("GameOverBastard!");
        System.exit(0);

    }
    static private Habitant Gameinit(Player player)
    {
            maison=new Maison();
            Habitant habitant=new Habitant("Saad",65,90,maison.kit,0);
            
            SchedulerThread threadSched=new SchedulerThread(habitant);
            EtatThread threadEtat=new EtatThread(habitant,player);
            PlayerOrders playerorders=new PlayerOrders(player, maison, habitant);

    
            threadSched.start();
            threadEtat.start();
            playerorders.start();
            return habitant;
    }
    public static void main(String[] args)
    {
        System.out.println("Do you want to start the game?");
        Scanner sc= new Scanner(System.in); 

        int rep= sc.nextInt();
        if (rep==0)System.out.println("Bye");
        else
        {
            Player player=new Player(0,70);
            Habitant habitant;
            habitant=Gameinit(player);

            while(habitant.isAlive)
            {
                doList(habitant,player);
            }
        //etc we should put these question as a function

        }
        sc.close();

    }    
}
