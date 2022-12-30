package model;

public class Home 
{
	//the different parts of the house
	private Livingroom livingroom;
	private Bedroom bedroom;
	private Bathroom bathroom;
	private Kitchen kitchen;
	
	public Room getLivingroom()
	{
		return this.livingroom;
	}
	
	public Room getBedroom()
	{
		return this.bedroom;
	}
	
	public Room getBathroom()
	{
		return this.bathroom;
	}
	
	public Room getKitchen()
	{
		return this.kitchen;
	}
	
	//the different equipments
	private Equipement solarPanel;
	private Thermostat thermostat;
	
	public Equipement getSolorPanel()
	{
		return this.solarPanel;
	}
	
	public Thermostat getThermostat()
	{
		return this.thermostat;
	}
	
	//the differents parameters
	private float m_temperature;
	private float m_humidity;
	
	public float getTemperature()
	{
		return this.m_temperature;
	}
	
	public float getHumidity()
	{
		return this.m_humidity;
	}
	
	public void addTemperature(float temp)
	{
		this.m_temperature += temp;
	}

	public void addHumidity(float hum)
	{
		this.m_humidity += hum;
	}
	
	public Home()
	{
		this.bathroom = new Bathroom();
		this.bedroom = new Bedroom();
		this.kitchen = new Kitchen();
		this.livingroom = new Livingroom();
		
		this.m_humidity = 40;
		this.m_temperature = 19;
		
		this.solarPanel = new Equipement(10000);
		this.thermostat = new Thermostat (this.m_temperature);
	}
	
	public void upgradeParameters(Room room)
	{
		room.getEquipment().upgradeLevel();	
	}
	
	public double temperatureBill()
	{
		double amountDue = (this.thermostat.getTemperature() - this.m_temperature)*10;
		return (amountDue >= 0) ? amountDue : -amountDue;
	}
	
	public void regulateTemperature()
	{
		float temp = (this.thermostat.getTemperature() - this.m_temperature)/2;
		addTemperature(temp);
	}
	
	public void regulateHumidity()
	{
		this.m_humidity = 40;
		Room rooms[] = {this.bathroom, this.bedroom, this.kitchen, this.livingroom};
		for(int i = 0; i<4; i++)
		{
			float hum = (rooms[i].getViewState()) ? 10 : 0;
			addHumidity(hum);
		}
	}
	
	public double getBill()
	{
		double amount = 0;
		amount += this.temperatureBill();
		
		Room rooms[] = {this.bathroom, this.bedroom, this.kitchen, this.livingroom};
		for(int i = 0; i<4; i++)
		{
			amount += rooms[i].getBill();
		}
		
		return amount;
	}
	
	public void seNourrir()
	{
		if(!this.kitchen.active)
			this.kitchen.switchActivity();
	}
	
	public void faireLaSieste()
	{
		if(!this.bedroom.active)
			this.bedroom.switchActivity();
	}
	
	public void jouerPs4()
	{
		if(!this.livingroom.active)
			this.livingroom.switchActivity();
	}
	
	public void prendreUnBain()
	{
		if(!this.bathroom.active)
			this.bathroom.switchActivity();
	}
	
	//Ajouter également une relation entre l'ouverture des fenetres et la météo
	
}
