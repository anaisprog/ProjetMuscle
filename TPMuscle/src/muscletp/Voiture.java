package muscletp;

import java.util.ArrayList;

public class Voiture {
	private ReseauRoutier reseau;
	private int infinity = Integer.MAX_VALUE;
	private int identifiant;
	private double vitesseMax; 
	private MorceauRoute morceauRoute;
	private static int ID = 1;
	private int position;
	private int sens; // 1 ou -1
	private int vitesseCourante; //ETATCOURANT
	int distanceRestante;
	
	public Voiture()
	{
		this.identifiant = ID;
		ID++;
	}
	
	//Ajoute pour les tests: 
	public Voiture(int vitesseMax, MorceauRoute morceauRoute, int position, int sens){
		this.vitesseMax = vitesseMax;
		this.morceauRoute = morceauRoute;
		this.position = position;
		this.sens = sens;

		
	}
		
	public int getVitesseCourante() {
		return vitesseCourante;
	}


	public void setVitesseCourante(int vitesseCourante) {
		this.vitesseCourante = vitesseCourante;
	}
	
	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public void ralentir(){
		this.setVitesseCourante(this.getVitesseCourante()/2);
	}
	

	public void setVitesseMax(double vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	public double getVitesseMax() {
		return vitesseMax;
	}

	public ReseauRoutier getReseau() {
		return reseau;
	}

	public void setReseau(ReseauRoutier reseau) {
		this.reseau = reseau;
	}

	public MorceauRoute getMorceauRoute() {
		return morceauRoute;
	}

	public void setMorceauRoute(MorceauRoute morceauRoute) {
		this.morceauRoute = morceauRoute;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getSens() {
		return sens;
	}

	public void setSens(int sens) {
		this.sens = sens;
	}
	
	//A modifier
	public double calculeVitesseActuelle() {
		/* Si le sémaphore est un feu tricolore on divise par deux la vitesse de la voiture 
		 * dans le cas où le feu est orange
		 * Si le feu est rouge la voiture a une vitesse nulle 
		 * Si le feu est vert elle prend sa vitesse max, s'il y a un panneau de limitation de vitesse ..
		 */
			for(int j = 0; j< this.morceauRoute.sesSemaphores.size(); j++){
			
			if((morceauRoute.sesSemaphores.get(j).getType().equals("FeuxTricolore"))&&((morceauRoute.sesSemaphores.get(j).getSens() == this.sens))) 
			{
				
				if(((FeuxTricolore) morceauRoute.sesSemaphores.get(j)).getCouleurActuelle()==Couleur.ORANGE){
					this.setVitesseCourante((this.getVitesseCourante())/2);
					j++;
				}

				else if(((FeuxTricolore) morceauRoute.sesSemaphores.get(j)).getCouleurActuelle()==Couleur.ROUGE){
					this.setVitesseCourante(0);
					//System.out.println("VITESSE APRES FEU ROUGE" + this.getVitesseCourante());
					j++;
				}
				
				else if(((FeuxTricolore) morceauRoute.sesSemaphores.get(j)).getCouleurActuelle()==Couleur.VERT){
					if(limitationVitesse()){
						this.setVitesseCourante(this.valeurLimitationVitesse());
					}
					else{
						this.setVitesseCourante(this.vitesseCourante);
					}
					//System.out.println("VITESSE APRES FEU VERT" + this.vitesseCourante);
					j++;
				}	
			}
				/* Les voitures doivent respecter les limitations imposées par un panneau 
				 * de limitation de vitesse
				 * On etudie le cas ou il n'y a pas de feux
				 */
			
			else if((morceauRoute.sesSemaphores.get(j).getType().equals("PanneauLimitation"))&&(morceauRoute.sesSemaphores.get(j).sens == this.sens)) {
				if(this.getVitesseCourante()>(((PanneauLimitation) morceauRoute.sesSemaphores.get(j)).getLimitation())){
					this.setVitesseCourante((((PanneauLimitation) morceauRoute.sesSemaphores.get(j)).getLimitation()));
					System.out.println("La nouvelle valeur de vitesse est " + this.getVitesseCourante());
					j++;
				}	
			}
			else{
				this.setVitesseCourante(this.vitesseCourante);
			}
		}
			return this.getVitesseCourante();
	}

	/*Cette methode renvoie true s'il y a une limitation de vitesse a respecter par la voiture*/
	public boolean limitationVitesse() {
		for(int j = 0; j< this.morceauRoute.sesSemaphores.size(); j++){
			if(morceauRoute.sesSemaphores.get(j).getType().equals("PanneauLimitation")){
				return true;
			}
		}
		return false;
	}
	
	/* Methode renvoyant la valeur de la limitation de vitesse s'il y a un panneau*/
	
	public int valeurLimitationVitesse() {
		for(int j = 0; j< this.morceauRoute.sesSemaphores.size(); j++){
			if(morceauRoute.sesSemaphores.get(j).getType().equals("PanneauLimitation")){
				return ((PanneauLimitation)morceauRoute.sesSemaphores.get(j)).getLimitation();
			}
		}
		return infinity;
	}
	
	public void deplacerVoiture(ArrayList<Capteur> capteurs)
	{
		int distanceParcourue = 0;
		int distanceRestante = this.vitesseCourante;
		
		while((distanceParcourue < this.vitesseCourante)&&(distanceRestante != 0))
		{

				//Si il y a de la place, on avance 
				if((sens == 1) && ((this.position) != ((SegmentRoute) this.morceauRoute).getLongueur()))
				{
					this.position++;
					distanceParcourue++;
					distanceRestante--;

					//System.out.println("Tout va bien pour la voiture n°"+this.getIdentifiant());
				}
				else if ((sens == -1) && ((this.position) != 1))
				{
					this.position --;
					distanceParcourue++;
					distanceRestante--;
					//System.out.println("Tout va bien pour la voiture n°"+this.getIdentifiant());
				}

				//Sinon on arrive sur une jonction
				else
				{
					Jonction jCurrent = ((SegmentRoute) this.morceauRoute).prochaineJonction(this.sens);
					//System.out.println("La voiture n°"+this.getIdentifiant()+" arrive sur la jonction n°"+ ((SegmentRoute)(this.morceauRoute)).prochaineJonction(this.sens).getType());
					
					//On regarde de quel type est la jonction
		
					//Cas de la barriere
					if(jCurrent.type.equals("Barriere"))
					{
						position++;
						distanceRestante --;
						distanceParcourue++;
						this.vitesseCourante = 0;
						//TODO notifier qu'une voiture essaye de franchir une barriere
						//System.out.println("CEST UNE BARRIERE \n");		
					}
					//Jonction sans feux
					else if(!estFeu())
					{
						changementSegment(jCurrent);
						if(sens == 1)
						{
							position++;
						}
						else
						{
							position--;
						}
						
						distanceRestante --;
						distanceParcourue++;
					}
					//Il y a un feu sur la jonction
					else if(estFeu())
					{

							//System.out.println("Il y a un feu sur cette jonction : "+jCurrent.getType());
							//On regarde la couleur du feu
							Semaphore s = this.getFeu();
							if(s.getType().equals("FeuxTricolore"))
							{
								if(((FeuxTricolore) s).getCouleurActuelle() == Couleur.VERT)
								{
									System.out.println("La voiture n°"+this.getIdentifiant()+" rencontre un feu vert\n");
									changementSegment(jCurrent);
									if(sens == 1)
									{
										position++;
									}
									else
									{
										position--;
									}
									distanceRestante --;
									distanceParcourue++;
								}
								else if(((FeuxTricolore) s).getCouleurActuelle() == Couleur.ORANGE)
								{
									System.out.println("La voiture n°"+this.getIdentifiant()+" rencontre un feu orange\n");
									changementSegment(jCurrent);
									distanceRestante --;
									distanceParcourue++;
								}
								else //Le feu est rouge
								{
									System.out.println("La voiture n°"+this.getIdentifiant()+" rencontre un feu rouge\n");
									//distanceRestante = 0;
									
								}
								//On met à jour la vitesse
								this.calculeVitesseActuelle();
								
								//this.calculeVitesseActuelle();
							}
							if(s.getType().equals("FeuxBicolore"))
							{
								//TODO
							}

						}
						
					}
					
				detection(capteurs);
				}
		
			if(distanceRestante == 0)
			{
				System.out.println("La voiture n°"+this.identifiant+" a fini d'avancer\n");
			}
				
			}
		
		//System.out.println("La voiture n°"+this.identifiant+" se positionne sur le segment n°"+((SegmentRoute)(this.morceauRoute)).getId()+" en position : "+this.position);
				
	public void detection(ArrayList<Capteur> capteurs)
	{
		for(Capteur c : capteurs)
		{
			if(c.type.equals("Presence"))
			{
				((CapteurPresence) c).detecteVoiture();
			}
			if(c.type.equals("Vitesse"))
			{
				((CapteurVitesse) c).detecteVoiture();
			}
		}
	}
	
	public boolean estFeu()
	{
		for(Semaphore s : ((SegmentRoute) this.morceauRoute).getSesSemaphores())
		{
			if (s.getSens()==this.sens)
			{
				return true;
			}
		}
		return false;
	}
	public Semaphore getFeu()
	{
		for(Semaphore s : ((SegmentRoute) this.morceauRoute).getSesSemaphores())
		{
			if (s.getSens()==this.sens)
			{
				return s;
			}
		}
		return null;
	}
	
	public void changementSegment(Jonction currentJonction)
	{
		boolean alreadyChoosen = false;
		for(SegmentRoute s : currentJonction.getSesSegments())
		{
			if((s.getId() != ((SegmentRoute) this.morceauRoute).getId())&&(!alreadyChoosen))
			{
				alreadyChoosen = true;
				//On enlève la voiture de la liste de voiture actuelle du segment
				this.morceauRoute.getSesVoitures().remove(this);
				//On met à jour le segment courant
				this.morceauRoute = s;
				//On ajoute a la liste du segment sa nouvelle voiture
				s.getSesVoitures().add(this);
				System.out.println("La voiture : "+ this.getIdentifiant()+" tourne sur le segment n°"+s.getId());
				
				if(this.sens == -1)
				{
					//On renseigne la nouvelle positions de la voiture
					this.position = s.getLongueur();
					
				}
				else if(this.sens == 1)
				{
					this.position = 1;
				}
			}
			
			this.distanceRestante--;
			
		}
		
		
	}
	
	@Override
	public String toString()
	{
		return "| Voiture n°"+this.getIdentifiant()+"\n"+"| Son segment : "+ ((SegmentRoute) this.getMorceauRoute()).getId()+"\n"+"| Sa position : "+this.getPosition() +"\n"+"| Sa vitesse : "+this.getVitesseCourante()+"\n"+"| Son sens : "+this.getSens();
	}
	
	
	
}
