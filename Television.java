// package MaisonPack.Equipement;

public class Television  extends Objet
{
    public Television()
    {
        level=0;
        Name="Machine Laver";
        priceToUpgrade=10;
        electricityUse=5;
    }    


    @Override
    public void upgrade() 
    {
        if (level!=5)
        {
            level+=1;
            electricityUse--;
            System.out.println("Television upgraded");
        }        
    }    
}
