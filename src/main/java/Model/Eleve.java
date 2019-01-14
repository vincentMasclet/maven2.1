package Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity // annotation à ajouter 
@DiscriminatorValue(value="E")
public class Eleve extends Personne {
	
	@OneToOne
	@JoinColumn(name= "ordinateur")
	private Ordinateur ordi;
	@ManyToOne
	@JoinColumn(name="formateur_id")  // ajoute physiquement une colonne dans la table Eleve 
	private Formateur formateur;
	// Constructeurs

	public Eleve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Eleve(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}
	
	// Méhodes 
	
	public Ordinateur getOrdi() {
		return ordi;
	}

	public void setOrdi(Ordinateur ordi) {
		this.ordi = ordi;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	
	

}
