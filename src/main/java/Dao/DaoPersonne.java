package Dao;

import java.util.List;

import Model.Eleve;
import Model.Formateur;
import Model.Personne;

public interface DaoPersonne extends DaoGeneric<Personne, Integer>{
	public List<Formateur> findAllFormateur();
	public List<Eleve> findAllEleve();

}
