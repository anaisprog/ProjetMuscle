package muscletp;

import java.util.ArrayList;
import java.util.Collection;

public class ReseauRoutier {
	//Penser � la g�n�ricit� si besoin
	private ArrayList<? extends MorceauRoute> sesRoutes;

	public ArrayList<? extends MorceauRoute> getSesRoutes() {
		return sesRoutes;
	}
	public void setSesRoutes(ArrayList<? extends MorceauRoute> sesRoutes) {
		this.sesRoutes = sesRoutes;
	}
}
