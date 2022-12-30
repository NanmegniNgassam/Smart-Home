package model;

public class GameManager 
{
	private Home m_maison;
	private Pnj m_habitant;
	private Weather m_meteo;
	private Room m_location;
	
	
	public Room getLocation()
	{
		return this.m_location;
	}
	
	public void setRoom(Room destination)
	{
		this.m_location = destination;
	}
	
	GameManager(Home maison, Pnj habitant, Weather meteo)
	{
		this.m_maison = maison;
		this.m_habitant = habitant;
		this.m_meteo = meteo;
	}
	
	public double generateBill()
	{
		double amount = 0;
		return amount;
	}
	
	
}
