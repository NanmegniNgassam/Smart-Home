package model;

public class Thermostat extends Equipement 
{
	private float temperature;
	
	public float getTemperature()
	{
		return this.temperature;
	}
	
	public void setTemperature(float temp)
	{
		this.temperature = temp;
	}
	
	public Thermostat(float temp)
	{
		super(0);
		this.temperature = temp;
	}
	
	

}
