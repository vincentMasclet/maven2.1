package Model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="person")
@SequenceGenerator(name="seqPersonne", sequenceName = "seq_person", allocationSize = 1, initialValue =1)
@Inheritance(strategy =InheritanceType.SINGLE_TABLE) // prendre en compte les heritage dans la conception de la DB
@DiscriminatorColumn(name="type", length=1)
public abstract class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqPersonne")
	private Integer id;
	@Column(name = "first_name", length =150,nullable=false)
	private String nom;
	@Column(name = "last_name", length =150,nullable=false)
	private String prenom;
	
	@Enumerated(EnumType.STRING) // annotation pour les enumerations	
	@Column(name = "civilite", length =5,nullable=true)
	private Civilite civilite;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance", nullable=true)
	private Date dateNaissance;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "numero", column =@Column(name="number")),
		@AttributeOverride(name = "rue", column =@Column(name="street", length=90)),
		@AttributeOverride(name = "ville", column =@Column(name="city", length=90)),
		@AttributeOverride(name = "codePostal", column =@Column(name="zipcode", length=90))
	}) // annotation au pluriel prend un tableu en paramètre
	private Adresse adresse;

	
	public Personne() {
		super();
	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
		Personne other = (Personne) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	

}
