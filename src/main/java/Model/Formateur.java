package Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="F")
public class Formateur extends Personne {
	
	@Column(name = "experience")
	private Integer exp;
	@Column(name = "reference")
	private boolean reference;
	@OneToMany(mappedBy="formateur")
	private Set<Eleve> eleves;  // Jpa gere que deux types de collections d'obj: List et Set-> NB: pour un traitement JPA ne peut remonter qu'une List à la fois 
	//@ManyToMany
	//@JoinTable(name="Enseignement", joinColumns=@JoinColumn(name="enseignement_formateur_id"), inverseJoinColumns=@JoinColumn(name="enseignment_competence_id"))
	//private Set<Competence> competences;
	@OneToMany(mappedBy="key, formateur")
	private Set<Enseignement> enseignements;
	
	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formateur(String nom, String prenom, Integer exp, boolean reference) {
		super(nom, prenom);
		this.exp = exp;
		this.reference = reference;
		// TODO Auto-generated constructor stub
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public boolean isReference() {
		return reference;
	}

	public void setReference(boolean reference) {
		this.reference = reference;
	}
/*
	public Set<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}
*/
	public Set<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(Set<Eleve> eleves) {
		this.eleves = eleves;
	}
	
	
	

}
