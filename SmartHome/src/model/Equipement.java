package model;

public class Equipement 
{
	private int m_level;
	private double m_price;
	
	public int getLevel()
	{
		return this.m_level;
	}
	
	public double getPrice()
	{
		return this.m_price;
	}
	
	public Equipement(float price)
	{
		this.m_level = 1;
		this.m_price = price;
	}
	
	public void upgradeLevel()
	{
		this.m_level += 1;
		this.m_price = this.m_price*1.5;
	}
}
