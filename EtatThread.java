class EtatThread extends Thread
{   
    Joueur player;
    EtatThread(Joueur player)
    {
        this.player=player;
    }
    public void run()//chaque 5 secondes les etats sont afficher
    {
        while(player.isAlive)
        {
            System.out.println("Location:"+player.location.nameOfRoom);
            System.out.println("L'etat de famine:"+player.famine);
            System.out.println("Sold:"+player.money);
            // System.out.println(":"+player.money);


            try{sleep(5000);}catch (InterruptedException e) {e.printStackTrace();}

        }
    }
}
