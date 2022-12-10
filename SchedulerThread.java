class SchedulerThread extends Thread
{   
    Joueur player;
    SchedulerThread(Joueur player)
    {
        this.player=player;
    }
    public void run()
    {
        while(player.isAlive)//chaque 2 secondes j'ajoute 1 a la famine
        {
            // System.out.println("thread is running...");
            try 
            {
                sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.famine++;
            if (player.famine>100){System.out.println("il est morts");player.isAlive=false;MainPlay.Gameover();}
        }   
    }
}
