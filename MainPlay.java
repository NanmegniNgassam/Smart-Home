// package Playerpack;
// import MaisonPack.*;
import java.util.*;
import java.util.Random;

class MainPlay
{
    static int oldChoixDeplacement=1;//car on suppose que le joueur est present dans le kitchen au debut de la game
    static int forcerChoixDeplacement=-1;
    static Maison maison;


    static void doDeplacement(Maison maison,Habitant habitant)
    {
        Random rand = new Random();
        int reponse = rand.nextInt(4);

        //pour eviter que le joueur par exemple soit dans la chambre x et il se deplace encore une fois dans x
        while(reponse==oldChoixDeplacement)
        {
            System.out.println("Youpii");
            reponse=rand.nextInt(4);
        }
        //je le force de partir a un endroit specifique (par exemple si il va mourir de faim je l'envoie au kitchen)
        if(forcerChoixDeplacement!=-1){reponse=forcerChoixDeplacement;forcerChoixDeplacement=-1;}
        oldChoixDeplacement=reponse;
        habitant.doDeplacement(maison, reponse);
    }
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
        if(maison.kit.lightState==false){maison.kit.switchLight(true);}
        maison.update();
        if (player.money<=10){System.out.println("Il y'a plus d'argent");habitant.isAlive=false;MainPlay.Gameover();}
        else
        {
            player.money-=10;
            habitant.seNourrir(maison);
            doDeplacement(maison,habitant);
            maison.gui.buttonKit.setEnabled(true);
        }
    }
    static void bedroomDoList(Habitant habitant)
    {

        if(maison.bed.lightState==false){maison.bed.switchLight(true);}
        maison.update();
        habitant.faireUneSieste();
        doDeplacement(maison,habitant);//car c'est illogique que le joueur reste entrain de dormir dans la chambre
        maison.gui.buttonBed.setEnabled(true);
    }

    static void bathroomDoList(Habitant habitant)
    {

        if(maison.bath.lightState==false){maison.bath.switchLight(true);}
        maison.update();
        habitant.faireLaLessive(maison);
        doDeplacement(maison,habitant);//car c'est illogique que le joueur reste entrain de faire la lessive
        maison.gui.buttonBath.setEnabled(true);
    }

    static void livingDoList(Habitant habitant)
    {
        if(maison.living.lightState==false){maison.living.switchLight(true);}
        maison.update();
        habitant.allumerTelevision(maison);
        doDeplacement(maison,habitant);//car c'est illogique que le joueur reste entrain de regarder la tele
        maison.gui.buttonLiv.setEnabled(true);
    }

    static void Gameover()
    {
        System.out.println("GameOverBastard!");
        System.exit(0);

    }
    static public void Gameinit()
    {
        Player player=new Player(0,150);

        GUI gui=new GUI();
        gui.createAndShowGUI();
        player.setGui(gui);

        Habitant habitant;
        maison=new Maison(player,gui);
        gui.setMaison(maison);
        habitant=new Habitant("Saad",65,90,maison.kit,0);
        habitant.setGUI(gui);
        maison.setHabitant(habitant);
        maison.update();

        SchedulerThread threadSched=new SchedulerThread(habitant,maison);
        EtatThread threadEtat=new EtatThread(habitant,player);
        PlayerOrders playerorders=new PlayerOrders(player, maison, habitant);

        // maison.gui.setlocation("Kitchen");

        threadSched.start();
        threadEtat.start();
        playerorders.start();
        while(habitant.isAlive)
        {
            doList(habitant,player);
        }
        // return habitant;
    }


    // Gamestart
    public static void main(String[] args)
    {
        System.out.println("Do you want to start the game?");
        // Scanner sc= new Scanner(System.in);
        GuiStartGame.createAndShowGUI();
        // int rep= sc.nextInt();
        // if (rep==0)System.out.println("Bye");
        // else
        // {
            // Habitant habitant;
        // Gameinit();


        //etc we should put these question as a function

        // }
        // sc.close();

    }
}
