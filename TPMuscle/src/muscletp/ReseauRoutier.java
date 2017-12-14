package muscletp;

import java.util.ArrayList;
import java.util.Scanner;



public class ReseauRoutier {

	private ArrayList<MorceauRoute> sesRoutes;
	private ArrayList<Jonction> listeJonctions = new ArrayList<Jonction>(); 
	private ArrayList<Capteur> sesCapteurs = new ArrayList<Capteur>();
	private ArrayList<ElementRegulation> listeElementsRegulation = new ArrayList<ElementRegulation>();
	private int nbVoitures = 0;
	private ArrayList<Voiture> sesVoitures;
	
	//Bloc d'initialisation
	{
		sesVoitures = new ArrayList<Voiture>();
		sesRoutes = new ArrayList<MorceauRoute>();
	}
	
	public ArrayList<MorceauRoute> getSesRoutes() 

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
				//barriere.getSesSegments().add(s7);
				this.sesRoutes.add(barriere);
				
				//Creation de la jonction : un carrefour en T
				Carrefour carrefour1 = new Carrefour(s7,s8,s6);
				//carrefour1.getSesSegments().add(s7);
				//carrefour1.getSesSegments().add(s6);
				//carrefour1.getSesSegments().add(s8);
				this.sesRoutes.add(carrefour1);
				
				SegmentRoute s5 = new SegmentRoute(5, 2); 
				SegmentRoute s4 = new SegmentRoute(4,5);
				this.sesRoutes.add(s5);
				this.sesRoutes.add(s4);
				Carrefour carrefour2 = new Carrefour(s6,s4,s5);
				this.sesRoutes.add(carrefour2);
				
				SegmentRoute s1 = new SegmentRoute(1, 4); 
				this.sesRoutes.add(s1);
				JonctionSimple js1 = new JonctionSimple(s1, s5,false);
				this.sesRoutes.add(js1);

				
				SegmentRoute s3 = new SegmentRoute(3, 7); 
				this.sesRoutes.add(s3);
				JonctionSimple js2 = new JonctionSimple(s3, s4,true);
				this.sesRoutes.add(js2);
				
				SegmentRoute s2 = new SegmentRoute(2, 3); 
				this.sesRoutes.add(s2);
				Carrefour carrefour4 = new Carrefour (s8,s3,s1,s2);
				this.sesRoutes.add(carrefour4);

				s1.getSesJonctions().add(js1);
				s1.getSesJonctions().add(carrefour4);
				
				s2.getSesJonctions().add(barriere);
				s2.getSesJonctions().add(carrefour4);
				
				s3.getSesJonctions().add(js2);
				s3.getSesJonctions().add(carrefour4);
				
				s4.getSesJonctions().add(carrefour2);
				s4.getSesJonctions().add(js2);
				
				s5.getSesJonctions().add(carrefour2);
				s5.getSesJonctions().add(js1);
				
				s6.getSesJonctions().add(carrefour1);
				s6.getSesJonctions().add(carrefour2);
				
				s7.getSesJonctions().add(carrefour1);
				s7.getSesJonctions().add(barriere);
				
				s8.getSesJonctions().add(carrefour4);
				s8.getSesJonctions().add(carrefour1);
				
				//On ajoute les jonctions aux réseaux routiers
				this.listeJonctions.add(js1);
				this.listeJonctions.add(js2);
				this.listeJonctions.add(barriere);
				this.listeJonctions.add(carrefour1);
				this.listeJonctions.add(carrefour2);
				this.listeJonctions.add(carrefour4);
				
				//Placement des capteurs
				this.placementCapteur();
		

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
	
	public int random(int max, int min)
	{
		int result = (int) (Math.random() * (max - min)) + min;
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
						if(random(2,0)==0)
						{
							ajouterVoiture(v, 1, s, 1);
						}
						else
						{
							ajouterVoiture(v, -1, s, ((SegmentRoute) s).getLongueur());
						}
						
						
					}
				}
				
			}
			
			//Initialisation de sa vitesse
			v.setVitesseCourante(random(10, 1));
			
			//System.out.println("La voiture : "+v.getIdentifiant() + " se place dans le segment n°"+ ((SegmentRoute)v.getMorceauRoute()).getId() +" à la position :"+v.getPosition()+ " dans le sens : "+v.getSens()+ " avec la vitesse : "+v.getVitesseCourante());
			
		}
		
	}
	
	public void placementCapteur()
	{
		ElementRegulation er1 = new ElementRegulation();
		CapteurPresence cp1 = new CapteurPresence(er1,getSegmentWithId(1), -1, 2);
		sesCapteurs.add(cp1);
		er1.getSesCapteurs().add(cp1);
		
		getSegmentWithId(1).getSesCapteurs().add(cp1);
		
		CapteurPresence cp2 = new CapteurPresence(er1,getSegmentWithId(4), -1, 2);
		sesCapteurs.add(cp2);
		er1.getSesCapteurs().add(cp2);
		getSegmentWithId(1).getSesCapteurs().add(cp2);
		
		ElementRegulation er2 = new ElementRegulation();
		CapteurVitesse cv1 = new CapteurVitesse(er2, getSegmentWithId(3), 1, 3,2);
		sesCapteurs.add(cv1);
		er2.getSesCapteurs().add(cv1);
		getSegmentWithId(3).getSesCapteurs().add(cv1);
	
	}
	
	public MorceauRoute getSegmentWithId(int id)
	{

			for(MorceauRoute s : sesRoutes)
			{
				if(s.type.equals("Segment"))
				{
					if(((SegmentRoute) s).getId() == id)
					{
						return s;
					}
				}

			}
			
			return null;
	}
	

	/*Cette methode permet de mettre a jour la couleur des feux a chaque intervalle*/
	
	public void majCouleurFeux(){
		for(int i =0; i<this.sesRoutes.size(); i++){
			for(int j=0; j<(this.sesRoutes.get(i)).sesSemaphores.size(); j++){
				//Si le semaphore est un Feu
				if((this.sesRoutes.get(i)).sesSemaphores.get(j).getType()=="FeuxTricolore" || (this.listeElementsRegulation.get(i)).sesSemaphores.get(j).getType()=="FeuxBicolore"){
					//Si la couleur actuelle du feu est ROUGE, on agit differement si le feu est Tricolore ou Bicolore
					if(((Feux)this.sesRoutes.get(i).sesSemaphores.get(j)).getCouleurActuelle()==Couleur.ROUGE)
					{
						if(((this.sesRoutes.get(i)).sesSemaphores.get(j).getType()=="FeuxTricolore"))
						{
							((FeuxTricolore)this.sesRoutes.get(i).sesSemaphores.get(j)).attribueCouleurVerte();
							System.out.println("Le feu du segment n°"+((SegmentRoute) this.sesRoutes.get(i)).getId()+" passe au vert");
						}
						else{
							//C'est un feuBicolore on passe du ROUGE a l'ORANGE
							((FeuxBicolore)this.sesRoutes.get(i).sesSemaphores.get(j)).attribueCouleurOrange();
							System.out.println("Le feu bicolore du segment n°"+((SegmentRoute) this.sesRoutes.get(i)).getId()+" passe à l'orange");
						}
					}
					//Si la couleur actuelle du feu est VERT 
					else if(((Feux)this.sesRoutes.get(i).sesSemaphores.get(j)).getCouleurActuelle()==Couleur.VERT)
					{
						((FeuxTricolore)this.sesRoutes.get(i).sesSemaphores.get(j)).attribueCouleurOrange();
						System.out.println("Le feu du segment n°"+((SegmentRoute) this.sesRoutes.get(i)).getId()+" passe à l'orange");
					}
					else if(((Feux)this.sesRoutes.get(i).sesSemaphores.get(j)).getCouleurActuelle()==Couleur.ORANGE)
					{
						((FeuxTricolore)this.sesRoutes.get(i).sesSemaphores.get(j)).attribueCouleurRouge();
						System.out.println("Le feu du segment n°"+((SegmentRoute) this.sesRoutes.get(i)).getId()+" passe au rouge");
					}	
				}
			}
		}
	}
	
	public void etatVoitures()
	{
		for(Voiture v : sesVoitures)
		{
			System.out.println(v.toString());
			System.out.println("");
		}
	}
	
	public void gestionIntervalles()
	{
		Scanner sc = new Scanner(System.in);;
		int intervalle =1;
		
		System.out.println("Pour démarrer l'intervalle n°"+intervalle+" appuyez sur go");
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
		//Tout d'abord on active les detecteur de presene
		
		//Ensuite on incrémente de la vitesse
		System.out.println("Etat du réseau avant l'intervalle\n");
		etatVoitures();
		deplacementVoiture();
		System.out.println("Etat du réseau après l'intervalle\n");
		etatVoitures();
		//Premierement deplacer toutes les voitures du reseau de leur vitesse
		//Activer les sémaphore selon les infos recoltees
		//Détecter les collisions
		
	}
	
	public void ajouterVoiture(Voiture v, int sens, MorceauRoute morceau, int position)
	{
		//On ajoute un sens
		v.setSens(sens);
		//On renseigne le segment à la voiture
		v.setMorceauRoute(morceau);
		//On ajoute à la liste de voiture du segment
		morceau.getSesVoitures().add(v);
		//On lui ajoute une position
		v.setPosition(position);
		//this.getSesVoitures().add(v);
	}
	
	public void deplacementVoiture()
	{
		System.out.println("Déplacement des voitures\n");
		for(Voiture v : sesVoitures)
		{
			v.deplacerVoiture(sesCapteurs);
		}

	}
	
	public int randomVoiture()
	{
		int result = (int) (Math.random() * (8 - 2)) + 2;
		return result;
	}
	

	
	
	public static void main(String[] args)
	{

		ReseauRoutier r = new ReseauRoutier();
		
		System.out.println("Création du réseau routier...\n");
		
		//Creation du réseau routier
		r.creationReseau();
		
		//Calcul du nombre de voitures sur le reseau

		r.setNbVoitures(r.random(9,2));

		System.out.println("Le programme va intégrer "+r.getNbVoitures()+" voitures au réseau routier\n");
		
		//Creation et repartition des voitures sur le reseau routier
		r.insertionVoitures();
		
		//Demarrage des intervalles
		r.gestionIntervalles();
	
	}
}


