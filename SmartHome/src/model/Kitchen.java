package model;

public class Kitchen extends Room
{
	private Equipement oven;
	
	public Kitchen()
	{
		this.oven = new Equipement(2000);
	}
	
	public Equipement getEquipement()
	{
		return this.oven;
	}
	
	@Override
	public double getBill() {
		return readyBill(this.oven);
	}

	@Override
	public Equipement getEquipment() {
		return this.oven;
	}
	
}
