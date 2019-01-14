package App;

import Dao.DaoCompetence;
import Dao.DaoCompetenceFactory;
import Dao.DaoOrdianteur;
import Dao.DaoOrdinateurFactory;
import Dao.DaoPersonne;
import Dao.DaoPersonneFactory;
import Model.Competence;
import Model.Eleve;
import Model.Formateur;
import Model.Ordinateur;
import Model.Personne;
import util.Context;

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Competence c = new Competence("voir l'avenir");
		DaoCompetence compe = DaoCompetenceFactory.getCompetenceFactory();
		
		compe.insert(c);
		
		Ordinateur o = new Ordinateur("pech", 56);
		
		DaoOrdianteur ordi = DaoOrdinateurFactory.getOrdinateurFactory();
		
		Personne p = new Eleve("chuck", "noris");
		DaoPersonne per = DaoPersonneFactory.getInstance();
		per.insert(p);
		
		//
		Context.close();
	}

}
