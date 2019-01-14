package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ordinateur")
@SequenceGenerator(name="seqOrdinateur", sequenceName = "seq_Ordinateur", allocationSize = 1, initialValue =1)
public class Ordinateur {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqOrdinateur")
	//private Integer id;
	@Column(name = "code", length =20,nullable=false)
	private String code;
	@Column(name = "nombre_ram", nullable=false)
	private Integer ram;
	
	// Constructeurs	
	public Ordinateur() {
		super();
	}

	public Ordinateur(String code, Integer ram) {
		super();
		this.code = code;
		this.ram = ram;
	}

	// Méthodes
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Ordinateur other = (Ordinateur) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	

}
