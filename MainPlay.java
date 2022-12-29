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

        if(maison.kit.lightState==false){maison.kit.switchLight(true);}
        maison.update();

        Random rand = new Random();
        System.out.println("Do you want to do?");
        System.out.println("0-to eat");
        System.out.println("1-se deplacer");

        int reponse = rand.nextInt(2);


        System.out.println("Random reponse kitchen:"+reponse);
        if (reponse==0)
        {
            if (player.money<=10){System.out.println("Il y'a plus d'argent");habitant.isAlive=false;MainPlay.Gameover();}
            else
            {
                player.money-=10;
                habitant.seNourrir(maison);
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
        // Random rand = new Random();
        // System.out.println("Do you want to do?");
        // System.out.println("0-to sleep");
        // System.out.println("1-se deplacer");
        // int reponse = rand.nextInt(2);

        if(maison.bed.lightState==false){maison.bed.switchLight(true);}
        maison.update();

        int reponse=0;
        System.out.println("Random reponse bedroom:"+reponse);

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
        if(maison.bath.lightState==false){maison.bath.switchLight(true);}
        maison.update();

        int reponse=0;
        System.out.println("Random reponse bethroom:"+reponse);

        if(reponse==0)
        {
            habitant.faireLaLessive(maison);
            doDeplacement(maison,habitant);//car c'est illogique que le joueur reste entrain de faire la lessive
        }
        else if(reponse==1)
        {
            doDeplacement(maison,habitant);
        }
    }

    static void livingDoList(Habitant habitant)
    {
        // Random rand = new Random();
        // System.out.println("Do you want to do?");
        // System.out.println("0-faire la lessive");
        // System.out.println("1-se deplacer");
        // int reponse = rand.nextInt(2);
        if(maison.living.lightState==false){maison.living.switchLight(true);}
        maison.update();

        int reponse=0;
        System.out.println("Random reponse bethroom:"+reponse);
        if(reponse==0)
        {
            habitant.allumerTelevision(maison);
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
        
        GUI gui=new GUI();
        gui.createAndShowGUI();
        Habitant habitant;
        maison=new Maison(player,gui);
        gui.setMaison(maison);
        habitant=new Habitant("Saad",65,90,maison.kit,0);
        maison.setHabitant(habitant);
        maison.update();

        SchedulerThread threadSched=new SchedulerThread(habitant,maison);
        // System.out.println(player.money+"!!!!!!!!111");
        EtatThread threadEtat=new EtatThread(habitant,player);
        PlayerOrders playerorders=new PlayerOrders(player, maison, habitant);

        // maison.gui.setlocation("Kitchen");

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
            Player player=new Player(0,200);
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
