// package MaisonPack;
public abstract class Room 
{
    public boolean viewState;
    public boolean lightState=false;
    public String  nameOfRoom;
    public static int nbOfturnedOnLights=0;


    
    public void switchLight(Boolean onoff)
    {
        if (onoff==true)
        {
            this.lightState=true;
            nbOfturnedOnLights++;

        }
        else
        {
            this.lightState=false;
            nbOfturnedOnLights--;

        }
    }
    public void interactView(){}
    public int getBill(){return 0;}





}
