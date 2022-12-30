package model;

public abstract class Room 
{
	protected boolean viewState;
	protected boolean lightState;
	protected boolean active;
	
	public Room()
	{
		this.active = false;
		this.viewState = false;
		this.lightState = false;
	}
	
	public boolean getViewState()
	{
		return this.viewState;
	}
	
	public void openView()
	{
		this.viewState = true;
	}
	
	public boolean getLightState()
	{
		return this.lightState;
	}
	
	public void onLight()
	{
		this.lightState = true;
	}
	
	public void switchLight()
	{
		this.lightState = !(this.lightState);
	}
	
	public void interactWithView()
	{
		this.viewState = !(this.viewState);
	}
	
	public boolean getActivity()
	{
		return this.active;
	}
	
	public void switchActivity()
	{
		this.onLight();
		this.active = !(this.active);
	}
	
	public double readyBill(Equipement equip) 
	{
		double expenses = 0;
		
		//Eventuel ajout de la consommation de l'appareil de la piece
		if(this.active)
			expenses = (equip.getPrice())/100;
		
		expenses = expenses/equip.getLevel();
		
		//Eventuel ajout de la consommation des lumières
		expenses += (this.getLightState()) ? 2 : 0;
		return expenses;
	}
	
	public abstract double getBill();
	public abstract Equipement getEquipment();
}
