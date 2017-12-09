package muscletp;

import java.util.ArrayList;

public class Carrefour4 extends Carrefour
{
	
	SegmentRoute sNord;
	SegmentRoute sSud ;
	SegmentRoute sEst;
	SegmentRoute sOuest;
	
	public Carrefour4 (SegmentRoute s1, SegmentRoute s2, SegmentRoute s3, SegmentRoute s4)
	{
		super();
		this.sNord = s1 ;
		this.sSud = s2 ;
		this.sEst = s3 ;
		this.sOuest = s4;
		this.type = "Carrefour4";

	}
	
	public Carrefour4 (SegmentRoute s1, SegmentRoute s2, SegmentRoute s3, SegmentRoute s4, int id)
	{
		super(id);
		this.sNord = s1 ;
		this.sSud = s2 ;
		this.sEst = s3 ;
		this.sOuest = s4;
		this.type = "Carrefour4";

	}

	public SegmentRoute getsNord() {
		return sNord;
	}


	public void setsNord(SegmentRoute sNord) {
		this.sNord = sNord;
	}


	public SegmentRoute getsSud() {
		return sSud;
	}


	public void setsSud(SegmentRoute sSud) {
		this.sSud = sSud;
	}


	public SegmentRoute getsEst() {
		return sEst;
	}


	public void setsEst(SegmentRoute sEst) {
		this.sEst = sEst;
	}


	// Cette methode permettra de choisir aleatoirement le segment sur lequel la voiture continuera
	// de rouler
	public SegmentRoute choixRoute(Voiture v)
	{
		// Le choix de route se fait de maniere aleatoire
		int min = 0;
		int max = getSesSegments().size()-1;
		int random = (int)(Math.random() * (max-min)) + min;
		return getSesSegments().get(random);
	}
	
	public static void main(String[] args){
		Voiture v = new Voiture();
		
		SegmentRoute s = new SegmentRoute();
		SegmentRoute s2 = new SegmentRoute();
		SegmentRoute s3 = new SegmentRoute();
		Carrefour3 c = new Carrefour3(s,s2,s3);
		c.getSesSegments().add(s);
		c.getSesSegments().add(s2);
		c.getSesSegments().add(s3);
		
		System.out.println(c.choixRoute(v));
		
		PositionVoiture pV = new PositionVoiture();
		pV.setPosition(34.0);
		pV.setSegmentRoute(s2);
		pV.getPosition();
		}
	}
