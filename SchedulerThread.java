class SchedulerThread extends Thread
{   
    Habitant habitant;
    Maison maison;
    SchedulerThread(Habitant habitant,Maison maison)
    {
        this.habitant=habitant;
        this.maison=maison;
    }
    public void run()
    {
        while(habitant.isAlive)//chaque 2 secondes j'ajoute 1 a la famine
        {
            // System.out.println("thread is running...");
            try 
            {
                sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            habitant.famine++;
            habitant.electricity=habitant.electricity-1-(Room.nbOfturnedOnLights)*3;//je soustraire plus d'electricity quand il y'a 
            
            
            if (habitant.famine>100){System.out.println("il est morts de faims");habitant.isAlive=false;MainPlay.Gameover();}
            if (habitant.electricity<0){System.out.println("Plus d'electricity");habitant.isAlive=false;MainPlay.Gameover();}
            maison.update();
        }   
    }
}
