package model;

public class Livingroom extends Room
{
	private Equipement TV;
	
	public Livingroom()
	{
		this.TV = new Equipement(2000);
	}
	
	public Equipement getEquipement()
	{
		return this.TV;
	}
	
	@Override
	public double getBill()
	{
		return readyBill(this.TV);
	}

	@Override
	public Equipement getEquipment() {
		return this.TV;
	}

	
	
}
