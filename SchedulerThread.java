// package Playerpack;
// import MaisonPack.*;
class SchedulerThread extends Thread
{
    Habitant habitant;
    Maison maison;
    // Integer TempsRestantPourPayerFacture;
    SchedulerThread(Habitant habitant,Maison maison)
    {
        this.habitant=habitant;
        this.maison=maison;
        // TempsRestantPourPayerFacture=maison.player.Facturefrequence;
    }
    public void run()
    {
        int i=0;
        int NextLevel=7;
        while(habitant.isAlive)//chaque 2 secondes j'ajoute 1 a la famine
        {
            try
            {
                sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            maison.player.Facturefrequence--;
            habitant.famine++;
            habitant.electricity=habitant.electricity-1-(Room.nbOfturnedOnLights)*3;//je soustraire plus d'electricity quand il y'a
            if (i==NextLevel)
            {
                maison.player.Level+=1;
                System.out.println("ConGratulation you are in a Next Level");
                i=0;
                NextLevel+=2;
                maison.player.money+=50;
                if(maison.habitant.electricity+50>100){maison.habitant.electricity=100;}
                else maison.habitant.electricity+=50;
            }

            if (habitant.famine>100){System.out.println("il est morts de faims");habitant.isAlive=false;MainPlay.Gameover();}
            if (habitant.electricity<0){System.out.println("Plus d'electricity");habitant.isAlive=false;MainPlay.Gameover();}
            if(maison.player.Facturefrequence==0){System.out.println("T'as pas payer la facture");habitant.isAlive=false;MainPlay.Gameover();}
            maison.update();
            // System.out.println("PRinttttttttt tempss"+TempsRestantPourPayerFacture);
            // System.out.println("PRinttttttttt tempss"+maison.player.Facturefrequence);

        }
    }
}
