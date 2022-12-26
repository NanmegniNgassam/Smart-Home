class EtatThread extends Thread
{   
    Habitant habitant;
    Player player;
    EtatThread(Habitant habitant,Player player)
    {
        this.habitant=habitant;
        this.player=player;
    }
    public void run()//chaque 5 secondes les etats sont afficher
    {
        try{sleep(5000);}catch (InterruptedException e) {e.printStackTrace();}
        while(habitant.isAlive)
        {
            System.out.println("Location:"+habitant.location.nameOfRoom);
            System.out.println("L'etat de famine:"+habitant.famine);
            // System.out.println("Sold:"+habitant.money);
            System.out.println("electricity:"+habitant.electricity);
            System.out.println("Money:"+player.money);


            // System.out.println(":"+habitant.money);


            try{sleep(5000);}catch (InterruptedException e) {e.printStackTrace();}

        }
    }
}
