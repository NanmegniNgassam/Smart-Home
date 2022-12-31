// package Playerpack;
import java.util.Random;
// import MaisonPack.*;
public class Habitant
{
    public String Name;
    public int famine;
    public int sante;
    public Room location;
    public int level;
    public Boolean isAlive=true;
    public int electricity=100;
    GUI gui;



    Habitant(String Name,int famine,int sante,Room location,int level)
    {
        this.Name=Name;
        this.famine=famine;
        this.sante=sante;
        this.level=level;
        this.location=location;
        // this.
    }

    public void setGUI(GUI gui)
    {this.gui=gui;}
    
    public void prendreUnBain(){};
    public void allumerTelevision(Maison maison)
    {
        if (electricity<=maison.living.TV.electricityUse){System.out.println("Plus d'electricity\n");;MainPlay.Gameover();}
        else
        {
            this.electricity=this.electricity-maison.living.TV.electricityUse;
            maison.update();

            for (int i=0;i<3;i++)
            {
                System.out.println("Habitant entrain de regarder la television...");
                try{Thread.sleep(1000);}catch(Exception e){System.out.println(e);}
            }

        }
    };
    public void faireLaLessive(Maison maison)
    {
        System.out.println("le habitant entrain de faire la lessive\n");
        if (electricity<=maison.bath.laverie.electricityUse){System.out.println("Plus d'electricity\n");;MainPlay.Gameover();}
        else
        {
            this.electricity=this.electricity-maison.bath.laverie.electricityUse;
            maison.update();
            for (int i=0;i<3;i++)
            {
                System.out.println("Habitant entrain de faire la lessive...");
                try{java.lang.Thread.sleep(1000);}catch(Exception e){System.out.println(e);}

            }

        }
    };
    public void allumerLeChauffage(){};
    public void jouerPs4(){};
    public void seNourrir(Maison maison)
    {
            
            
                // this.money-=10;
                System.out.println("Sold -10...");
                if (this.famine<10)this.famine=0;//to avoid a negative value for famine
                else{this.famine-=10;}
                maison.update();
                System.out.println("Yummy yummy yummy deliciousss!");
                try 
                {
                    java.lang.Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            
    };
    public void faireUneSieste()
    {
        
        Random rand = new Random();
        System.out.println("how many hours you want so sleep");
        int reponse2=rand.nextInt(6);
        System.out.println("Random reponse:"+reponse2);

        for (int cptH=reponse2;cptH!=0;cptH--)//i take the input +for :)
        {
            try 
            {
                java.lang.Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("there is "+cptH+" hours left zzz....");
            if(this.famine>100){MainPlay.Gameover();}
            this.famine++;
            if(this.famine>100){MainPlay.Gameover();}

        }
    };
    public void doDeplacement(Maison maison,int reponse)
    {
      

            if (reponse==0)
            {

                System.out.println("le joueur se deplace au bedroom...");
                try 
                {
                    java.lang.Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                this.location=maison.bed;
                gui.setlocation("Bedroom");
                gui.buttonBed.setEnabled(false);
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
                this.location=maison.kit;
                gui.setlocation("Kitchen");
                gui.buttonKit.setEnabled(false);

            }
            else if(reponse==2)//bathroom
            {
                System.out.println("le joueur se deplace au bathroom...");
                try 
                {
                    java.lang.Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.location=maison.bath;
                gui.setlocation("Bathroom");
                gui.buttonBath.setEnabled(false);


            }
            else if(reponse==3)//living
            {
                System.out.println("le joueur se deplace au livingroom...");
                try 
                {
                    java.lang.Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.location=maison.living;
                gui.setlocation("LivingRoom");
                gui.buttonLiv.setEnabled(false);


            }
    }
}