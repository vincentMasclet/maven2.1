package Model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Embeddable
public class EnseignementPk implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="formateur_pk")
	private Formateur formateur;
	@ManyToOne
	@JoinColumn(name= "competence_pk")
	private Competence competence;
	
	
	
	public EnseignementPk() {
		super();
	}



	public Formateur getFormateur() {
		return formateur;
	}



	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}



	public Competence getCompetence() {
		return competence;
	}



	public void setCompetence(Competence competence) {
		this.competence = competence;
	}



	public EnseignementPk(Formateur formateur, Competence competence) {
		super();
		this.formateur = formateur;
		this.competence = competence;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competence == null) ? 0 : competence.hashCode());
		result = prime * result + ((formateur == null) ? 0 : formateur.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnseignementPk other = (EnseignementPk) obj;
		if (competence == null) {
			if (other.competence != null)
				return false;
		} else if (!competence.equals(other.competence))
			return false;
		if (formateur == null) {
			if (other.formateur != null)
				return false;
		} else if (!formateur.equals(other.formateur))
			return false;
		return true;
	}
	
	

}
