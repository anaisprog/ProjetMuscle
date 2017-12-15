package muscletp;

import java.util.ArrayList;
import java.util.Scanner;



public class ReseauRoutier {

	private ArrayList<MorceauRoute> sesRoutes;
	private ArrayList<Jonction> listeJonctions = new ArrayList<Jonction>(); 
	private ArrayList<Capteur> sesCapteurs = new ArrayList<Capteur>();
	private ArrayList<ElementRegulation> listeElementsRegulation = new ArrayList<ElementRegulation>();
	private ArrayList<Semaphore> sesSemaphores = new ArrayList<Semaphore>();
	private int nbVoitures = 0;
	private ArrayList<Voiture> sesVoitures;
	private int intervalle =1;
	Scanner sc = new Scanner(System.in);
	//private ConctructionReseau sonConstructeur;
	
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
	
	public ArrayList<Semaphore> getSesSemaphores() {
		return sesSemaphores;
	}
	public void setSesSemaphores(ArrayList<Semaphore> sesSemaphores) {
		this.sesSemaphores = sesSemaphores;
	}
	public void creationReseau() //Ne pas oublier d'ajouter les feux, radars ...
	{
		//Le detail de notre resau est en annexe. 
		//Il sera constitue d'une barriere, deux passages pietons, deux carrefours en T et un a 4 voies
		
		//Creation des trois segments de routes
				
				SegmentRoute s7 = new SegmentRoute(7, 2, this); 
				SegmentRoute s6 = new SegmentRoute(6,8, this);
				SegmentRoute s8 = new SegmentRoute(8,2,this);
				
				//Creation de la barriere
				Barriere barriere = new Barriere(this,s7);
				barriere.getSesSegments().add(s7);
				
				//Creation de la jonction : un carrefour en T
				Carrefour carrefour1 = new Carrefour(this,s7,s8,s6);

				SegmentRoute s5 = new SegmentRoute(5, 2, this); 
				SegmentRoute s4 = new SegmentRoute(4,5, this);
				Carrefour carrefour2 = new Carrefour(this,s6,s4,s5);
				//this.sesRoutes.add(carrefour2);
				
				SegmentRoute s1 = new SegmentRoute(1, 4, this); 
				//this.sesRoutes.add(s1);
				JonctionSimple js1 = new JonctionSimple(this,s1, s5,false);
				//this.sesRoutes.add(js1);
				
				SegmentRoute s3 = new SegmentRoute(3, 5, this); 

				ElementRegulation er2 = new ElementRegulation();
				
				//On ajoute sur cette jonction un capteur de vitesse
				JonctionSimple js2 = new JonctionSimple(er2,this,s3, s4,true);
				new CapteurVitesse(er2, s3, 1, 3,2);

				
				
				SegmentRoute s2 = new SegmentRoute(2, 3, this); 
				Carrefour carrefour4 = new Carrefour (this,s8,s3,s1,s2);

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
		er1.getSesCapteurs().add(cp1);
		sesCapteurs.add(cp1);
		getSegmentWithId(1).getSesCapteurs().add(cp1);
		
		CapteurPresence cp2 = new CapteurPresence(er1,getSegmentWithId(4), -1, 2);
		sesCapteurs.add(cp2);
		er1.getSesCapteurs().add(cp2);
		getSegmentWithId(1).getSesCapteurs().add(cp2);
		
		//ElementRegulation er2 = new ElementRegulation( ((SegmentRoute) getSegmentWithId(3)).getSesSemaphores());
	
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
	
	public void majCouleurFeux()
	{
		for(Semaphore s : sesSemaphores)
		{
				if((s.getType()=="FeuxTricolore" || (s.getType()=="FeuxBicolore")))
				{
					//Si la couleur actuelle du feu est ROUGE, on agit differement si le feu est Tricolore ou Bicolore
					if(((Feux) s).getCouleurActuelle()==Couleur.ROUGE)
					{
						if((s.getType()=="FeuxTricolore"))
						{
							((FeuxTricolore)s).attribueCouleurVerte();
							System.out.println("Le feu du segment n°"+s.getSegment().getId()+" passe au vert");
						}
						else{
							//C'est un feuBicolore on passe du ROUGE a l'ORANGE
							((FeuxBicolore)s).attribueCouleurOrange();
							System.out.println("Le feu bicolore du segment n°"+(s.getSegment().getId()+" passe à l'orange"));
						}
					}
					//Si la couleur actuelle du feu est VERT 
					else if(((Feux)s).getCouleurActuelle()==Couleur.VERT)
					{
						((FeuxTricolore)s ).attribueCouleurOrange();
						System.out.println("Le feu du segment n°"+(s.getSegment().getId()+" passe à l'orange"));
					}
					else if(((Feux)s).getCouleurActuelle()==Couleur.ORANGE)
					{
						((FeuxTricolore) s).attribueCouleurRouge();
						System.out.println("Le feu du segment n°"+s.getSegment().getId()+" passe au rouge");
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
		
		System.out.println("Pour démarrer l'intervalle n°"+intervalle+" appuyez sur go");
		String reponse = sc.nextLine();
		while(!(reponse.equals("go")))
		{
			System.out.println("Seulement le go est accepté l'ami !");
			reponse = sc.nextLine();
		}
		
		System.out.println("Déroulement de l'intervalle n°"+intervalle);
		intervalle();

		
	}
	
	public void intervalle()
	{
		//Tout d'abord on active les detecteur de presene
		
		//Ensuite on incrémente de la vitesse
		System.out.println("• Etat du réseau avant l'intervalle\n");
		etatVoitures();
		deplacementVoiture();
		System.out.println("• Etat du réseau après l'intervalle\n");
		etatVoitures();
		System.out.println("• Mise à jour des feux \n");
		majCouleurFeux();
		intervalle++;
		gestionIntervalles();
		
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
		System.out.println("• Déplacement des voitures\n");
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
		
		System.out.println("******Création du réseau routier******\n");
		
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


