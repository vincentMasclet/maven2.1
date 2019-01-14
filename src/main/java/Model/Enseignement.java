package Model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="enseignement")
public class Enseignement {
	
	@EmbeddedId
	private EnseignementPk enseignementpk;
	@Column(name="level", length=50)
	private String level;
	
	
	
	public Enseignement() {
		super();
	}

	public Enseignement(EnseignementPk enseignementpk, String level) {
		super();
		this.enseignementpk = enseignementpk;
		this.level = level;
	}

	public EnseignementPk getEnseignementpk() {
		return enseignementpk;
	}

	public void setEnseignementpk(EnseignementPk enseignementpk) {
		this.enseignementpk = enseignementpk;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enseignementpk == null) ? 0 : enseignementpk.hashCode());
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
		Enseignement other = (Enseignement) obj;
		if (enseignementpk == null) {
			if (other.enseignementpk != null)
				return false;
		} else if (!enseignementpk.equals(other.enseignementpk))
			return false;
		return true;
	}
	

}
