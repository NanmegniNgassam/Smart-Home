class Bathroom extends Room
{
    protected Objet laverie;
    // private Objet baignoire ;

    Bathroom()
    {
        nameOfRoom="Bathroom";
        laverie=new Laverie();
    }

}