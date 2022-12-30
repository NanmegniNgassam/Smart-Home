package views;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import model.Home;


public class Main {

	public static void main(String[] args) throws UnsupportedLookAndFeelException 
	{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		//SmartHomeView landingPage = new SmartHomeView();
		
		Home pavel = new Home();
		pavel.seNourrir();
		pavel.getThermostat().setTemperature(34);
		
		System.out.println("Etat de la cuisine :" + pavel.getKitchen().getActivity());
		
		System.out.println("Electricity bill :" + pavel.temperatureBill());
		System.out.println("Your house cost you " + pavel.getBill() + " Euros");
		
	}

}
