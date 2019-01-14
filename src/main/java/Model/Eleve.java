package Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity // annotation à ajouter 
@DiscriminatorValue(value="E")
public class Eleve extends Personne {

	public Eleve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Eleve(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}
	
	

}
