class LivingRoom extends Room
{
    protected Objet TV;
    protected Objet baignoire;
    // nameOfRoom="Living Room";
    
    // super.nameOfRoom="LivingRoom" ;
    LivingRoom()
    {
        System.out.println("i am here");
        nameOfRoom="LivingRoom";
        TV=new Television();

    }


}