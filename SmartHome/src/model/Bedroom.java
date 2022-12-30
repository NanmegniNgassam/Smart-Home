package model;

public class Bedroom extends Room
{
	private Equipement bed;
	
	public Bedroom()
	{
		this.bed = new Equipement(0);
	}
	
	public Equipement getEquipement()
	{
		return this.bed;
	}
	
	@Override
	public double getBill() {
		return readyBill(this.bed);
	}

	@Override
	public Equipement getEquipment() {
		return this.bed;
	}
	
}
