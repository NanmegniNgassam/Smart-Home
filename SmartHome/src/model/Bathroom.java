package model;

public class Bathroom extends Room
{
	private Equipement bathTube;
	
	public Bathroom()
	{
		this.bathTube = new Equipement(1000);
	}
	
	public Equipement getEquipement()
	{
		return this.bathTube;
	}
	
	@Override
	public double getBill() {
		return readyBill(this.bathTube);
	}

	@Override
	public Equipement getEquipment() {
		return this.bathTube;
	}

}
