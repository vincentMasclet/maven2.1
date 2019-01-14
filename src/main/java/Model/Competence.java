package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="competence")
@SequenceGenerator(name="seqCompetence", sequenceName = "seq_Competence", allocationSize = 1, initialValue =1)
public class Competence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqCompetence")
	private Long id;
	@Column(name = "nom_competence", length =150,nullable=false)
	private String nom;
	
	
	// Constructeur 
	
	public Competence(String nom) {
		super();
		this.nom = nom;
	}


	public Competence() {
		super();
	}


	// Méthodes 
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Competence other = (Competence) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	 
	
	

}
