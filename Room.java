abstract class Room 
{
    protected boolean viewState;
    protected boolean lightState;
    String  nameOfRoom;
    static int nbOfturnedOnLights=0;


    
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
