package Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="F")
public class Formateur extends Personne {
	
	@Column(name = "experience")
	private Integer exp;
	@Column(name = "reference")
	private boolean reference;
	
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
	
	
	

}
