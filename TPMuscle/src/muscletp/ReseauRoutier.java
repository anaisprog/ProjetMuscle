package muscletp;

import java.util.ArrayList;
import java.util.Collection;

public class ReseauRoutier {

	private ArrayList<MorceauRoute> sesRoutes;
	private ArrayList<Jonction> listeJonctions = new ArrayList<Jonction>(); 
	private ArrayList<ElementRegulation> listeElementsRegulation = new ArrayList<ElementRegulation>(); ;
	
	

	public ArrayList<? extends MorceauRoute> getSesRoutes() {
		return sesRoutes;
	}
	public void setSesRoutes(ArrayList<MorceauRoute> sesRoutes) 
	{
		this.sesRoutes = sesRoutes;
	}
	
	public void creationReseau() //Ne pas oublier d'ajouter les feux, radars ...
	{
		//Le detail de notre resau est en annexe. 
		//Il sera constitue d'une barriere, deux passages pietons, deux carrefours en T et un a 4 voies
		
		//Creation des deux segments de routes
		SegmentRoute s7 = new SegmentRoute(7); 
		SegmentRoute s6 = new SegmentRoute(6);
		SegmentRoute s8 = new SegmentRoute(8);
		
		//Creation de la barriere
		Barriere barriere = new Barriere(s7);
		barriere.getSesSegments().add(s7);
		s7.getSesJonctions().add(barriere);
		
		//Creation de la jonction : un carrefour en T
		Carrefour3 carrefour1 = new Carrefour3(s7,s8,s6);
		carrefour1.getSesSegments().add(s7);
		carrefour1.getSesSegments().add(s6);
		carrefour1.getSesSegments().add(s8);
		s7.getSesJonctions().add(carrefour1);
		s6.getSesJonctions().add(carrefour1);
		s8.getSesJonctions().add(carrefour1);
		
		SegmentRoute s5 = new SegmentRoute(5); 
		SegmentRoute s4 = new SegmentRoute(4);
		Carrefour3 carrefour2 = new Carrefour3(s6,s4,s5);
		s6.getSesJonctions().add(carrefour2);
		s4.getSesJonctions().add(carrefour2);
		s5.getSesJonctions().add(carrefour2);
		carrefour2.getSesSegments().add(s6);
		carrefour2.getSesSegments().add(s4);
		carrefour2.getSesSegments().add(s5);
		
		SegmentRoute s1 = new SegmentRoute(); 
		JonctionSimple js1 = new JonctionSimple(s1, s5);
		js1.getSesSegments().add(s1);
		js1.getSesSegments().add(s5);
		s1.getSesJonctions().add(js1);
		s5.getSesJonctions().add(js1);
		
		SegmentRoute s3 = new SegmentRoute(3); 
		JonctionSimple js2 = new JonctionSimple(s3, s4);
		js2.getSesSegments().add(s3);
		js2.getSesSegments().add(s4);
		s3.getSesJonctions().add(js2);
		s4.getSesJonctions().add(js2);
		
		SegmentRoute s2 = new SegmentRoute(2); 
		Carrefour4 carrefour3 = new Carrefour4 (s8,s3,s1,s2);
		carrefour3.getSesSegments().add(s8);
		carrefour3.getSesSegments().add(s3);
		carrefour3.getSesSegments().add(s1);
		carrefour3.getSesSegments().add(s2);
		
		//On ajoute les jonctions aux réseaux routiers
		this.listeJonctions.add(js1);
		this.listeJonctions.add(js2);
		this.listeJonctions.add(barriere);
		this.listeJonctions.add(carrefour1);
		this.listeJonctions.add(carrefour2);
		this.listeJonctions.add(carrefour3);
		
		System.out.println("Affichage de la route");
		for(Jonction j : this.listeJonctions)
		{
			System.out.println("Jonction n°"+j.getId() + " Type : "+ j.getType() +" : ");
			for(SegmentRoute s : j.getSesSegments())
			{
				System.out.println("Segment n° :"+s.getId());
			}
		}
	}
	
	public static void main(String[] args)
	{

		ReseauRoutier r = new ReseauRoutier();
		r.creationReseau();
	
	}
}


