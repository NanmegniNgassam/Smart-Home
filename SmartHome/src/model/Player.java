package model;

public class Player 
{
	private String m_name;
	private double m_money;
	private int m_level;

	private GameManager m_master;
	
	public Player()
	{
		this.m_name = "Gilles";
		this.m_money = 2000.0;
		this.m_level = 1;
	}
	
	public Player(String name, double money, int level)
	{
		this.m_name = name;
		this.m_money = money;
		this.m_level = level;
	}
	
	public double getMoney()
	{
		return this.m_money;
	}
	
	public void addMoney(double amount)
	{
		if (amount >= 0)
			this.m_money += amount;
	}
	
	public int getLevel()
	{
		return this.m_level;
	}
	
	public void upgradeLevel()
	{
		this.m_level += 1;
	}
	
	
	
	public void payerFacture(int billAmount)
	{
		if(this.m_money > billAmount && billAmount>=0)
		{
			this.m_money = this.m_money - billAmount;
		}
		else
		{
			this.m_money = 0;
		}
		
		System.out.println("Paiement des factures de la maison - nouveau solde : " + getMoney() + "EUROS");
	}
	
	public void interactWithView()
	{

	}
	
	public void interactWithLight()
	{
		
	}
	
	public void interactWithThermostat()
	{
		
	}
	
	public void upgradeEquipment(Equipement equipement)
	{
		
	}
	
	
}
