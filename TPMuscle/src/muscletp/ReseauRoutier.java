package muscletp;

import java.util.ArrayList;
import java.util.Scanner;


public class ReseauRoutier {

	private ArrayList<MorceauRoute> sesRoutes;
	private ArrayList<Jonction> listeJonctions = new ArrayList<Jonction>(); 
	private ArrayList<ElementRegulation> listeElementsRegulation = new ArrayList<ElementRegulation>();
	private int nbVoitures = 0;
	private ArrayList<Voiture> sesVoitures;
	
	//Bloc d'initialisation
	{
		sesVoitures = new ArrayList<Voiture>();
		sesRoutes = new ArrayList<MorceauRoute>();
	}

	public ArrayList<? extends MorceauRoute> getSesRoutes() 
	{
		return sesRoutes;
	}
	public void setSesRoutes(ArrayList<MorceauRoute> sesRoutes) 
	{
		this.sesRoutes = sesRoutes;
	}
	
	public ArrayList<Jonction> getListeJonctions() {
		return listeJonctions;
	}
	public void setListeJonctions(ArrayList<Jonction> listeJonctions) {
		this.listeJonctions = listeJonctions;
	}
	public ArrayList<ElementRegulation> getListeElementsRegulation() {
		return listeElementsRegulation;
	}
	public void setListeElementsRegulation(ArrayList<ElementRegulation> listeElementsRegulation) {
		this.listeElementsRegulation = listeElementsRegulation;
	}
	public int getNbVoitures() {
		return nbVoitures;
	}
	public void setNbVoitures(int nbVoitures) {
		this.nbVoitures = nbVoitures;
	}
	public ArrayList<Voiture> getSesVoitures() {
		return sesVoitures;
	}
	public void setSesVoitures(ArrayList<Voiture> sesVoitures) {
		this.sesVoitures = sesVoitures;
	}
	public void creationReseau() //Ne pas oublier d'ajouter les feux, radars ...
	{
		//Le detail de notre resau est en annexe. 
		//Il sera constitue d'une barriere, deux passages pietons, deux carrefours en T et un a 4 voies
		
		//Creation des trois segments de routes
		SegmentRoute s7 = new SegmentRoute(7, 2); 
		SegmentRoute s6 = new SegmentRoute(6,8);
		SegmentRoute s8 = new SegmentRoute(8,2);
		this.sesRoutes.add(s7);
		this.sesRoutes.add(s6);
		this.sesRoutes.add(s8);
		

		
		//Creation de la barriere
		Barriere barriere = new Barriere(s7);
		barriere.getSesSegments().add(s7);
		s7.getSesJonctions().add(barriere);
		this.sesRoutes.add(barriere);
		
		//Creation de la jonction : un carrefour en T
		Carrefour3 carrefour1 = new Carrefour3(s7,s8,s6);
		carrefour1.getSesSegments().add(s7);
		carrefour1.getSesSegments().add(s6);
		carrefour1.getSesSegments().add(s8);
		this.sesRoutes.add(carrefour1);
		s7.getSesJonctions().add(carrefour1);
		s6.getSesJonctions().add(carrefour1);
		s8.getSesJonctions().add(carrefour1);
		
		SegmentRoute s5 = new SegmentRoute(5, 2); 
		SegmentRoute s4 = new SegmentRoute(4,5);
		this.sesRoutes.add(s5);
		this.sesRoutes.add(s4);
		Carrefour3 carrefour2 = new Carrefour3(s6,s4,s5);
		s6.getSesJonctions().add(carrefour2);
		s4.getSesJonctions().add(carrefour2);
		s5.getSesJonctions().add(carrefour2);
		carrefour2.getSesSegments().add(s6);
		carrefour2.getSesSegments().add(s4);
		carrefour2.getSesSegments().add(s5);
		this.sesRoutes.add(carrefour2);
		
		SegmentRoute s1 = new SegmentRoute(1, 4); 
		this.sesRoutes.add(s1);
		JonctionSimple js1 = new JonctionSimple(s1, s5);
		this.sesRoutes.add(js1);
		js1.getSesSegments().add(s1);
		js1.getSesSegments().add(s5);
		s1.getSesJonctions().add(js1);
		s5.getSesJonctions().add(js1);
		
		SegmentRoute s3 = new SegmentRoute(3, 7); 
		this.sesRoutes.add(s3);
		JonctionSimple js2 = new JonctionSimple(s3, s4);
		this.sesRoutes.add(js2);
		js2.getSesSegments().add(s3);
		js2.getSesSegments().add(s4);
		s3.getSesJonctions().add(js2);
		s4.getSesJonctions().add(js2);
		
		SegmentRoute s2 = new SegmentRoute(2, 3); 
		this.sesRoutes.add(s2);
		Carrefour4 carrefour3 = new Carrefour4 (s8,s3,s1,s2);
		this.sesRoutes.add(carrefour3);
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
		
		/*System.out.println("Affichage de la route");
		for(Jonction j : this.listeJonctions)
		{
			System.out.println("Jonction n°"+j.getId() + " Type : "+ j.getType() +" : ");
			for(SegmentRoute s : j.getSesSegments())
			{
				System.out.println("Segment n° :"+s.getId());
			}
		}*/
	}
	
	public int randomVoiture()
	{
		int result = (int) (Math.random() * (8 - 2)) + 2;
		return result;
	}
	
	/**
	 * Cette methode va inserer les voitures sur la routes
	 */
	public void insertionVoitures()
	{

		for(int i=0;i<this.getNbVoitures();i++)
		{
			Voiture v = new Voiture();
			
			//Ajout de la voiture dans la liste des voitures du reseau routier
			this.getSesVoitures().add(v);
			
			//Ajout de la voiture dans un segment de route
			for(MorceauRoute s : sesRoutes)
			{
				if(s.getType().equals("Segment"))
				{
					//Chaque voiture commencera sur le segment qui porte le même identifiant
					if(((SegmentRoute) s).getId() == v.getIdentifiant())
					{
						//On ajoute un sens
						v.setSens(1);
						//On renseigne le segment à la voiture
						v.setMorceauRoute(s);
						//On ajoute à la liste de voiture du segment
						((SegmentRoute) s).getSesVoitures().add(v);
						//On lui ajoute une position
						v.setPosition(1);
						
						System.out.println("La voiture : "+v.getIdentifiant() + " se place dans le segment n°"+ ((SegmentRoute) s).getId() +" à la position :"+v.getPosition()+ " dans le sens : "+v.getSens());
						
					}
				}
				
			}
			
		}
		
		
	}
	
	public void gestionIntervalles()
	{
		Scanner sc = new Scanner(System.in);;
		int intervalle =1;
		
		System.out.println("\nPour démarrer l'intervalle : "+intervalle+" appuyez sur go");
		String reponse = sc.nextLine();
		while(!(reponse.equals("go")))
		{
			System.out.println("Seulement le go est accepté l'ami !");
			reponse = sc.nextLine();
		}
		
		System.out.println("Déroulement de l'intervalle n°"+intervalle);
		intervalle();
		intervalle++;
		
	}
	
	public void intervalle()
	{
		//Premierement deplacer toutes les voitures du reseau de leur vitesse
		//Activer les sémaphore selon les infos recoltees
		//Détecter les collisions
		
	}
	
	public static void main(String[] args)
	{

		ReseauRoutier r = new ReseauRoutier();
		
		System.out.println("Création du réseau routier...\n");
		
		//Creation du réseau routier
		r.creationReseau();
		
		//Calcul du nombre de voitures sur le reseau
		r.setNbVoitures(r.randomVoiture());
		System.out.println("Le programme va intégrer "+r.getNbVoitures()+" voitures au réseau routier\n");
		
		//Creation et repartition des voitures sur le reseau routier
		r.insertionVoitures();
		
		//Demarrage des intervalles
		r.gestionIntervalles();
	
	}
}


