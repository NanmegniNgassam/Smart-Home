import java.util.Random;

class Habitant
{
    protected String Name;
    protected int famine;
    protected int sante;
    protected Room location;
    protected int level;
    protected Boolean isAlive=true;
    protected int electricity=100;


    Habitant(String Name,int famine,int sante,Room location,int level)
    {
        this.Name=Name;
        this.famine=famine;
        this.sante=sante;
        this.level=level;
        this.location=location;
        // this.
    }

    public void seDeplacer(Room r){};
    
    public void prendreUnBain(){};
    public void allumerTelevision(Maison maison)
    {
        if (electricity<=maison.living.TV.electricityUse){System.out.println("Plus d'electricity\n");;MainPlay.Gameover();}
        else
        {
            this.electricity=this.electricity-maison.living.TV.electricityUse;
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
            for (int i=0;i<3;i++)
            {
                System.out.println("Habitant entrain de faire la lessive...");
                try{java.lang.Thread.sleep(1000);}catch(Exception e){System.out.println(e);}

            }

        }
    };
    public void allumerLeChauffage(){};
    public void payerFacture(float amount){};
    public void jouerPs4(){};
    public void seNourrir()
    {
            
            
                // this.money-=10;
                System.out.println("Sold -10...");
                if (this.famine<10)this.famine=0;//to avoid a negative value for famine
                else{this.famine-=10;}
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
        int reponse2=rand.nextInt(10);
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
            }
    }
}