package muscletp;

import java.util.ArrayList;


public abstract class Capteur {
	/* Un capteur est plac� sur un troncon de route et associ� a un element de regulation */
	
	protected ArrayList<ObserverCapteurVitesse> observers = new ArrayList<>();
	
	protected ElementRegulation elemRegulationAssocie;
	protected MorceauRoute sonMorceauRoute;
	protected int sonSens;
	protected int saPosition;
	protected String type;

	public Capteur(ElementRegulation sonElementRegulation, MorceauRoute sonMorceauRoute, int sonSens, int saPosition)
	{
		this.elemRegulationAssocie = sonElementRegulation;
		this.sonMorceauRoute = sonMorceauRoute;
		this.sonSens = sonSens;
		this.saPosition = saPosition;
	}


	public ElementRegulation getElemRegulationAssocie() 
	{
		return elemRegulationAssocie;
	}

	public void setElemRegulationAssocie(ElementRegulation elemRegulationAssocie) 
	{
		this.elemRegulationAssocie = elemRegulationAssocie;
	}

	public MorceauRoute getSonMorceauRoute() 
	{
		return sonMorceauRoute;
	}
	
	public void setSonMorceauRoute(MorceauRoute mr) 
	{
		this.sonMorceauRoute = mr;
	}

	public int getSonSens() {
		return sonSens;
	}

	public void setSonSens(int sonSens) {
		this.sonSens = sonSens;
	}

	public int getSaPosition() {
		return saPosition;
	}

	public void setSaPosition(int saPosition) {
		this.saPosition = saPosition;
	}

}
